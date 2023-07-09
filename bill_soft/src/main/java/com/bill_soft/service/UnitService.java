package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.UnitDto;
import com.bill_soft.entity.UnitDetails;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.UnitRepository;

@Service
public class UnitService {
	
	@Autowired
	private UnitRepository unitrepository;
	
	@Autowired
	private LoginRepository  loginrepository;
	
	 public String addunitdetails(UnitDto unitdto,String role,String fkUserId)
	 {
		 if(role.equals("oragnization") || role.equals("super-admin") || role.equals("admin"))
		 {
			 Long pkid=Long.parseLong(fkUserId);
				String user = loginrepository.getusernameforcategory(role, pkid);
				if (user.equals(null)) {
					return "UserName Not Found";
				}
				
				List<String> unitName = unitrepository.getUnitbyName(unitdto.getUnitName(), pkid);
				
				if(unitName.isEmpty()) {
				
				LocalDate date = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dateString = date.format(formatter);
					UnitDetails unit = new UnitDetails();
					unit.setPkUnitId(unitdto.getPkUnitId());
					unit.setUnitName(unitdto.getUnitName());
					unit.setDescription(unitdto.getDescription());
					unit.setUnitValue(unitdto.getUnitValue());
					unit.setFkAdminId(unitdto.getFkAdminId());
					unit.setAdminName(unitdto.getAdminName());
					unit.setFkShopId(unitdto.getFkShopId());
					unit.setFkoragnizationId(unitdto.getFkoragnizationId());
					unit.setOragnizationName(unitdto.getOragnizationName());
					unit.setShopName(unitdto.getShopName());
					unit.setBusinessType(unitdto.getBusinessType());
					unit.setCreatedDate(dateString);
					unit.setCreatedBy(user + "(" + role + ")");
					unitrepository.save(unit);
				
		 
				return "Unit Added Successfully";
				}else
				{
					return "Unit Name is Duplicate Please Change the Name";
				}
		 }
		 else {
		 return "You Don't have access to create unit details";
		 }
	 }
	 
	
	 
	 public List<UnitDetails> getunitlist(String role,String fkUserId)
	 {
		if(role.equals("super-admin"))
		{
			return unitrepository.getunitdetailsforsuperadmin();
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return unitrepository.getunitdetailsforadmin(fkAdminId);
			
		}
		
		if(role.equals("oragnization"))
		{
			Long fkOrganizationId=Long.parseLong(fkUserId);
			return unitrepository.getunitdetailsfororganization(fkOrganizationId);
		}
		return null;
	}

	 


	public Optional<UnitDetails> editunit(Long id, String role,String fkUserId) 
	{
		if(role.equals("super-admin"))
		{
			return unitrepository.getuniteditforsuperadmin(id);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return unitrepository.getuniteditforadmin(id,fkAdminId);
				
		}
		if(role.equals("oragnization"))
		{
			Long fkOrganizationId=Long.parseLong(fkUserId);
			return unitrepository.getuniteditfororagnization(id,fkOrganizationId);
			
		}
			return null;
		}
		


	public String updateunitdetails(UnitDto unitdto, String role, String fkUserId) {
		 if(role.equals("oragnization") || role.equals("super-admin") || role.equals("admin"))
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
			UnitDetails unit=new UnitDetails();
			unit.setPkUnitId(unitdto.getPkUnitId());
			unit.setUnitName(unitdto.getUnitName());
			unit.setDescription(unitdto.getDescription());
			unit.setUnitValue(unitdto.getUnitValue());
			unit.setFkAdminId(unitdto.getFkAdminId());
			unit.setAdminName(unitdto.getAdminName());
			unit.setFkShopId(unitdto.getFkShopId());
			unit.setFkoragnizationId(unitdto.getFkoragnizationId());
			unit.setOragnizationName(unitdto.getOragnizationName());
			unit.setShopName(unitdto.getShopName());
			unit.setBusinessType(unitdto.getBusinessType());
			unit.setCreatedDate(dateString);
			unit.setCreatedBy(user+"(" + role +")");
			 unitrepository.save(unit);
		 }
		 return "You Don't have access  to create unit details";
	 }
	 
		
	



	public List<String> getunitdropdownlist(String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			return unitrepository.getunitdropdownforsuperadmin();
		}
		
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return unitrepository.getunitdropdownforadmin(fkAdminId);
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return unitrepository.getunitdropdownfororagnization(fkOragnizationId);
		}
		return null;
	}
	
	
	

}
