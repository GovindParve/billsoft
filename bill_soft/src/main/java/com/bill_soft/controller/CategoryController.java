package com.bill_soft.controller;

/**

The CategoryController class handles the REST API requests related to Category.
This controller is responsible for handling the CRUD operations on the Category entity.
*/
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

import com.bill_soft.dto.CategoryDto;
import com.bill_soft.entity.Category;
import com.bill_soft.service.CategoryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CategoryController implements ErrorController {

	@Autowired
	private CategoryService categoryservice;

	/**
	 * This method handles the HTTP POST request to add a new Category to the
	 * database.
	 * 
	 * @param categorydto - The CategoryDto object that contains the details of the
	 *                    new Category.
	 * @param role        - The role of the user who is adding the new Category.
	 * @param fkUserId    - The foreign key of the user who is adding the new
	 *                    Category.
	 * @return String - The message indicating the success or failure of the
	 *         operation.
	 */

	@PostMapping("/addCategory")
	public String addcategory(@RequestBody CategoryDto categorydto, @RequestParam String role,
			@RequestParam String fkUserId) {
		return categoryservice.addcatgory(categorydto, role, fkUserId);
	}

	/**
	 * This method handles the HTTP GET request to retrieve a list of Categories
	 * from the database.
	 * 
	 * @param role     - The role of the user who is requesting the list of
	 *                 Categories.
	 * @param fkUserId - The foreign key of the user who is requesting the list of
	 *                 Categories.
	 * @return List<Category> - The list of Categories.
	 */
	@GetMapping("/catgoryList")
	public List<Category> getcategorylist(@RequestParam String role, String fkUserId) {
		return categoryservice.getcategorylist(role, fkUserId);
	}

	/**
	 * This method handles the HTTP GET request to retrieve a list of Categories in
	 * the form of a dropdown from the database.
	 * 
	 * @param role     - The role of the user who is requesting the list of
	 *                 Categories.
	 * @param fkUserId - The foreign key of the user who is requesting the list of
	 *                 Categories.
	 * @return List<String> - The list of Categories in the form of a dropdown.
	 */

	@GetMapping("/getCategoryDrop-Down-List")
	public List<String> getcategorydropdown(String role, String fkUserId) {
		return categoryservice.getcategorydrodownlist(role, fkUserId);
	}

	/**
	 * This method handles the HTTP GET request to retrieve a Category from the
	 * database.
	 * 
	 * @param id       - The primary key of the Category to be retrieved.
	 * @param role     - The role of the user who is requesting the Category.
	 * @param fkUserId - The foreign key of the user who is requesting the Category.
	 * @return Optional<Category> - The Category object wrapped in an Optional.
	 */
	@GetMapping("/editCategory/{pk_category_id}")
	public Optional<Category> editcategory(@PathVariable(value = "pk_category_id") Long id, @RequestParam String role,
			@RequestParam String fkUserId) {
		return categoryservice.editcategory(id, role, fkUserId);
	}

	/**
	 * 
	 * Updates a category in the database.
	 * 
	 * @param categorydto The CategoryDto object representing the updated category
	 *                    information
	 * @param role        The role of the user performing the action
	 * @param fkUserId    The Id of the user performing the action
	 * @return A string message indicating the success of the operation
	 */
	@PutMapping("/updateCategory")
	public String updatecategory(@RequestBody CategoryDto categorydto, @RequestParam String role,
			@RequestParam String fkUserId) {
		return categoryservice.updatecategory(categorydto, role, fkUserId);
	}

}
