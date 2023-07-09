package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.BankDto;
import com.bill_soft.entity.BankDetails;
import com.bill_soft.repository.BankRepository;
import com.bill_soft.repository.LoginRepository;
@Service
public class BankService {
	@Autowired
	private LoginRepository loginrepository;

     @Autowired
	private BankRepository bankrepository;
     
	public String addbankdetails(BankDto bankdto,String role,String fkUserId) {
		if(role.equals("super-admin") || role.equals("oragnization") || role.equals("admin") )
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
		BankDetails bank = new BankDetails();
		bank.setPkBankId(bankdto.getPkBankId());
		bank.setBankName(bankdto.getBankName());
		bank.setBranchName(bankdto.getBranchName());
		bank.setAccountHolderName(bankdto.getAccountHolderName());
		bank.setAccountNumber(bankdto.getAccountNumber());
		bank.setIfscCode(bankdto.getIfscCode());
		bank.setContactNumber(bankdto.getContactNumber());
		bank.setFkOragnizationId(bankdto.getFkOragnizationId());
		bank.setAddress(bankdto.getAddress());
		bank.setBankEmail(bankdto.getBankEmail());
		bank.setFkAdminId(bankdto.getFkAdminId());
		bank.setCreatedBy(user+"(" + role +")");
		bank.setCreatedDate(dateString);
		 bankrepository.save(bank);
	}
		return "You don't have access";
	}
	
	public List<BankDetails> getbankdetailslist(String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			 return bankrepository.getbanklistforsuperadmin();
		}
		if(role.equals("oragnization"))
		{
			Long fkOrganizationId=Long.parseLong(fkUserId);
			 return bankrepository.getbanklistfororganization(fkOrganizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			 return bankrepository.getbanklistforadmin(fkAdminId);
		}
		return null;
	}


	public Optional<BankDetails> editbankdetails(Long id,String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			 return bankrepository.getbankeditlistforsuperadmin(id);
		}
		if(role.equals("oragnization"))
		{
			Long fkOrganizationId=Long.parseLong(fkUserId);
			 return bankrepository.getbankeditlistfororganization(id,fkOrganizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			 return bankrepository.getbankeditlistforadmin(id,fkAdminId);
		}
		return null;
	}
	


	public String updatebankdetails(BankDto bankdto,String role,String fkUserId) {
		if(role.equals("super-admin") || role.equals("oragnization") || role.equals("admin") )
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
		BankDetails bank = new BankDetails();
		bank.setPkBankId(bankdto.getPkBankId());
		bank.setBankName(bankdto.getBankName());
		bank.setBranchName(bankdto.getBranchName());
		bank.setAccountHolderName(bankdto.getAccountHolderName());
		bank.setAccountNumber(bankdto.getAccountNumber());
		bank.setIfscCode(bankdto.getIfscCode());
		bank.setContactNumber(bankdto.getContactNumber());
		bank.setFkOragnizationId(bankdto.getFkOragnizationId());
		bank.setAddress(bankdto.getAddress());
		bank.setBankEmail(bankdto.getBankEmail());
		bank.setFkAdminId(bankdto.getFkAdminId());
		bank.setCreatedBy(user+"(" + role +")");
		bank.setCreatedDate(dateString);
		
	 bankrepository.save(bank);
	}
	
	return "You don't have access";

}
}