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

import com.bill_soft.dto.BankDto;
import com.bill_soft.entity.BankDetails;
import com.bill_soft.service.BankService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BankController implements ErrorController {

		@Autowired
		private BankService bankservice;

		/**
		 * API endpoint for creating a new bank details object.
		 * 
		 * @param bankdto  The bank details object to be created.
		 * @param role     The role of the user creating the bank.
		 * @param fkUserId The foreign key ID of the user creating the bank.
		 * @return A message indicating that the bank was created successfully.
		 */
		@PostMapping("/addBankDetails")
		@ApiOperation(value = "Create a new BankDetails object")
		public String addbankdetails(@RequestBody @ApiParam(value = "Bank details object to be created") BankDto bankdto,
				@RequestParam @ApiParam(value = "Role of the user creating the bank") String role,
				@RequestParam @ApiParam(value = "Foreign key ID of the user creating the bank") String fkUserId) {
			bankservice.addbankdetails(bankdto, role, fkUserId);
			return "Bank Created Successfully";
		}

		/**
		 * API endpoint for retrieving a list of bank details objects.
		 * 
		 * @param role     The role of the user retrieving the bank details.
		 * @param fkUserId The foreign key ID of the user retrieving the bank details.
		 * @return A list of bank details objects.
		 */
		@GetMapping("/getBankDetailsList")
		public List<BankDetails> getbankdetails(@RequestParam String role, @RequestParam String fkUserId) {
			return bankservice.getbankdetailslist(role, fkUserId);
		}

		/**
		 * API endpoint for editing a bank details object.
		 * 
		 * @param id       The primary key ID of the bank details object to edit.
		 * @param role     The role of the user editing the bank details.
		 * @param fkUserId The foreign key ID of the user editing the bank details.
		 * @return An optional bank details object if it exists.
		 */
		@GetMapping("/editBankDetails/{pk_bank_id}")
		public Optional<BankDetails> editbankdetails(@PathVariable(value = "pk_bank_id") Long id, @RequestParam String role,
				@RequestParam String fkUserId) {
			return bankservice.editbankdetails(id, role, fkUserId);
		}

		/**
		 * API endpoint for updating a bank details object.
		 * 
		 * @param bankdto  The updated bank details object.
		 * @param role     The role of the user updating the bank details.
		 * @param fkUserId The foreign key ID of the user updating the bank details.
		 * @return A message indicating that the bank details were updated successfully.
		 */
		@PutMapping("/updateBankDetails")
		public String updatebankdetails(@RequestBody BankDto bankdto, @RequestParam String role,
				@RequestParam String fkUserId) {
			bankservice.updatebankdetails(bankdto, role, fkUserId);
			return "Bank Details Updated";
		}
	
}
