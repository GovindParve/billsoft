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

import com.bill_soft.dto.ExpenditureDto;
import com.bill_soft.entity.ExpenditureDetails;
import com.bill_soft.service.ExpenditureService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ExpenditureController implements ErrorController{
	
	@Autowired
	private ExpenditureService expenditureservice;

	/**
	 * Endpoint to add Expenditure details
	 * @param Expendituredto Expenditure details to be added
	 * @param role Role of the user
	 * @param fkUserId User ID of the user
	 * @return Returns a message indicating if the operation was successful
	 */
	@PostMapping("/addExpenditureDetails")
	public String addexpendituredetails(@RequestBody ExpenditureDto Expendituredto,@RequestParam String role,@RequestParam String fkUserId)
	{
		 expenditureservice.addexpendituredetails(Expendituredto,role,fkUserId);
		 return "Expenditure added successfully";
	}

	/**
	 * Endpoint to get a list of all Expenditure details
	 * @param role Role of the user
	 * @return Returns a list of all Expenditure details
	 */
	@GetMapping("/getListOfExpenditure")
	public List<ExpenditureDetails> getlistofexpenditure(@RequestParam String role,@RequestParam String fkUserId)
	{
		return expenditureservice.getexpenditurelist(role, fkUserId);
	}

	/**
	 * Endpoint to get a list of all Expenditure types for the dropdown menu
	 * @param role Role of the user
	 * @return Returns a list of all Expenditure types
	 */
	@GetMapping("/getExpenditure-Drop-Down-List")
	public List<String> getexpendituredropdownlist(@RequestParam String role, @RequestParam String fkUserId)
	{
		return expenditureservice.getexpendituredropdown(role,fkUserId);
	}

	/**
	 * Endpoint to edit a specific Expenditure details
	 * @param id ID of the Expenditure details to be edited
	 * @param role Role of the user
	 * @return Returns the Expenditure details of the specified ID
	 */
	@GetMapping("/editExpenditure/{pk_expenditure_id}")
	public Optional<ExpenditureDetails> editexpenditure(@PathVariable(value="pk_expenditure_id") Long id,@RequestParam String role)
	{
		return expenditureservice.editexpenditure(id,role);
	}

	/**
	 * Endpoint to update Expenditure details
	 * @param expendituredto Expenditure details to be updated
	 * @param role Role of the user
	 * @param fkUserId User ID of the user
	 * @return Returns a message indicating if the operation was successful
	 */
	@PutMapping("/updateExpenditure")
	public String updateexpenditure(@RequestBody ExpenditureDto expendituredto,@RequestParam String role,@RequestParam String fkUserId)
	{
		 expenditureservice.updateexpenditure(expendituredto,role,fkUserId);
		return "Expenditure updated successfully";
	}
	
}
