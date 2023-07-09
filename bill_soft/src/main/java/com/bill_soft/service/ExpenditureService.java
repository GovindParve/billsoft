package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.ExpenditureDto;
import com.bill_soft.entity.ExpenditureDetails;
import com.bill_soft.repository.ExpenditureRepository;
import com.bill_soft.repository.LoginRepository;
@Service
public class ExpenditureService {

	@Autowired
	private ExpenditureRepository expenditurerepository;
	
	@Autowired
	private LoginRepository  loginrepository;
	public String addexpendituredetails(ExpenditureDto expendituredto,String role,String fkUserId) {
		
		if(role.equals("super-admin") || (role.equals("oragnization")) || (role.equals("admin")))
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
			ExpenditureDetails expendituredetails=new ExpenditureDetails();
			expendituredetails.setPkExpenditureId(expendituredto.getPkExpenditureId());
			expendituredetails.setExpenditureName(expendituredto.getExpenditureName());
			expendituredetails.setExpenditureType(expendituredto.getExpenditureType());
			expendituredetails.setDescription(expendituredto.getDescription());
			expendituredetails.setExpenditureAmount(expendituredto.getExpenditureAmount());
			expendituredetails.setFkAdminId(expendituredto.getFkAdminId());
			expendituredetails.setAdminName(expendituredto.getAdminName());
			expendituredetails.setFkShopId(expendituredto.getFkShopId());
			expendituredetails.setFkoragnizationId(expendituredto.getFkoragnizationId());
			expendituredetails.setOragnizationName(expendituredto.getOragnizationName());
			expendituredetails.setShopName(expendituredto.getShopName());
			expendituredetails.setCreatedDate(dateString);
			expendituredetails.setCreatedBy(user+"(" + role +")");
			
			
			 expenditurerepository.save(expendituredetails);
		}
		
	return "You Don't have access to create expenditure ";	
	}
	
	public List<ExpenditureDetails> getexpenditurelist(String role, String fkUserId) {
		if(role.equals("super-admin"))
		{
			return expenditurerepository.getexpenditurelistforsuperadmin();
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOrganisationId = Long.parseLong(fkUserId);
			return expenditurerepository.getexpenditurelistfororagnization(fkOrganisationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId= Long.parseLong(fkUserId);
			return expenditurerepository.getexpenditurelistforadmin(fkAdminId);
		}
		return null;
		//return expenditurerepository.findAll();
	}

	public Optional<ExpenditureDetails> editexpenditure(Long id,String role) {
		if(role.equals("super-admin"))
		{
			return expenditurerepository.getexpenditureeditforsuperadmin();
		}
		if(role.equals("oragnization"))
		{
			return expenditurerepository.getexpenditureeditfororagnization();
			
		}
		if(role.equals("admin"))
		{
			return expenditurerepository.getexpenditureeditforadmin();	
		}
		 return null;
		//return expenditurerepository.findById(id);
	}

	public String updateexpenditure(ExpenditureDto expendituredto,String role,String fkUserId) {
		
		if(role.equals("super-admin") || (role.equals("oragnization")) || (role.equals("admin")))
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
			ExpenditureDetails expendituredetails=new ExpenditureDetails();
			expendituredetails.setPkExpenditureId(expendituredto.getPkExpenditureId());
			expendituredetails.setExpenditureName(expendituredto.getExpenditureName());
			expendituredetails.setExpenditureType(expendituredto.getExpenditureType());
			expendituredetails.setDescription(expendituredto.getDescription());
			expendituredetails.setExpenditureAmount(expendituredto.getExpenditureAmount());
			
			expendituredetails.setFkAdminId(expendituredto.getFkAdminId());
			expendituredetails.setAdminName(expendituredto.getAdminName());
			expendituredetails.setFkShopId(expendituredto.getFkShopId());
			expendituredetails.setFkoragnizationId(expendituredto.getFkoragnizationId());
			expendituredetails.setOragnizationName(expendituredto.getOragnizationName());
			expendituredetails.setShopName(expendituredto.getShopName());
			expendituredetails.setCreatedDate(dateString);
			expendituredetails.setCreatedBy(user+"(" + role +")");
			
			
			 expenditurerepository.save(expendituredetails);
		}
		
	return "You Don't have access to update expenditure ";	
	}

	public List<String> getexpendituredropdown(String role, String fkUserId) {
		
		if(role.equals("super-admin"))
		{
			return expenditurerepository.getexpendituredropdownforsuperadmin();
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOrganizationId = Long.parseLong(fkUserId);
			return expenditurerepository.getexpendituredropdownfororganization(fkOrganizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId = Long.parseLong(fkUserId);
			return expenditurerepository.getexpendituredropdownforadmin(fkAdminId);
		
		}
		return null;
		
	}
	
	

}
