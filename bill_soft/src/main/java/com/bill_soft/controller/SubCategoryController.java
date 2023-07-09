package com.bill_soft.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.dto.SubCategoryDto;
import com.bill_soft.entity.SubCategory;
import com.bill_soft.service.SubCategoryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class SubCategoryController implements ErrorController {

	/**
	 * 
	 * The SubCategoryController class manages the endpoints related to SubCategory
	 * details.
	 * 
	 */

	@Autowired
	private SubCategoryService subcategoryservice;

	/**
	 * Adds the SubCategory details to the subcategory_details table.
	 * 
	 * @param subcategorydto the SubCategoryDto object containing the details of the
	 *                       SubCategory to be added
	 * @param role           the user's role
	 * @param fkUserId       the user's ID
	 * @return a string indicating the result of the operation
	 */
	@PostMapping("/addSubCategory")
	public String addsubcategory(@RequestBody SubCategoryDto subcategorydto, @RequestParam String role,
			@RequestParam String fkUserId) {
		return subcategoryservice.addsubcategory(subcategorydto, role, fkUserId);
	}

	/**
	 * Retrieves the list of SubCategory details from the subcategory_details table.
	 * 
	 * @param role     the user's role
	 * @param fkUserId the user's ID
	 * @return a List of SubCategory objects
	 */
	@GetMapping("/subCategoryList")
	public List<SubCategory> getsubcategorylist(@RequestParam String role, @RequestParam String fkUserId) {
		return subcategoryservice.getsubcategorylist(role, fkUserId);
	}

	/**
	 * Retrieves the SubCategory details with the given ID from the
	 * subcategory_details table.
	 * 
	 * @param id       the ID of the SubCategory to retrieve
	 * @param role     the user's role
	 * @param fkUserId the user's ID
	 * @return an Optional containing the SubCategory object with the given ID, or
	 *         an empty Optional if not found
	 */
	@GetMapping("/editSubCategory/{pk_subcategory_id}")
	public Optional<SubCategory> editsubcategory(@PathVariable(value = "pk_subcategory_id") Long id,
			@RequestParam String role, @RequestParam String fkUserId) {
		return subcategoryservice.editsubcategory(id, role, fkUserId);
	}

	/**
	 * Retrieves a list of SubCategory IDs and names from the subcategory_details
	 * table.
	 * 
	 * @param role     the user's role
	 * @param fkUserId the user's ID
	 * @return a List of strings in the format "pk_subcategory_id -
	 *         subcategory_name"
	 */
	@GetMapping("/getSubcategory-Drop-Down-List")
	public List<String> getsubcategorydropdown(@RequestParam String role, @RequestParam String fkUserId) {
		return subcategoryservice.getsubcategorydropdown(role, fkUserId);
	}

	/**
	 * Updates the SubCategory details in the subcategory_details table.
	 * 
	 * @param subcategorydto the SubCategoryDto object containing the updated
	 *                       details of the SubCategory
	 * @param role           the user's role
	 * @param fkUserId       the user's ID
	 * @return a string indicating the result of the operation
	 */
	@PutMapping("/updateSubCategory")
	public String updatesubcategory(@RequestBody SubCategoryDto subcategorydto, @RequestParam String role,
			@RequestParam String fkUserId) {
		return subcategoryservice.updatesubcategory(subcategorydto, role, fkUserId);
	}

	/**
	 * Retrieves a list of SubCategory names from the subcategory_details table.
	 * 
	 * @param fkUserId   the user's ID
	 * @param role       the user's role
	 * @param categoryId (optional) the ID of the Category to filter by
	 * @return a List of strings containing the SubCategory names
	 */
	@GetMapping("/getSubCategoryListFilterForPurchase")
	public List<String> getSubcategoryListFilter(String fkUserId, String role,
			@RequestParam(required = false) String categoryId) {
		return subcategoryservice.getSubcategoryListFilter(fkUserId, role, categoryId);
	}

}