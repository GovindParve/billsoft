package com.bill_soft.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bill_soft.bean.LoginBean;
import com.bill_soft.dto.EmployeeUserDto;
import com.bill_soft.dto.RequestUserDetailsDto;
import com.bill_soft.entity.EmployeeUser;
import com.bill_soft.entity.UserDetails;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.service.LoginService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")


public class LoginContoller implements ErrorController {
	
	@Autowired
	private LoginService  loginservice;
	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	public LoginContoller() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LoginContoller(LoginService loginservice, LoginRepository loginrepository) {
		super();
		this.loginservice = loginservice;
		this.loginrepository = loginrepository;
	}


    // All User Login 
	@PostMapping("/login")
	@ApiResponses(value = {//
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 422, message = "Invalid username/password supplied")})
	public LoginBean login1(//
			@ApiParam("username") @RequestParam String username, //
			@ApiParam("password") @RequestParam String password)  {
		return loginservice.emplogin(username, password);
		
	}
	
	
	@PostMapping("/signIn")
	public ResponseEntity<String> signin(@RequestParam String username,@RequestParam String password)
	{
		return loginservice.getlogin(username,password);
	}
	
	//Only Superadmin, Organization and Admin Creation API
	// roles - super-admin, oragnization , admin
	
	@PostMapping("/Signup")
	public ResponseEntity<Object> addadminoragnization(@RequestBody RequestUserDetailsDto requserDetails)
	{
    	return loginservice.addadminoragnization(requserDetails);
	}

	// Employee User creation API
	@PostMapping("/addUser")
	public String adduserdetail(@RequestBody EmployeeUserDto employeeuserdto)
	{
	 String str= loginservice.adduserdetail(employeeuserdto);
	 return str;
		
	}
	
	@GetMapping("/getUserList")
	public List<EmployeeUser> getuserList(@RequestParam String role,@RequestParam String fkUserId)
	{
	return loginservice.getuser(role,fkUserId);

	}
	
	@GetMapping("/getUserForEdit/{pk_employee_id}")
	public Optional<EmployeeUser> getuserforedit(@PathVariable(value="pk_employee_id") Long empId,@RequestParam String role)
	{
		return loginservice.getuserlistforedit(empId,role);
		
	}
	
	@PutMapping("/updateemployeeuser")
	public String updateemployeeuser(@RequestBody EmployeeUserDto employeeuserdto)
	{
		return loginservice.updateemployeeuser(employeeuserdto);
		
	}
	
	@PutMapping("/updateUser")
	public  String updateuserdetails(@RequestBody RequestUserDetailsDto requestUserDetailsDto)
	{
		String str= loginservice.updateuser(requestUserDetailsDto);
		return str;
	}
	
	@PostMapping("/bulkUpload-userDetails")
	public String uploaduserdetails(@RequestParam ("file") MultipartFile files) throws IOException,EncryptedDocumentException,InvalidFormatException,ParseException
	{
		String str=loginservice.addUserDetailExcelFile(files);
		return str;
		
	}
	@GetMapping("/admin-drop-down-list")
	public List<String> getadminldropdownlist(@RequestParam String role,@RequestParam String fkUserId)
	{
		return loginservice.getadmindropdown(role,fkUserId);
		
	}
	
	@GetMapping("/oragnization-drop-down-list")
	public List<String> getoragnizationdropdownlist()
	{
		return loginservice.getoragnizationdropdown();
		
	}
	@GetMapping("/getUserAdminList")
	public List<UserDetails> getalluser(@RequestParam String role, String pkid)
	{
		return loginservice.getlist(role,pkid);
	}
	
	@PostMapping("/forgot-password")
	public  ResponseEntity<Optional<String>> processForgotPassword(HttpServletRequest request) throws Exception
	{
		String status=null;
		try {
			
			status= loginservice.processForgotPassword(request);
			System.out.println(status);
		return ResponseEntity.ok(Optional.of(status));
		} catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		
		
	}
	
	
	@PostMapping("/reset-password")
	public String processResetPassword(HttpServletRequest request) {
		String token = request.getParameter("token");
		System.out.println("token is :"+token);
		String password = request.getParameter("password");
		System.out.println("password is : "+password);
		UserDetails customer = loginservice.getByResetPasswordToken(token);
		System.out.println("customer"+customer);
		if (customer != null) 
		{
			
			System.out.println("befour update");
			loginservice.updatePassword(customer, password);
			System.out.println("customer"+customer+"password"+password);
			return "You have successfully changed your password.";
		
		
		} 
		else 
		{    
			System.out.println("Invalid Token");
			return"Invalid Token";
		}
	}
	
	
	@PostMapping("/refreshToken")
	public Map<String,String> refreshToken(@RequestParam String refreshToken) {
		Map<String,String> map=new HashMap<>();
		map.put("accessToken",loginservice.refreshToken(refreshToken));
		return map;
	}
	
	

}
