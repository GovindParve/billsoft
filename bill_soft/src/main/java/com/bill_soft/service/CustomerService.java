package com.bill_soft.service;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill_soft.dto.CustomerDto;
import com.bill_soft.entity.CustomerDetails;
import com.bill_soft.repository.CustomerRepository;
import com.bill_soft.repository.LoginRepository;
@Service
public class CustomerService {
	
	 @Autowired
		private CustomerRepository  customerrepository;
	 @Autowired
		private LoginRepository  loginrepository;
		public String addcustomer(CustomerDto customerdto,String role,String fkUserId) {
			if(role.equals("super-admin") || role.equals("oragnization")  || role.equals("admin"))
			{
				Long pkid=Long.parseLong(fkUserId);
				String user=loginrepository.getusernameforcategory(role,pkid);
				
				if(user.equals(null)) 
				{
					return "UserName Not  Found";
				}
				
				//String user=loginrepository.getusernameforcategory(role,fkUserId);
				LocalDate date=LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateString = date.format(formatter);
				CustomerDetails customerdetails =new CustomerDetails();
				customerdetails.setPkCustomerId(customerdto.getPkCustomerId());
				customerdetails.setFirstName(customerdto.getFirstName());
				customerdetails.setLastName(customerdto.getLastName());
				customerdetails.setMiddleName(customerdto.getMiddleName());
				
				customerdetails.setAlternateNumber(customerdto.getAlternateNumber());
				customerdetails.setContactNumber(customerdto.getContactNumber());
				customerdetails.setEmailId(customerdto.getEmailId());
				customerdetails.setAddress(customerdto.getAddress());
				customerdetails.setFirmname(customerdto.getFirmname());
				customerdetails.setGstNo(customerdto.getGstNo());
			   
				customerdetails.setCity(customerdto.getCity());
				customerdetails.setZipCode(customerdto.getZipCode());
				customerdetails.setFkAdminId(customerdto.getFkAdminId());
				customerdetails.setAdminName(customerdto.getAdminName());
				customerdetails.setFkShopId(customerdto.getFkShopId());
				customerdetails.setFkoragnizationId(customerdto.getFkoragnizationId());
				customerdetails.setOragnizationName(customerdto.getOragnizationName());
				customerdetails.setShopName(customerdto.getShopName());
				customerdetails.setCreatedDate(dateString);
				customerdetails.setCreatedBy(user+"(" + role +")");
			    
				customerrepository.save(customerdetails);
			}
			
			return "You don't have access";
			
	}
		
		public String bulkuploadcustomerdetails(MultipartFile files, String role, String fkUserId) throws IOException,EncryptedDocumentException,InvalidFormatException,ParseException
		{
			XSSFWorkbook workbook=new XSSFWorkbook(files.getInputStream());
			XSSFSheet sheet=workbook.getSheetAt(0);

			int count=0;
			for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++)
			{
				if(i > 0)
				{
					CustomerDetails customerdetails=new CustomerDetails();
					XSSFRow row=sheet.getRow(i);
					
					String firstName=row.getCell(0,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					String middleName=row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					String lastName=row.getCell(2,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					Long contactNumber=(long) row.getCell(3,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				    Long alternateNumber=(long) row.getCell(4,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
					String emailId=row.getCell(5,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					String city=row.getCell(6,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				    String address=row.getCell(7,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				    String firmname=row.getCell(8,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					Long gstNo=(long) row.getCell(9,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				    Long zipCode=(long) row.getCell(10,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
					Long fkShopId=(long) row.getCell(11,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
					String shopName=row.getCell(12,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				    Long fkAdminId=(long) row.getCell(13,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
					String adminName=row.getCell(14,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					Long fkoragnizationId=(long) row.getCell(15,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
					String oragnizationName=row.getCell(16,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					
					
					
					
					Long pkid=Long.parseLong(fkUserId);
					String user=loginrepository.getusernameforcategory(role,pkid);
					 if(user.equals(null))
						{
							return "UserName Not Found";
						}
					LocalDate date=LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dateString = date.format(formatter);
					CustomerDetails customer=customerrepository.findbyemailid(emailId);
					if(customer==null)
					{
					customerdetails.setFirstName(firstName);
					customerdetails.setMiddleName(middleName);
					customerdetails.setLastName(lastName);
					customerdetails.setContactNumber(contactNumber.toString());
					customerdetails.setAlternateNumber(alternateNumber.toString());
					customerdetails.setEmailId(emailId);
					customerdetails.setCity(city);
					customerdetails.setAddress(address);
					customerdetails.setFirmname(firmname);
					customerdetails.setGstNo(gstNo.toString());
					customerdetails.setZipCode(zipCode.toString());
					customerdetails.setFkAdminId(fkAdminId);
					customerdetails.setAdminName(adminName);
					customerdetails.setFkoragnizationId(fkoragnizationId);
					customerdetails.setOragnizationName(oragnizationName);
					customerdetails.setFkShopId(fkShopId);
					customerdetails.setShopName(shopName);
					
					
					customerdetails.setCreatedBy(user+"(" + role +")");
					customerdetails.setCreatedDate(dateString);
					customerrepository.save(customerdetails);
					count++;
					System.out.println("+++++++ customer details +++++"+customerdetails);
                    
					workbook.close();
					}
				}
		}
			
		
		
		    int lastrow=sheet.getPhysicalNumberOfRows();
			if(count == lastrow-1)
			{
				return "customer sucessfully added:" + " " + count +" "+ "Record are saved";
			}
			else
			{
				return "only" +" "+ count + " "+"customer Record are saved OR customer already exist...!..";
			}	

}

		public CustomerDetails getcustomeralllist(String role, String fkUserId, Long customerId) {
			if (role.equals("super-admin")) {
				return customerrepository.getcustomerlistforsuperadminIdWise(customerId);
			}
			if (role.equals("oragnization")) {
				Long fkOragnizationId = Long.parseLong(fkUserId);
				return customerrepository.getcustomerlistfororagnizationIdWise(fkOragnizationId, customerId);
			}
			if (role.equals("admin")) {
				Long fkAdminId = Long.parseLong(fkUserId);
				return customerrepository.getcustomerlistforadminIdWise(fkAdminId, customerId);
			}
			return null;
		}

		public Optional<CustomerDetails> editcustomer(Long id, String role, String fkUserId) {
			if(role.equals("super-admin"))
			{
				return customerrepository.getcustomereditlistforsuperadmin(id);
			}
			if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				return customerrepository.getcustomerlistfororagnization(id,fkOragnizationId);
			}
			if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				return customerrepository.getcustomerlistforadmin(id,fkAdminId);
			}
			return null;
		}

		public String  updatecustomerdetails(CustomerDto customerdto, String role, String fkUserId) {
			
			if(role.equals("super-admin") || role.equals("oragnization")  || role.equals("admin"))
			{
				Long pkid=Long.parseLong(fkUserId);
				String user=loginrepository.getusernameforcategory(role,pkid);
				
				if(user.equals(null)) 
				{
					return "UserName Not  Found";
				}
				
				//String user=loginrepository.getusernameforcategory(role,fkUserId);
				LocalDate date=LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateString = date.format(formatter);
				CustomerDetails customerdetails =new CustomerDetails();
				customerdetails.setPkCustomerId(customerdto.getPkCustomerId());
				customerdetails.setFirstName(customerdto.getFirstName());
				customerdetails.setLastName(customerdto.getLastName());
				customerdetails.setMiddleName(customerdto.getMiddleName());
				
				customerdetails.setAlternateNumber(customerdto.getAlternateNumber());
				customerdetails.setContactNumber(customerdto.getContactNumber());
				customerdetails.setEmailId(customerdto.getEmailId());
				customerdetails.setAddress(customerdto.getAddress());
				customerdetails.setFirmname(customerdto.getFirmname());
				customerdetails.setGstNo(customerdto.getGstNo());
			   
				customerdetails.setCity(customerdto.getCity());
				customerdetails.setZipCode(customerdto.getZipCode());
				customerdetails.setFkAdminId(customerdto.getFkAdminId());
				customerdetails.setAdminName(customerdto.getAdminName());
				customerdetails.setFkShopId(customerdto.getFkShopId());
				customerdetails.setFkoragnizationId(customerdto.getFkoragnizationId());
				customerdetails.setOragnizationName(customerdto.getOragnizationName());
				customerdetails.setShopName(customerdto.getShopName());
				customerdetails.setCreatedDate(dateString);
				customerdetails.setCreatedBy(user+"(" + role +")");
			    
				 customerrepository.save(customerdetails);
			}
			return "you don't have access";
		}

		public List<String> getcustomerdropdownlist(String role, String fkUserId) {
			if(role.equals("super-admin"))
			{
				return customerrepository.getcustomerdropdownlistforsuperadmin();
			}
			if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				return customerrepository.getcustomerdropdownlistfororagnization(fkOragnizationId);
			}
			if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				return customerrepository.getcustomerdropdownlistforadmin(fkAdminId);
			}
			return null;
		}
		
		public List<CustomerDetails> getCustomerList(String role, String fkUserId){
			if(role.equals("super-admin"))
			{
				return customerrepository.getcustomerlistforsuperadmin();
			}
			if(role.equals("oragnization"))
			{
				Long fkOragnizationId=Long.parseLong(fkUserId);
				return customerrepository.getcustomerlistfororagnization(fkOragnizationId);
			}
			if(role.equals("admin"))
			{
				Long fkAdminId=Long.parseLong(fkUserId);
				return customerrepository.getcustomerlistforadmin(fkAdminId);
			}
			return null;
		}
}
