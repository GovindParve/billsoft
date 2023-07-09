package com.bill_soft.controller;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import org.springframework.web.multipart.MultipartFile;

import com.bill_soft.dto.CustomerDto;
import com.bill_soft.entity.CustomerDetails;
import com.bill_soft.service.CustomerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class CustomerController implements ErrorController {

	/**
	 * 
	 * This class handles the endpoints related to customer details management.
	 */
	@Autowired
	private CustomerService customerservice;

	/**
	 * 
	 * Endpoint to add a new customer.
	 * 
	 * @param customerdto The DTO object containing the customer details.
	 * @param role        The role of the user making the request.
	 * @param fkUserId    The foreign key of the user making the request.
	 * @return A string indicating the success of the operation.
	 */
	@PostMapping("/addCustomerDetails")
	public String addcustomerdetails(@RequestBody CustomerDto customerdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		customerservice.addcustomer(customerdto, role, fkUserId);
		return "customer Added successfully";
	}

	/**
	 * 
	 * Endpoint to edit an existing customer.
	 * 
	 * @param id       The id of the customer to be edited.
	 * @param role     The role of the user making the request.
	 * @param fkUserId The foreign key of the user making the request.
	 * @return An optional containing the edited customer details.
	 */
	@GetMapping("/editCustomer/{pk_customer_id}")
	public Optional<CustomerDetails> editcategory(@PathVariable(value = "pk_customer_id") Long id,
			@RequestParam String role, @RequestParam String fkUserId) {
		return customerservice.editcustomer(id, role, fkUserId);
	}

	/**
	 * 
	 * Endpoint to update an existing customer.
	 * 
	 * @param customerdto The DTO object containing the updated customer details.
	 * @param role        The role of the user making the request.
	 * @param fkUserId    The foreign key of the user making the request.
	 * @return A string indicating the success of the operation.
	 */
	@PutMapping("/updateCustomerDetails")
	public String updatecustomer(@RequestBody CustomerDto customerdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		customerservice.updatecustomerdetails(customerdto, role, fkUserId);
		return "customer updated successfully";
	}

	/**
	 * 
	 * Endpoint to get the list of customers for a dropdown list.
	 * 
	 * @param role     The role of the user making the request.
	 * @param fkUserId The foreign key of the user making the request.
	 * @return A list of customer names.
	 */
	@GetMapping("/get-customer-drop-down-list")
	public List<String> getcustomererdropdown(@RequestParam String role, @RequestParam String fkUserId) {
		return customerservice.getcustomerdropdownlist(role, fkUserId);
	}

	/**
	 * 
	 * Endpoint to bulk upload customer details from an Excel file.
	 * 
	 * @param files    The Excel file containing the customer details.
	 * @param role     The role of the user making the request.
	 * @param fkUserId The foreign key of the user making the request.
	 * @return A string indicating the success of the operation.
	 * @throws IOException,EncryptedDocumentException,InvalidFormatException,ParseException
	 */
	@PostMapping("/bulkuploadcustomer")
	public String bulkupload(@RequestParam("file") MultipartFile files, @RequestParam String role,
			@RequestParam String fkUserId)
			throws IOException, EncryptedDocumentException, InvalidFormatException, ParseException {
		String str = customerservice.bulkuploadcustomerdetails(files, role, fkUserId);
		return str;
	}

	/**
	 * 
	 * Endpoint to get the details of a specific customer.
	 * 
	 * @param role       The role of the user making the request.
	 * @param fkUserId   The foreign key of the user making the request.
	 * @param customerId The id of the customer whose details are required.
	 * @return The details of the requested customer.
	 */
	@GetMapping("/getcustomerDetails")
	public CustomerDetails getcustomerlist(@RequestParam String role, @RequestParam String fkUserId,
			String customerId) {
		return customerservice.getcustomeralllist(role, fkUserId, Long.parseLong(customerId));
	}
	
	@GetMapping("/getcustomerlist")
	public List<CustomerDetails> getcustomerList(@RequestParam String role, @RequestParam String fkUserId){
		return customerservice.getCustomerList(role, fkUserId);
	}

}
