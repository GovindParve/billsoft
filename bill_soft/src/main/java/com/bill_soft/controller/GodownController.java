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

import com.bill_soft.dto.GodownDto;
import com.bill_soft.entity.GodownEntry;
import com.bill_soft.service.GodownService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class GodownController implements ErrorController {

	/**
	 * 
	 * This is a controller class for managing godown related operations.
	 */
	@Autowired
	private GodownService godownservice;

	/**
	 * 
	 * This method is used to add a new godown.
	 * 
	 * @param godowndto A DTO object containing godown details.
	 * @param role      A string representing the role of the user.
	 * @param fkUserId  A string representing the foreign key of the user.
	 * @return A string message indicating the success of the operation.
	 */
	@PostMapping("/addGodown")
	public String addgodowndetails(@RequestBody GodownDto godowndto, @RequestParam String role,
			@RequestParam String fkUserId) {
		godownservice.addgodown(godowndto, role, fkUserId);
		return "Godown created successfully";
	}

	/**
	 * 
	 * This method is used to get the list of godowns.
	 * 
	 * @param role     A string representing the role of the user.
	 * @param fkUserId A string representing the foreign key of the user.
	 * @return A list of GodownEntry objects representing the godown details.
	 */
	@GetMapping("/getGodownList")
	public List<GodownEntry> getgodownList(@RequestParam String role, @RequestParam String fkUserId) {
		return godownservice.getgodownlist(role, fkUserId);
	}

	/**
	 * 
	 * This method is used to edit the godown details.
	 * 
	 * @param id       A long integer representing the godown ID.
	 * @param role     A string representing the role of the user.
	 * @param fkUserId A string representing the foreign key of the user.
	 * @return An optional GodownEntry object representing the edited godown
	 *         details.
	 */
	@GetMapping("/editGodown/{pk_godown_id}")
	public Optional<GodownEntry> editgodown(@PathVariable(value = "pk_godown_id") Long id, @RequestParam String role,
			@RequestParam String fkUserId) {
		return godownservice.editgodown(id, role, fkUserId);
	}

	/**
	 * 
	 * This method is used to get the godown drop-down list.
	 * 
	 * @param role     A string representing the role of the user.
	 * @param fkUserId A string representing the foreign key of the user.
	 * @return A list of string values representing the godown drop-down list.
	 */
	@GetMapping("/getGodown-Drop-Down-List")
	public List<String> getgodowndropdown(@RequestParam String role, @RequestParam String fkUserId) {
		return godownservice.getgodowndropdownlist(role, fkUserId);
	}

	/**
	 * 
	 * This method is used to update the godown details.
	 * 
	 * @param godowndto A DTO object containing godown details.
	 * @param role      A string representing the role of the user.
	 * @param fkUserId  A string representing the foreign key of the user.
	 * @return A string message indicating the success of the operation.
	 */
	@PutMapping("/updategodown")
	public String updategodown(@RequestBody GodownDto godowndto, @RequestParam String role,
			@RequestParam String fkUserId) {
		godownservice.updategodown(godowndto, role, fkUserId);
		return "Godown updated successfully";
	}
}
