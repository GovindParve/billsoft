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

import com.bill_soft.dto.TaxDto;
import com.bill_soft.entity.TaxDetails;
import com.bill_soft.service.TaxService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class TaxController implements ErrorController {
	/**
	 * 
	 * This is the TaxController class that handles HTTP requests related to tax
	 * management. It includes methods for adding, editing, and updating tax
	 * details, as well as getting tax lists and drop-down menus.
	 */
	@Autowired
	private TaxService taxservice;

	/**
	 * 
	 * Adds tax details to the database.
	 * 
	 * @param taxdto   the TaxDto object containing the tax details to be added
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a string indicating that the tax details were added successfully
	 */
	@PostMapping("/addTaxDetails")
	public String addtaxdetails(@RequestBody TaxDto taxdto, @RequestParam String role, @RequestParam String fkUserId) {
		taxservice.addtaxdetails(taxdto, role, fkUserId);
		return "Tax Added Successfully";
	}

	/**
	 * 
	 * Retrieves a list of tax details from the database.
	 * 
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a list of TaxDetails objects
	 */
	@GetMapping("/getTaxList")
	public List<TaxDetails> getlistoftax(@RequestParam String role, @RequestParam String fkUserId) {
		return taxservice.getlistoftax(role, fkUserId);
	}

	/**
	 * 
	 * Retrieves a specific tax detail from the database for editing.
	 * 
	 * @param id       the ID of the tax detail to be edited
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return an Optional containing the TaxDetails object to be edited, or an
	 *         empty Optional if it is not found
	 */
	@GetMapping("/editTaxDetails/{pk_tax_id}")
	public Optional<TaxDetails> edittax(@PathVariable(value = "pk_tax_id") Long id, @RequestParam String role,
			@RequestParam String fkUserId) {
		return taxservice.edittax(id, role, fkUserId);
	}

	/**
	 * 
	 * Retrieves a drop-down list of tax details from the database.
	 * 
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a list of strings representing the tax details
	 */
	@GetMapping("/getTax-Drop-Down-List")
	public List<String> gettaxdropdown(@RequestParam String role, @RequestParam String fkUserId) {
		return taxservice.gettaxdropdown(role, fkUserId);
	}

	/**
	 * 
	 * Updates tax details in the database.
	 * 
	 * @param taxdto   the TaxDto object containing the updated tax details
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a string indicating that the tax details were updated successfully
	 */
	@PutMapping("/updateTax")
	public String updatetaxdetails(@RequestBody TaxDto taxdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		taxservice.updatetax(taxdto, role, fkUserId);
		return "tax updated successfully";
	}
}
