package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.SubCategoryDto;
import com.bill_soft.entity.SubCategory;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	@Autowired
	private SubCategoryRepository subcategoryrepository;
	@Autowired
	private LoginRepository loginrepository;

	public String addsubcategory(SubCategoryDto subcategorydto, String role, String fkUserId) {
		if (role.equals("super-admin") || role.equals("oragnization") || (role.equals("admin"))) {
			Long pkid = Long.parseLong(fkUserId);
			String user = loginrepository.getusernameforsubcategory(role, pkid);
			if (user.equals(null)) {
				return "UserName Not Found";
			}
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			SubCategory subcategory = new SubCategory();
			subcategory.setPkSubCategoryId(subcategorydto.getPkSubCategoryId());
			subcategory.setSubCategoryName(subcategorydto.getSubCategoryName());
			subcategory.setFkCategoryId(subcategorydto.getFkCategoryId());
			subcategory.setCategoryName(subcategorydto.getCategoryName());
			subcategory.setFkAdminId(subcategorydto.getFkAdminId());
			subcategory.setAdminName(subcategorydto.getAdminName());
			subcategory.setFkOragnizationId(subcategorydto.getFkOragnizationId());
			subcategory.setOragnizationName(subcategorydto.getOrganizationName());
			subcategory.setFkShopId(subcategorydto.getFkShopId());
			subcategory.setShopName(subcategorydto.getShopName());
			subcategory.setBusinessType(subcategorydto.getBusinessType());
			subcategory.setCreatedDate(dateString);
			subcategory.setCreateBy(user + "(" + role + ")");

			subcategoryrepository.save(subcategory);
			return "Subcategory added Successfully";
		}

		return "you don't have access to create subcategory";
	}

	public List<SubCategory> getsubcategorylist(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return subcategoryrepository.getsubcategorylistforsuperadmin();
		}

		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return subcategoryrepository.getsubcategorylistfororgnization(fkOragnizationId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return subcategoryrepository.getsubcategorylistforadmin(fkAdminId);
		}
		// return subcategoryrepository.findAll();
		return null;
	}

	public Optional<SubCategory> editsubcategory(Long id, String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return subcategoryrepository.getsubcategoryeditforsuperadmin(id);
		}
		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return subcategoryrepository.getsubcategoryeditfororagnization(id, fkOragnizationId);
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return subcategoryrepository.getsubcategoryeditforadmin(id, fkAdminId);
		}
		// return subcategoryrepository.findById(id) ;
		return null;
	}

	public String updatesubcategory(SubCategoryDto subcategorydto, String role, String fkUserId) {
		if (role.equals("super-admin") || role.equals("oragnization") || (role.equals("admin"))) {
			Long pkid = Long.parseLong(fkUserId);
			String user = loginrepository.getusernameforsubcategory(role, pkid);
			if (user.equals(null)) {
				return "UserName Not Found";
			}
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			SubCategory subcategory = new SubCategory();
			subcategory.setPkSubCategoryId(subcategorydto.getPkSubCategoryId());
			subcategory.setSubCategoryName(subcategorydto.getSubCategoryName());
			subcategory.setFkCategoryId(subcategorydto.getFkCategoryId());
			subcategory.setCategoryName(subcategorydto.getCategoryName());
			subcategory.setFkAdminId(subcategorydto.getFkAdminId());
			subcategory.setAdminName(subcategorydto.getAdminName());
			subcategory.setFkOragnizationId(subcategorydto.getFkOragnizationId());
			subcategory.setOragnizationName(subcategorydto.getOrganizationName());

			subcategory.setFkShopId(subcategorydto.getFkShopId());
			subcategory.setShopName(subcategorydto.getShopName());
			subcategory.setBusinessType(subcategorydto.getBusinessType());
			subcategory.setCreatedDate(dateString);
			subcategory.setCreateBy(user + "(" + role + ")");

			subcategoryrepository.save(subcategory);
			return "subcategory updated successfully";
		}

		return "you don't have access to create subcategory";
	}

	public List<String> getsubcategorydropdown(String role, String fkUserId) {
		if (role.equals("super-admin")) {
			return subcategoryrepository.getsubcategorydropdownlistforsuperadmin();
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			return subcategoryrepository.getsubcategorydropdownlistforadmin(fkAdminId);
		}
		if (role.equals("oragnization")) {
			Long fkOragnizationId = Long.parseLong(fkUserId);
			return subcategoryrepository.getsubcategorydropdownlistfororagnization(fkOragnizationId);
		}
		return null;
	}

	public List<String> getSubcategoryListFilter(String fkUserId, String role,String category)
	{
		if (role.equals("super-admin")) {
			if(category == null)
			{
			    return subcategoryrepository.getsubcategorydropdownlistforsuperadminPurchaseFilter();
			}
			else 
			{
				Long categoryId = Long.parseLong(category);
				return subcategoryrepository.getsubcategorydropdownlistforsuperadminPurchaseFilterCatId(categoryId);
			}
		}
		if (role.equals("admin")) {
			Long fkAdminId = Long.parseLong(fkUserId);
			if( category == null)
			{
			return subcategoryrepository.getsubcategorydropdownlistforadminPurchaseFilter(fkAdminId);
			}
			else
			{
				Long categoryId = Long.parseLong(category);
				return subcategoryrepository.getsubcategorydropdownlistforadminPurchaseFilterCatId(fkAdminId,categoryId);	
			}
		}
		if (role.equals("oragnization")) {
			Long fkOrganizationId = Long.parseLong(fkUserId);
			if( category == null)
			{
			return subcategoryrepository.getsubcategorydropdownlistfororagnizationPurchaseFilter(fkOrganizationId);
			}
			else 
			{
				Long categoryId = Long.parseLong(category);
				return subcategoryrepository.getsubcategorydropdownlistfororagnizationPurchaseFilterCatId(fkOrganizationId, categoryId);
			}
		}
		return null;
	}

}
