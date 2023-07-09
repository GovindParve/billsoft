package com.bill_soft.service;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill_soft.bean.LoginBean;
import com.bill_soft.dto.EmployeeUserDto;
import com.bill_soft.dto.LoginOrganizationDto;
import com.bill_soft.dto.RequestUserDetailsDto;
import com.bill_soft.entity.EmployeeUser;
import com.bill_soft.entity.Shop;
import com.bill_soft.entity.UserDetails;
import com.bill_soft.exception.CustomException;
import com.bill_soft.repository.EmployeeUserRepository;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.ShopRepository;
import com.bill_soft.response.ResponseHandler;
import com.bill_soft.security.JwtTokenProvider;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginService {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private LoginRepository loginrepository;
	@Autowired
	private EmployeeUserRepository employeeuserrepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JavaMailSender mailSender;
	private String url;

	@Autowired
	private ShopRepository shoprepository;

	public LoginBean emplogin(String username, String password) throws CustomException {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateString = date.format(formatter);
		String role = null;
		List<String> businesstype = null;
		LoginOrganizationDto logindto = new LoginOrganizationDto();
		try {

			role = employeeuserrepository.findRoleByUserName(username);
			System.out.println(" get role from username" + role);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		if (role != null) {
			try

			{
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				EmployeeUser adminname = employeeuserrepository.getadminname(username);
				Long fkAdminId = (Long.parseLong(adminname.getFkAdminId().toString()));
				List<LoginOrganizationDto> oragnizationdto = new ArrayList<LoginOrganizationDto>();
				try {
					businesstype = shoprepository.getallbuisnesstypeunderadmin(fkAdminId);
				} catch (Exception e) {
					businesstype = null;
				}
				LoginOrganizationDto newdto = new LoginOrganizationDto();
//					
				newdto.setPk_id(adminname.getPkEmployeeId());
				newdto.setFirstname(adminname.getFirstName());
				newdto.setLastname(adminname.getLastName());
				newdto.setUsername(adminname.getUserName());
				newdto.setRole(adminname.getRole());
				try {
					newdto.setFkOrganizationId(Long.parseLong(adminname.getFkOragnizationId().toString()));
					newdto.setOrganizationName(adminname.getOragnizationName());
				} catch (Exception e) {
					newdto.setFkOrganizationId(null);
					newdto.setOrganizationName(null);
				}
				newdto.setFkAdminId(Long.parseLong(adminname.getFkAdminId().toString()));
				newdto.setAdminName(adminname.getAdminName());
//					
				newdto.setBuisnessType(businesstype);
				if (businesstype == null) {
					newdto.setBuisnessType(null);
				}
				oragnizationdto.add(newdto);
				// List<RequestEmployeeDto> reqPerDto =
				// employeeuserrepository.getUesrDetailsForAllocation(username);

				LoginBean result = new LoginBean();
				List<EmployeeUser> userDetails = employeeuserrepository.findUsersByUserName(username);

				if (userDetails.size() != 1)
					throw new CustomException("More than one record found in user", HttpStatus.INTERNAL_SERVER_ERROR);

				result.setPerList2(oragnizationdto);
				EmployeeUser user1 = userDetails.get(0);
				String accessToken = jwtTokenProvider.createToken(user1.getUserName(), new ArrayList<>());
				String refreshToken = jwtTokenProvider.createRefreshToken(user1.getUserName());
				user1.setAccessToken(accessToken);
				user1.setRefreshToken(refreshToken);
				user1.setLoginTime(dateString);
				result.setToken(accessToken);
				result.setRefreshToken(refreshToken);
				employeeuserrepository.save(user1);
				return result;
			}

			catch (AuthenticationException e) {
				e.printStackTrace();
				throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
			}

		} else {
//				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//				List<String> businesstype=shoprepository.getallbuisnesstypeunderorganization(username);
//				System.out.println(businesstype);
//				UserDetails userdetails=loginrepository.getOragnizationDetailsForAllocation(username);
//				System.out.println(userdetails.toString());
//				
//			}

			try {

				role = loginrepository.findRoleByUserName(username);
				System.out.println(" get role from username" + role);
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

			if (role.equals("oragnization")) {
//					List<String> businesstype=null;
//					LoginOrganizationDto logindto=new LoginOrganizationDto();
				try {
					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
					try {
						businesstype = shoprepository.getallbuisnesstypeunderorganization(username);
					} catch (Exception e) {
						businesstype = null;
					}
//					if(businesstype.equals("null"))
//					{
//						logindto.setBuisnessType(null);
//					}

					System.out.println(businesstype);
					// String[] business=(String[]) businesstype.toArray();
					// List<Object[]>
					// userdetails=loginrepository.getOragnizationDetailsForAllocation(username);
					UserDetails userdetails = loginrepository.getOragnizationDetailsForAllocation(username);
					System.out.println(userdetails.toString());

					// List<LoginOrganizationDto> reqPerDto =
					// loginrepository.getOragnizationDetailsForAllocation(username);
					List<LoginOrganizationDto> oragnizationdto = new ArrayList<LoginOrganizationDto>();
					for (int i = 0; i < businesstype.size(); i++) {

						logindto.setBuisnessType(businesstype);

					}
//for(Object[] userdetails1:userdetails )
//{
					LoginOrganizationDto newdto = new LoginOrganizationDto();
//	newdto.setPk_id(Long.parseLong(userdetails1[0].toString ()));
					newdto.setPk_id(userdetails.getPkid());
					newdto.setFirstname(userdetails.getFirstName());
					newdto.setLastname(userdetails.getLastName());
					newdto.setUsername(userdetails.getUserName());
					newdto.setRole(userdetails.getRole());
					newdto.setFkOrganizationId(userdetails.getPkid());
					newdto.setOrganizationName(userdetails.getUserName());
//	newdto.setFirstname(userdetails1[1].toString ());
//	newdto.setLastname(userdetails1[2].toString ());
//	newdto.setUsername(userdetails1[3].toString ());
//	newdto.setRole((userdetails1[4].toString ()));
					newdto.setBuisnessType(businesstype);
					if (businesstype == null) {
						newdto.setBuisnessType(null);
					}
					oragnizationdto.add(newdto);
//	List<String> business=newdto.setBuisnessType((List<String>) (userdetails1[0]));
//	String[] business=userdetails1[5].toString();
////	System.out.println(business);
////}
					LoginBean result = new LoginBean();
					List<UserDetails> userDetails = loginrepository.findUsersByUserName(username);

					if (userDetails.size() != 1)
						throw new CustomException("More than one record found in user",
								HttpStatus.INTERNAL_SERVER_ERROR);
					result.setPerList2(oragnizationdto);
					UserDetails user = userDetails.get(0);
					String accessToken = jwtTokenProvider.createToken(user.getUserName(), new ArrayList<>());
					String refreshToken = jwtTokenProvider.createRefreshToken(user.getUserName());
					user.setAccessToken(accessToken);
					user.setRefreshToken(refreshToken);
					user.setLoginTime(dateString);
					result.setToken(accessToken);
					result.setRefreshToken(refreshToken);
//						UserDetails user1=new UserDetails();
//						user1.setLoginTime(dateString);
					loginrepository.save(user);
					return result;

				}

				catch (AuthenticationException e) {
					e.printStackTrace();
					throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
				}

			}
			if (role.equals("admin")) {
				try {
					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
					try {
						businesstype = shoprepository.getallbuisnesstypeunderadmin(username);
					} catch (Exception e) {
						businesstype = null;
					}
					List<LoginOrganizationDto> oragnizationdto = new ArrayList<LoginOrganizationDto>();
					List<Object[]> userdetails = loginrepository.getAdminDetailsForAllocation(username);
					// List<RequestPermissionDto> reqPerDto =
					// loginrepository.getUesrDetailsForAllocation(username);

					for (Object[] userdetails1 : userdetails) {
						LoginOrganizationDto newdto = new LoginOrganizationDto();

						newdto.setPk_id(Long.parseLong(userdetails1[0].toString()));
						newdto.setFirstname(userdetails1[1].toString());
						newdto.setLastname(userdetails1[2].toString());
						newdto.setUsername(userdetails1[3].toString());
						newdto.setRole(userdetails1[4].toString());
						newdto.setBuisnessType(businesstype);
						try {
							newdto.setFkOrganizationId(Long.parseLong(userdetails1[6].toString()));
							newdto.setOrganizationName(userdetails1[7].toString());
						} catch (Exception e) {
							newdto.setFkOrganizationId(null);
							newdto.setOrganizationName(null);
						}
						newdto.setFkAdminId(Long.parseLong(userdetails1[0].toString()));
						newdto.setAdminName(userdetails1[3].toString());
						// newdto.setOrganizationName(userdetails1[7].toString());
						if (businesstype == null) {
							newdto.setBuisnessType(null);
						}
						oragnizationdto.add(newdto);
					}
					LoginBean result = new LoginBean();
					List<UserDetails> userDetails = loginrepository.findUsersByUserName(username);

					if (userDetails.size() != 1)
						throw new CustomException("More than one record found in user",
								HttpStatus.INTERNAL_SERVER_ERROR);
					result.setPerList2(oragnizationdto);
					UserDetails user = userDetails.get(0);
					String accessToken = jwtTokenProvider.createToken(user.getUserName(), new ArrayList<>());
					String refreshToken = jwtTokenProvider.createRefreshToken(user.getUserName());
					user.setAccessToken(accessToken);
					user.setRefreshToken(refreshToken);
					user.setLoginTime(dateString);
					result.setToken(accessToken);
					result.setRefreshToken(refreshToken);
//					UserDetails user1=new UserDetails();
//					user1.setLoginTime(dateString);
					loginrepository.save(user);
					return result;

				}

				catch (AuthenticationException e) {
					e.printStackTrace();
					throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
				}

			}

			if (role.equals("super-admin")) {
				try

				{
					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
					// List<String>
					// businesstype=shoprepository.getallbuisnesstypeundersuperadmin(username);
					List<LoginOrganizationDto> oragnizationdto = new ArrayList<LoginOrganizationDto>();
					// System.out.println(businesstype);
					UserDetails userdetails = loginrepository.getSuperadminnDetailsForAllocation(username);
					// List<RequestPermissionDto> reqPerDto =
					// loginrepository.getUesrDetailsForAllocationSuperadmin(username);

					LoginOrganizationDto newdto = new LoginOrganizationDto();
//						newdto.setPk_id(Long.parseLong(userdetails1[0].toString ()));
					newdto.setPk_id(userdetails.getPkid());
					newdto.setFirstname(userdetails.getFirstName());
					newdto.setLastname(userdetails.getLastName());
					newdto.setUsername(userdetails.getUserName());
					newdto.setRole(userdetails.getRole());
//						newdto.setFirstname(userdetails1[1].toString ());
//						newdto.setLastname(userdetails1[2].toString ());
//						newdto.setUsername(userdetails1[3].toString ());
//						newdto.setRole((userdetails1[4].toString ()));
					newdto.setBuisnessType(businesstype);
					if (businesstype == null) {
						newdto.setBuisnessType(null);
					}
					oragnizationdto.add(newdto);

					LoginBean result = new LoginBean();
					List<UserDetails> userDetails = loginrepository.findUsersByUserName(username);

					if (userDetails.size() != 1)
						throw new CustomException("More than one record found in user",
								HttpStatus.INTERNAL_SERVER_ERROR);

					result.setPerList2(oragnizationdto);
					UserDetails user1 = userDetails.get(0);
					String accessToken = jwtTokenProvider.createToken(user1.getUserName(), new ArrayList<>());
					String refreshToken = jwtTokenProvider.createRefreshToken(user1.getUserName());
					user1.setAccessToken(accessToken);
					user1.setRefreshToken(refreshToken);
					user1.setLoginTime(dateString);
					result.setToken(accessToken);
					result.setRefreshToken(refreshToken);
					loginrepository.save(user1);
					return result;
				}

				catch (AuthenticationException e) {
					e.printStackTrace();
					throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
				}

			}
		}

		return null;
	}

	/*
	 * {
	 * 
	 * List<RequestPermissionDto> reqPerDto =
	 * employeeuserrepository.getUesrDetailsForAllocation(username);
	 * 
	 * LoginBean result = new LoginBean(); List<EmployeeUser>
	 * userDetails=employeeuserrepository.findUsersByUserName(username); if
	 * (userDetails.size()!=1) throw new
	 * CustomException("More than one record found in user",HttpStatus.
	 * INTERNAL_SERVER_ERROR); result.setPerList(reqPerDto); EmployeeUser
	 * user=userDetails.get(0); String
	 * accessToken=jwtTokenProvider.createToken(user.getUserName(), new
	 * ArrayList<>()); String
	 * refreshToken=jwtTokenProvider.createRefreshToken(user.getUserName());
	 * user.setAccessToken(accessToken); user.setRefreshToken(refreshToken);
	 * result.setToken(accessToken); result.setRefreshToken(refreshToken); return
	 * result;
	 * 
	 * } } catch (AuthenticationException e) { e.printStackTrace(); throw new
	 * CustomException("Invalid username/password supplied",
	 * HttpStatus.UNPROCESSABLE_ENTITY);
	 * 
	 * } }
	 */

	public String signup(RequestUserDetailsDto requserDetails) {

//			Long pkid=Long.parseLong(fkUserId);
//			String user=loginrepository.getusernameforcategory(role,pkid);
//			
//			if(user.equals(null)) 
//			{
//				return "UserName Not  Found";
//			}
//			if(role.equals("user"))
//			{
//				 EmployeeUser repoemail=employeeuserrepository.findByEmailId(requserDetails.getEmailId());
//
//					if(repoemail==null)
//					{
//						
//						String  email=requserDetails.getEmailId();
//					
//						System.out.println("user list"+ repoemail);
//						String str = null;
//						if((!employeeuserrepository.existsByUserName(requserDetails.getUserName())) && (!employeeuserrepository.existsByEmailId(requserDetails.getEmailId())) )
//						{
//						
//						  EmployeeUser res=new EmployeeUser();
//						  res.setFirstName(requserDetails.getFirstName());
//						  res.setLastName(requserDetails.getLastName());
//						  res.setContactNumber(requserDetails.getContactNumber());
//						  res.setEmailId(requserDetails.getEmailId());
//						  res.setUserName(requserDetails.getUserName()); 
//						  res.setPassword(passwordEncoder.encode(requserDetails.getPassword()));
//					      res.setRole(requserDetails.getRole());
//					     
//					      employeeuserrepository.save(res);
//					    }
//					    jwtTokenProvider.createToken(requserDetails.getUserName(), new ArrayList<>());
//					   str="user created";
//		               return  str;
//						}
//				
//					else
//					{
//						return "duplicate emailaddress and username";
//					}
//				
//			}
//			else 
//			{
		UserDetails repoemail = loginrepository.findByEmailId(requserDetails.getEmailId());

		if (repoemail == null) {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			// String expiryDate=null;
			System.out.println("user list" + repoemail);
			String str = null;
			if ((!loginrepository.existsByUserName(requserDetails.getUserName()))
					&& (!loginrepository.existsByEmailId(requserDetails.getEmailId()))) {

				UserDetails res = new UserDetails();
				res.setFirstName(requserDetails.getFirstName());
				res.setLastName(requserDetails.getLastName());
				res.setContactNumber(requserDetails.getContactNumber());
				res.setEmailId(requserDetails.getEmailId());
				res.setUserName(requserDetails.getUserName());
				res.setPassword(passwordEncoder.encode(requserDetails.getPassword()));
				res.setStatus("active");
				Period period = Period.ofMonths(1);
				Temporal temp = period.addTo(LocalDate.now());
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String expiryDate = ((LocalDate) temp).format(formatter1);
				System.out.println(expiryDate);
				res.setValidityDate(expiryDate);
				if (expiryDate.equals(dateString)) {
					res.setStatus("deactive");
				}
				res.setRole(requserDetails.getRole());
				res.setFkAdminId(requserDetails.getFkAdminId());
				res.setFkOrganizationId(requserDetails.getFkOrganizationId());
				res.setCreatedDate(dateString);
				// res.setCreatedBy(user+"(" + role +")");
				loginrepository.save(res);
			}
			jwtTokenProvider.createToken(requserDetails.getUserName(), new ArrayList<>());
			str = "user created";
			return str;
		}

		else {
			return "duplicate emailaddress and username";
		}
	}
	// }

	public void sendEmail(String email, String resetPasswordLink) {

		try {

			String link = resetPasswordLink;
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("vidyagd07@gmail.com", "Embel Support");
			helper.setTo(email);
			System.out.println("link" + link);
			String subject = "Here's the link to reset your password";

			String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
					+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + resetPasswordLink
					+ "\">Change my password</a></p>" + "<br>"
					+ "<p>Ignore this email if you do remember your password, "
					+ "or you have not made the request.</p>";
			helper.setSubject(subject);

			helper.setText(content, true);
			System.out.println("massage:" + message);
			mailSender.send(message);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}

	}

	public String processForgotPassword(HttpServletRequest request) throws Exception {

		String token = RandomString.make(30);

		String email = request.getParameter("email");

		Optional<String> emaildb = findByEmailAddress(email);

		if (!emaildb.get().contains(email)) {

			return "Invalid Email  ";

		} else {

			try {

				updateResetPasswordToken(token, email);

//						url = "http://15.206.217.121/register";     //65.1.68.67
//						"/users/reset-password?token=" +

				url = "http://localhost:3000/reset-password/" + token;
//							String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
				String resetPasswordLink = url;

				System.out.println("&&&&&&&&befour sending mail");
				try {
					sendEmail(email, resetPasswordLink);
					return "Reset Pasword Link sending on your Email..";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}

		return null;

	}

	private Optional<String> findByEmailAddress(String email) {
		Optional<String> emaildb = Optional.ofNullable(loginrepository.findByEmailAddress(email));

		return emaildb;
	}

	private void updateResetPasswordToken(String token, String email) {
		UserDetails customer = loginrepository.findByEmailId(email);
		if (customer != null) {
			customer.setResetPasswordToken(token);
			loginrepository.save(customer);
		} else {
			throw new CustomException("Could not find any customer with the email " + email, null);
		}
	}

	public UserDetails getByResetPasswordToken(String token) {
		return loginrepository.findByResetPasswordToken(token);
	}

	public String refreshToken(String refreshToken) {
		UserDetails userDetails = loginrepository.findByUserName(jwtTokenProvider.getUsername(refreshToken));
		if (jwtTokenProvider.validateRefreshToken(refreshToken)) {
			return jwtTokenProvider.createToken(userDetails.getUserName(), new ArrayList<>());
		} else
			throw new CustomException("User token detail not available", HttpStatus.UNAUTHORIZED);
	}

	public void updatePassword(UserDetails customer, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		customer.setPassword(encodedPassword);

		customer.setResetPasswordToken(null);
		loginrepository.save(customer);

	}

	public List<UserDetails> getlist(String role, String pkid) {

		Long pkid1 = Long.parseLong(pkid);
		if (role.equals("admin")) {
			return loginrepository.getuserList(pkid1);
		}
		return null;

	}

	public String updateuser(RequestUserDetailsDto requestUserDetailsDto) {
		// String email=requestUserDetailsDto.getEmailId();
		// UserDetails
		// repoemail=loginrepository.findByEmailId(requestUserDetailsDto.getEmailId());
		// System.out.println("user list"+ repoemail);
		String str = null;
		// if((!loginrepository.existsByUserName(requestUserDetailsDto.getUserName()))
		// && (!loginrepository.existsByUserName(requestUserDetailsDto.getEmailId())) )
		// {

		UserDetails res = new UserDetails();
		res.setPkid(requestUserDetailsDto.getPkid());
		res.setFirstName(requestUserDetailsDto.getFirstName());
		res.setLastName(requestUserDetailsDto.getLastName());
		res.setContactNumber(requestUserDetailsDto.getContactNumber());
		res.setEmailId(requestUserDetailsDto.getEmailId());
		res.setUserName(requestUserDetailsDto.getUserName());
		res.setPassword(passwordEncoder.encode(requestUserDetailsDto.getPassword()));
		res.setRole(requestUserDetailsDto.getRole());

		loginrepository.save(res);
		// }
		jwtTokenProvider.createToken(requestUserDetailsDto.getUserName(), new ArrayList<>());
		str = "user Updated";
		return str;

	}

	public String adduserdetail(EmployeeUserDto employeeuserdto) {
		EmployeeUser repoemail = employeeuserrepository.findByEmailId(employeeuserdto.getEmailId());
		if (repoemail == null) {
			System.out.println("user list" + repoemail);
			String str = null;
			if ((!employeeuserrepository.existsByUserName(employeeuserdto.getUserName()))
					&& (!employeeuserrepository.existsByEmailId(employeeuserdto.getEmailId()))) {
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateString = date.format(formatter);

				EmployeeUser user = new EmployeeUser();
				user.setPkEmployeeId(employeeuserdto.getPkEmployeeId());
				user.setFirstName(employeeuserdto.getFirstName());
				user.setLastName(employeeuserdto.getLastName());
				user.setContactNumber(employeeuserdto.getContactNumber());
				user.setUserName(employeeuserdto.getUserName());
				user.setEmailId(employeeuserdto.getEmailId());
				user.setPassword(passwordEncoder.encode(employeeuserdto.getPassword()));
				user.setFkAdminId(employeeuserdto.getFkAdminId());
				user.setAdminName(employeeuserdto.getAdminName());
				user.setFkOragnizationId(employeeuserdto.getFkOragnizationId());
				user.setOragnizationName(employeeuserdto.getOragnizationName());
				user.setCreatedDate(dateString);
				user.setRole(employeeuserdto.getRole());
				employeeuserrepository.save(user);

			}
			jwtTokenProvider.createToken(employeeuserdto.getUserName(), new ArrayList<>());
			str = "User Created";
			return str;
		} else {

			return "User Already Exist";
		}

	}

	public List<EmployeeUser> getuser(String role, String fkUserId) {
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return employeeuserrepository.getuserlistforadmin(fkAdminId);

		}
		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return employeeuserrepository.getuserlistfororagnization(fkOragnizationId);

		}
		if (role.equals("super-admin")) {
			return employeeuserrepository.getuserlistforsuperadmin();
		}
		return null;

	}

	public Optional<EmployeeUser> getuserlistforedit(Long empID, String role) {
		return employeeuserrepository.findById(empID);

	}

	public List<String> getadmindropdown(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return loginrepository.getadmindropdownforsuperadmin();
		}
		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return loginrepository.getadmindropdownfororagnization(fkOragnizationId);

		}
		return null;

	}

	public List<String> getoragnizationdropdown() {

		return loginrepository.getoragnizationdropdownforsuperadmin();

	}

	public String addUserDetailExcelFile(MultipartFile files)
			throws IOException, EncryptedDocumentException, InvalidFormatException, ParseException {
		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet sheet = workbook.getSheetAt(0);
		int count = 0;
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			if (i > 0) {
				EmployeeUser employeeuser = new EmployeeUser();

				XSSFRow row = sheet.getRow(i);
				String firstname = row
						.getCell(0, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getStringCellValue();
				String lastname = row.getCell(1, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getStringCellValue();
				String emailId = row.getCell(2, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getStringCellValue();
				Long contactnumber = (long) row
						.getCell(3, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getNumericCellValue();
				String username = row.getCell(4, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getStringCellValue();
				String password = row.getCell(5, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getStringCellValue();
				String role = row.getCell(6, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getStringCellValue();
				Long adminId = (long) row
						.getCell(7, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getNumericCellValue();
				// String
				// adminName=row.getCell(8,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				Long oragnizationId = (long) row
						.getCell(8, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getNumericCellValue();
				//// String
				//// OragnizationName=row.getCell(10,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

				EmployeeUser user = employeeuserrepository.findByEmail(emailId);
				if (user == null) {
					LocalDate date = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dateString = date.format(formatter);
					employeeuser.setFirstName(firstname);
					employeeuser.setLastName(lastname);
					employeeuser.setEmailId(emailId);
					employeeuser.setContactNumber(contactnumber.toString());
					employeeuser.setUserName(username);
					employeeuser.setPassword(passwordEncoder.encode(password));
					employeeuser.setRole(role);
					employeeuser.setFkAdminId(adminId);
					employeeuser.setFkOragnizationId(oragnizationId);
					// user.setCreatedBy();
					employeeuser.setCreatedDate(dateString);

					employeeuserrepository.save(employeeuser);
					count++;
					System.out.println("users details" + employeeuser);
				}

			}
			workbook.close();
		}
		int lastrow = sheet.getPhysicalNumberOfRows();
		if (count == lastrow - 1) {
			return " Users sucessfully added:" + count + "Record are saved";
		} else {

			return "only" + count + "Users Record are saved OR User already exist...!..";
		}

		
		
		
	}

	public String updateemployeeuser(EmployeeUserDto employeeuserdto) {
//		EmployeeUser repoemail=employeeuserrepository.findByEmailId(employeeuserdto.getEmailId());
//		if(repoemail==null)
//		{
//			System.out.println("user list"+ repoemail);
		String str = null;
//		if((!employeeuserrepository.existsByUserName(employeeuserdto.getUserName())) && (!employeeuserrepository.existsByEmailId(employeeuserdto.getEmailId())) )
//		{
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);

		EmployeeUser user = new EmployeeUser();
		user.setPkEmployeeId(employeeuserdto.getPkEmployeeId());
		user.setFirstName(employeeuserdto.getFirstName());
		user.setLastName(employeeuserdto.getLastName());
		user.setContactNumber(employeeuserdto.getContactNumber());
		user.setUserName(employeeuserdto.getUserName());
		user.setEmailId(employeeuserdto.getEmailId());
		user.setPassword(passwordEncoder.encode(employeeuserdto.getPassword()));
		user.setFkAdminId(employeeuserdto.getFkAdminId());
		user.setFkOragnizationId(employeeuserdto.getFkOragnizationId());

		user.setCreatedDate(dateString);
		user.setRole(employeeuserdto.getRole());
		employeeuserrepository.save(user);

		// }
		jwtTokenProvider.createToken(employeeuserdto.getUserName(), new ArrayList<>());
		str = "user updated";
		return str;
//		}
//	else
//		{
//			
//			  return "user already exist";
//		}
//		
	}

	public ResponseEntity<String> getlogin(String username, String password) {

		return null;
	}

	public ResponseEntity<Object> addadminoragnization(RequestUserDetailsDto requserDetails) throws CustomException

	{
		Long fkShopId = requserDetails.getFkShopId();
		Shop shop = shoprepository.selectalldetailsthoughshopid(fkShopId);

		UserDetails repoemail = loginrepository.findByEmailId(requserDetails.getEmailId());
		if (repoemail != null) {
			return ResponseHandler.generateResponse("email id already exits", HttpStatus.MULTI_STATUS, null);
		}
//			
		UserDetails repousername = loginrepository.findByUserName(requserDetails.getUserName());
		if (repousername != null) {
			return ResponseHandler.generateResponse("username already exits", HttpStatus.MULTI_STATUS, null);
		}
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);

		// if((!loginrepository.existsByUserName(requserDetails.getUserName())) &&
		// (!loginrepository.existsByEmailId(requserDetails.getEmailId())) )
		if (repoemail == null && repousername == null) {
			UserDetails userdetails = new UserDetails();
			userdetails.setFirstName(requserDetails.getFirstName());
			userdetails.setLastName(requserDetails.getLastName());
			userdetails.setEmailId(requserDetails.getEmailId());
			userdetails.setContactNumber(requserDetails.getContactNumber());
			userdetails.setUserName(requserDetails.getUserName());
			userdetails.setPassword(passwordEncoder.encode(requserDetails.getPassword()));
			userdetails.setRole(requserDetails.getRole());
			userdetails.setStatus("active");
			userdetails.setFkShopId(requserDetails.getFkShopId());
			Period period = Period.ofMonths(1);
			Temporal temp = period.addTo(LocalDate.now());
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String expiryDate = ((LocalDate) temp).format(formatter1);
			System.out.println(expiryDate);
			userdetails.setValidityDate(expiryDate);
			userdetails.setFkAdminId(requserDetails.getFkAdminId());
			userdetails.setFkOrganizationId(requserDetails.getFkOrganizationId());
			userdetails.setCreatedDate(dateString);
			UserDetails str = loginrepository.save(userdetails);
			try {
				if (requserDetails.getFkShopId() != 0) {

					shop.setPkShopId(shop.getPkShopId());
					shop.setFkAdminId(Long.parseLong(str.getPkid().toString()));
					shop.setAdminName(str.getUserName());
					shoprepository.save(shop);
				}
			} catch (Exception e) {
				requserDetails.setFkShopId(null);
			}
			jwtTokenProvider.createToken(requserDetails.getUserName(), new ArrayList<>());

			return ResponseHandler.generateResponse("user created successfully !", HttpStatus.OK, str);
		}
		// }

		return ResponseHandler.generateResponse("email id or username already exits", HttpStatus.MULTI_STATUS, null);

	}

}
