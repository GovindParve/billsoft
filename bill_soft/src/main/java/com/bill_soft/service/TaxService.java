package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.TaxDto;
import com.bill_soft.entity.TaxDetails;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.TaxRepository;
@Service
public class TaxService {
	@Autowired
	private TaxRepository taxrepository;
	
	@Autowired
	private LoginRepository  loginrepository;
	public String addtaxdetails( TaxDto taxdto,String role,String fkUserId)
	{
		if(role.equals("super-admin") || role.equals("oragnization")  || role.equals("admin"))
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
			TaxDetails taxdetails=new TaxDetails();
			taxdetails.setPkTaxId(taxdto.getPkTaxId());
			taxdetails.setTaxName(taxdto.getTaxName());
			taxdetails.setPercentage(taxdto.getPercentage());
			taxdetails.setCgst(taxdto.getCgst());
			taxdetails.setSgst(taxdto.getSgst());
			taxdetails.setFkAdminId(taxdto.getFkAdminId());
			taxdetails.setAdminName(taxdto.getAdminName());
			taxdetails.setFkShopId(taxdto.getFkShopId());
			taxdetails.setFkoragnizationId(taxdto.getFkoragnizationId());
			taxdetails.setOragnizationName(taxdto.getOragnizationName());
			taxdetails.setShopName(taxdto.getShopName());
			taxdetails.setBusinessType(taxdto.getBusinessType());
			taxdetails.setCreatedDate(dateString);
			taxdetails.setCreatedBy(user+"(" + role +")");
			 taxrepository.save(taxdetails);
			
		}
	return "You Don't have access to create tax details";
	
	}
	
	public List<TaxDetails> getlistoftax(String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			return taxrepository.gettaxlistforsuperadmin();
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return taxrepository.gettaxlistfororagnization(fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return taxrepository.gettaxlistforadmin(fkAdminId);
		}
		return null;
	}

	public Optional<TaxDetails> edittax(Long id,String role,String fkUserId) {
		
		if(role.equals("super-admin"))
		{
			return taxrepository.gettaxeditforsuperadmin();
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return taxrepository.gettaxeditfororagnization(fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return taxrepository.gettaxeditforadmin(fkAdminId);
		}
		
		return null;
	}

	public String updatetax(TaxDto taxdto,String role,String fkUserId) {
		if(role.equals("super-admin") || role.equals("oragnization")  || role.equals("admin"))
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
			TaxDetails taxdetails=new TaxDetails();
			taxdetails.setPkTaxId(taxdto.getPkTaxId());
			taxdetails.setTaxName(taxdto.getTaxName());
			taxdetails.setPercentage(taxdto.getPercentage());
			taxdetails.setCgst(taxdto.getCgst());
			taxdetails.setSgst(taxdto.getSgst());
			taxdetails.setFkAdminId(taxdto.getFkAdminId());
			taxdetails.setAdminName(taxdto.getAdminName());
			taxdetails.setFkShopId(taxdto.getFkShopId());
			taxdetails.setFkoragnizationId(taxdto.getFkoragnizationId());
			taxdetails.setOragnizationName(taxdto.getOragnizationName());
			taxdetails.setShopName(taxdto.getShopName());
			taxdetails.setBusinessType(taxdto.getBusinessType());
			taxdetails.setCreatedDate(dateString);
			taxdetails.setCreatedBy(user+"(" + role +")");
			 taxrepository.save(taxdetails);
			
		}
	return "You Don't have access to update tax details";
	}

	public List<String> gettaxdropdown(String role ,String fkUserId) {
		if(role.equals("super-admin"))
		{
		return taxrepository.gettaxdropdownforsuperadmin();
			    		  
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			 return taxrepository.gettaxdropdownfororagnization(fkOragnizationId);
		}
		if(role.equals("admin")) 
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			 return taxrepository.gettaxdropdownforadmin(fkAdminId);
		}
		return null;
	}

}
