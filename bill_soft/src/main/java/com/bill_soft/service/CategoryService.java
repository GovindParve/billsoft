package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.CategoryDto;
import com.bill_soft.entity.Category;
import com.bill_soft.repository.CategoryRepository;
import com.bill_soft.repository.LoginRepository;
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryrepository;
	
	@Autowired 
	private LoginRepository loginrepository;

	public String addcatgory(CategoryDto categorydto,String role,String fkUserId) {
		
		if(role.equals("super-admin") || (role.equals("oragnization"))  || (role.equals("admin")))
		{
			Long pkid=Long.parseLong(fkUserId);
			String user=loginrepository.getusernameforcategory(role,pkid);
			
			if(user.equals(null)) 
			{
				return "UserName Not  Found";
			}
			
			LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);	 
			 
			Category category=new Category();
			category.setPkCategoryId(categorydto.getPkCategoryId());
			category.setCategoryName(categorydto.getCategoryName());
			category.setFkAdminId(categorydto.getFkAdminId());
			category.setAdminName(categorydto.getAdminName());
			category.setFkoragnizationId(categorydto.getFkoragnizationId());
			category.setOragnizationName(categorydto.getOragnizationName());
			category.setFkShopId(categorydto.getFkShopId());
		    category.setShopName(categorydto.getShopName());
			category.setBusinessType(categorydto.getBusinessType());
			category.setCreatedDate(dateString);
			category.setCreatedBy(user+"(" + role +")");
			categoryrepository.save(category);
			  return "category added successfully";
			
		}
		
		
		
		return "You don't have access to Create Category";
	}

	public List<Category> getcategorylist(String role,String fkUserId) 
	{
		if(role.equals("super-admin"))
		{
			return categoryrepository.getcategorylistforsuperadmin();
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return categoryrepository.getcategorylistfororagnization(fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return categoryrepository.getcategorylistforadmin(fkAdminId);
		}
		return null;
	}

	
	public Optional<Category> editcategory(Long id,String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			return categoryrepository.getcategoryeditforsuperadmin(id);
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return categoryrepository.getcategoryeditfororagnization(fkOragnizationId,id);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return categoryrepository.getcategoryeditforadmin(fkAdminId,id);
		}
		return null;
	}

	

	
	public List<String> getcategorydrodownlist(String role,String fkUserId) {
		if(role.equals("super-admin"))
		{
			return categoryrepository.getcategorydropdownforsuperadmin();
		}
		if(role.equals("oragnization"))
		{
			Long fkOragnizationId=Long.parseLong(fkUserId);
			return categoryrepository.getcategorydropdownfororagnization(fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return categoryrepository.getcategorydropdownforadmin(fkAdminId);
		}
		return null;
	}

	public String updatecategory(CategoryDto categorydto, String role,String fkUserId) {
		
		if(role.equals("super-admin") || (role.equals("oragnization"))  || (role.equals("admin")))
		{
			Long pkid=Long.parseLong(fkUserId);
			String user=loginrepository.getusernameforcategory(role,pkid);
			
			if(user.equals(null)) 
			{
				return "UserName Not  Found";
			}
			
			
			LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
		
			
			Category category=new Category();
			category.setPkCategoryId(categorydto.getPkCategoryId());
			category.setCategoryName(categorydto.getCategoryName());
			category.setFkAdminId(categorydto.getFkAdminId());
			category.setAdminName(categorydto.getAdminName());
			category.setFkoragnizationId(categorydto.getFkoragnizationId());
			category.setOragnizationName(categorydto.getOragnizationName());
			//category.setFkShopId(categorydto.getFkShopId());
			//category.setShopName(categorydto.getShopName());
			category.setBusinessType(categorydto.getBusinessType());
			category.setCreatedDate(dateString);
			category.setCreatedBy(user+"(" + role +")");
			  categoryrepository.save(category);
			  return "category updated successfully";
			
		}
	
		return "You don't have access to Create Category";
	}
	
	

}
