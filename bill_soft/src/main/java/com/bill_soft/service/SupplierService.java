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

import com.bill_soft.dto.SupplierDto;
import com.bill_soft.entity.SupplierDetails;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.SupplierRepository;
@Service
public class SupplierService {
   @Autowired
	private SupplierRepository suppplierrepository;
   
   @Autowired
	private LoginRepository  loginrepository;
	public String addsupplier(SupplierDto supplierdto,String role,String fkUserId) {
		if(role.equals("super-admin") || role.equals("oragnization")  || role.equals("admin"))
		{
//			Long pkid=Long.parseLong(fkUserId);
//			String user=loginrepository.getusernameforcategory(role,pkid);
//			if(user.equals(null))
//			{
//				return "UserName Not Found";
//			}
			LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			SupplierDetails supplierdetails =new SupplierDetails();
			supplierdetails.setPkSuppplierId(supplierdto.getPkSuppplierId());
			supplierdetails.setFirstName(supplierdto.getFirstName());
			supplierdetails.setLastName(supplierdto.getLastName());
			supplierdetails.setPersonName(supplierdto.getPersonName());
			supplierdetails.setAccountHolderName(supplierdto.getAccountHolderName());
			supplierdetails.setAccountNumber(supplierdto.getAccountNumber());
			supplierdetails.setAlternateNumber(supplierdto.getAccountNumber());
			supplierdetails.setContactNumber(supplierdto.getContactNumber());
			supplierdetails.setEmailId(supplierdto.getEmailId());
			supplierdetails.setAddress(supplierdto.getAddress());
			supplierdetails.setIfscNo(supplierdto.getIfscNo());
		    supplierdetails.setGstNo(supplierdto.getGstNo());
		    supplierdetails.setOpeningBalane(supplierdto.getOpeningBalane());
		    supplierdetails.setCity(supplierdto.getCity());
		    supplierdetails.setUpiId(supplierdto.getUpiId());
		    supplierdetails.setFkAdminId(supplierdto.getFkAdminId());
		    supplierdetails.setAdminName(supplierdto.getAdminName());
		    supplierdetails.setFkShopId(supplierdto.getFkShopId());
			supplierdetails.setFkoragnizationId(supplierdto.getFkoragnizationId());
			supplierdetails.setOragnizationName(supplierdto.getOragnizationName());
			supplierdetails.setShopName(supplierdto.getShopName());
			supplierdetails.setCreatedDate(dateString);
			//supplierdetails.setCreatedBy(user+"(" + role +")");
		    
			 suppplierrepository.save(supplierdetails);
		}
		
		return "You Don't have access to add supplier details";
		
}
	
	
	public List<SupplierDetails> getsupplier(String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			return suppplierrepository.getsupplierlistforsuperadmin();
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return suppplierrepository.getsupplierlistfororagnization(fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return suppplierrepository.getsupplierlistforadmin(fkAdminId);
		}
		
		return null;
	}
	
	
	public Optional<SupplierDetails> editsupplier(Long id,String role,String fkUserId)
	{
		if(role.equals("super-admin"))
		{
			return suppplierrepository.getsuppliereditforsuperadmin(id);
			
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return suppplierrepository.getsuppliereditfororagnization(id,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return suppplierrepository.getsuppliereditforadmin(id,fkAdminId);
		}
		return null;
		
	}
	
	public String updatesupplier(SupplierDto supplierdto,String role,String fkUserId)
	{if(role.equals("super-admin") || role.equals("oragnization")  || role.equals("admin"))
	{
		Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		if(user.equals(null))
		{
			return "UserName Not Found";
		}
		LocalDate date=LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = date.format(formatter);
		SupplierDetails supplierdetails =new SupplierDetails();
		supplierdetails.setPkSuppplierId(supplierdto.getPkSuppplierId());
		supplierdetails.setFirstName(supplierdto.getFirstName());
		supplierdetails.setLastName(supplierdto.getLastName());
		supplierdetails.setPersonName(supplierdto.getPersonName());
		supplierdetails.setAccountHolderName(supplierdto.getAccountHolderName());
		supplierdetails.setAccountNumber(supplierdto.getAccountNumber());
		supplierdetails.setAlternateNumber(supplierdto.getAccountNumber());
		supplierdetails.setContactNumber(supplierdto.getContactNumber());
		supplierdetails.setEmailId(supplierdto.getEmailId());
		supplierdetails.setAddress(supplierdto.getAddress());
		supplierdetails.setIfscNo(supplierdto.getIfscNo());
	    supplierdetails.setGstNo(supplierdto.getGstNo());
	    supplierdetails.setOpeningBalane(supplierdto.getOpeningBalane());
	    supplierdetails.setCity(supplierdto.getCity());
	    supplierdetails.setUpiId(supplierdto.getUpiId());
	    supplierdetails.setFkAdminId(supplierdto.getFkAdminId());
	    supplierdetails.setAdminName(supplierdto.getAdminName());
	    supplierdetails.setFkShopId(supplierdto.getFkShopId());
		supplierdetails.setFkoragnizationId(supplierdto.getFkoragnizationId());
		supplierdetails.setOragnizationName(supplierdto.getOragnizationName());
		supplierdetails.setShopName(supplierdto.getShopName());
		supplierdetails.setCreatedDate(dateString);
		supplierdetails.setCreatedBy(user+"(" + role +")");
	    
		 suppplierrepository.save(supplierdetails);
	}
	
	return "You Don't have access to update supplier details";
	
}
	


	public List<String> getsupplierdropdownlist(String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			return suppplierrepository.getsupplierdropdownforsuperadmin();
			
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return suppplierrepository.getsupplierdropdownfororagnization(fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return suppplierrepository.getsupplierdropdownforadmin(fkAdminId);
		}
		
		return null;
	}


	public String bulkuploadsupplierdetails(MultipartFile files, String role, String fkUserId) throws IOException,EncryptedDocumentException,InvalidFormatException,ParseException 
	{
		XSSFWorkbook workbook=new XSSFWorkbook(files.getInputStream());
		XSSFSheet sheet=workbook.getSheetAt(0);

		int count=0;
		for(int i=1; i< sheet.getPhysicalNumberOfRows(); i++)
		{
			if(i > 0)
			{
				SupplierDetails supplierdetails=new SupplierDetails();
				XSSFRow row=sheet.getRow(i);
				String firstName=row.getCell(0,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				String lastName=row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				String personName=row.getCell(2,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				Long contactNumber=(long) row.getCell(3,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				Long alternateNumber=(long) row.getCell(4,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				String emailId=row.getCell(5,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				String city=row.getCell(6,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			    String address=row.getCell(7,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			    Long gstNo=(long) row.getCell(8,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			    String accountHolderName=row.getCell(9,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			 Long accountNumber=(long) row.getCell(10,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			  Long ifscNo=(long) row.getCell(11,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			 Long upiId=(long) row.getCell(12,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			    Long openingBalane=(long) row.getCell(13,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
			   
				Long fkShopId=(long) row.getCell(14,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				String shopName=row.getCell(15,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
					 
				Long fkAdminId=(long) row.getCell(16,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				String adminName=row.getCell(17,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				
				Long fkoragnizationId=(long) row.getCell(18,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				String oragnizationName=row.getCell(19,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				
				
				
				
				Long pkid=Long.parseLong(fkUserId);
				String user=loginrepository.getusernameforcategory(role,pkid);
				 if(user.equals(null))
					{
						return "UserName Not Found";
					}
				LocalDate date=LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateString = date.format(formatter);
				SupplierDetails supplier=suppplierrepository.findbyemailid(emailId);
				if(supplier==null) 
				{
				supplierdetails.setFirstName(firstName);
	            supplierdetails.setLastName(lastName);
	            supplierdetails.setPersonName(personName);
				supplierdetails.setContactNumber(contactNumber.toString());
				supplierdetails.setAlternateNumber(alternateNumber.toString());
				supplierdetails.setEmailId(emailId);
				supplierdetails.setCity(city);
				supplierdetails.setAddress(address);
				
				supplierdetails.setGstNo(gstNo.toString());
				supplierdetails.setAccountHolderName(accountHolderName);
				supplierdetails.setAccountNumber(accountNumber.toString());
				supplierdetails.setIfscNo(ifscNo.toString());
				supplierdetails.setUpiId(upiId.toString());
			
				supplierdetails.setOpeningBalane(openingBalane.toString());
				supplierdetails.setFkAdminId(fkAdminId);
				supplierdetails.setAdminName(adminName);
				supplierdetails.setFkoragnizationId(fkoragnizationId);
				supplierdetails.setOragnizationName(oragnizationName);
				supplierdetails.setFkShopId(fkShopId);
				supplierdetails.setShopName(shopName);
				
				
				supplierdetails.setCreatedBy(user+"(" + role +")");
				supplierdetails.setCreatedDate(dateString);
				suppplierrepository.save(supplierdetails);
				count++;
				System.out.println("+++++++ supplier details +++++"+supplierdetails);
				workbook.close();
				}
		
			}
	}
		int lastrow=sheet.getPhysicalNumberOfRows();
		if(count == lastrow-1)
		{
			return "supplier sucessfully added:"+count+"Record are saved";
		}
		else
		{
			
			return "only" + count+"supplier Record are saved OR supplier already exist...!..";
		}	
	
	}
}
