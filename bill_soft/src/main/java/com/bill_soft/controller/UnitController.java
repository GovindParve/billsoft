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

import com.bill_soft.dto.UnitDto;
import com.bill_soft.entity.UnitDetails;
import com.bill_soft.service.UnitService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UnitController implements ErrorController {

	/**
	 * 
	 * This is the UnitController class that handles HTTP requests related to unit
	 * management. It includes methods for adding, editing, and updating unit
	 * details, as well as getting unit lists and drop-down menus.
	 */
	@Autowired
	private UnitService unitservice;

	/**
	 * 
	 * Adds unit details to the database.
	 * 
	 * @param unitdto  the UnitDto object containing the unit details to be added
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a string indicating that the unit details were added successfully
	 */
	@PostMapping("/addUnitDetails")
	public String addunitdetails(@RequestBody UnitDto unitdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		return unitservice.addunitdetails(unitdto, role, fkUserId);
		//return "Unit added successfully";
	}

	/**
	 * 
	 * Retrieves a list of unit details from the database.
	 * 
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a list of UnitDetails objects
	 */
	@GetMapping("/getUnitList")
	public List<UnitDetails> getunitlist(@RequestParam String role, @RequestParam String fkUserId) {
		return unitservice.getunitlist(role, fkUserId);
	}

	/**
	 * 
	 * Retrieves a drop-down list of unit details from the database.
	 * 
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a list of strings representing the unit details
	 */
	@GetMapping("/getUnit-Drop-Down-List")
	public List<String> getunitdropdown(@RequestParam String role, @RequestParam String fkUserId) {
		return unitservice.getunitdropdownlist(role, fkUserId);
	}

	/**
	 * 
	 * Retrieves a specific unit detail from the database for editing.
	 * 
	 * @param id       the ID of the unit detail to be edited
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return an Optional containing the UnitDetails object to be edited, or an
	 *         empty Optional if it is not found
	 */
	@GetMapping("/getUnitToEdit/{pk_unit_id}")
	public Optional<UnitDetails> editunit(@PathVariable(value = "pk_unit_id") Long id, @RequestParam String role,
			@RequestParam String fkUserId) {
		return unitservice.editunit(id, role, fkUserId);
	}

	/**
	 * 
	 * Updates unit details in the database.
	 * 
	 * @param unitdto  the UnitDto object containing the updated unit details
	 * @param role     the user role
	 * @param fkUserId the user ID
	 * @return a string indicating that the unit details were updated successfully
	 */
	@PutMapping("/updateUnitDetails")
	public String updateunidetails(@RequestBody UnitDto unitdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		unitservice.updateunitdetails(unitdto, role, fkUserId);
		return "Unit updated Successfully";
	}

}
