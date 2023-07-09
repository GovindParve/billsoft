package com.bill_soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.dto.BankPaymentDto;
import com.bill_soft.dto.CustomerPaymentDto;
import com.bill_soft.dto.EmployeePaymentDto;
import com.bill_soft.dto.ExpenditurePaymentDto;
import com.bill_soft.dto.SupplierPaymentDto;
import com.bill_soft.service.BillingService;
import com.bill_soft.service.CashBookService;
import com.bill_soft.service.GoodReceiveService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CashbookController implements ErrorController {
	/**
	 * 
	 * Controller class for handling cash book related requests.
	 */

	@Autowired
	private CashBookService cashbookservice;
	@Autowired
	private GoodReceiveService goodReceiveService;
	@Autowired
	private BillingService billingService;

	
	///////////Supplier Payment API's/////////////
	/**
	 * 
	 * Get list of suppliers for cash book.
	 * 
	 * @param role     User role
	 * @param fkUserId User ID
	 * @return List of supplier names
	 */
	@GetMapping("/getSupplierListForCashBook")
	public List<String> getSupplieListForCashBook(String role, String fkUserId) {
		return goodReceiveService.getSupplierListForCashBook(role, fkUserId);
	}

	/**
	 * 
	 * Get list of bill numbers for cash book.
	 * 
	 * @param role         User role
	 * @param fkUserId     User ID
	 * @param fkSupplierId Supplier ID
	 * @return List of bill numbers
	 */
	@GetMapping("/getbillNoListForCashBook")
	public List<String> getbillNoListForCashBook(String role, String fkUserId, String fkSupplierId) {
		return goodReceiveService.getbillNoListForCashBook(role, fkUserId, Long.parseLong(fkSupplierId));
	}

	/**
	 * 
	 * Save supplier payment details.
	 * 
	 * @param supplierpaymentdto DTO object for supplier payment details
	 * @param role               User role
	 * @param fkUserId           User ID
	 * @return Success message
	 */
	@PostMapping("/saveSupplierpayment")
	public String savesupplierpayment(@RequestBody SupplierPaymentDto supplierpaymentdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		cashbookservice.savesupplierpaymentdetails(supplierpaymentdto, role, fkUserId);
		return "supplier payment successsfully";
	}
	
	
	//////////Expenditure Payment API's///////////////

	/**
	 * 
	 * Save expenditure payment details.
	 * 
	 * @param expenditurepaymentdto DTO object for expenditure payment details
	 * @param role                  User role
	 * @param fkUserId              User ID
	 * @return Success message
	 */
	@PostMapping("/saveExpenditurePayment")
	public String saveexpenditurepayment(@RequestBody ExpenditurePaymentDto expenditurepaymentdto,
			@RequestParam String role, @RequestParam String fkUserId) {
		cashbookservice.saveexpenditurepaymentdetails(expenditurepaymentdto, role, fkUserId);
		return "expenditure payment successfully";
	}
	
	////////Credit Customer Payment/////////////
	
	@GetMapping("/getCreditCustomerListForCashbook")
	public List<String> getCreditCustomerList(@RequestParam String role, @RequestParam String fkUserId)
	{
	   return billingService.getCreditCustomerList(role, fkUserId);
	}
	
	
	@GetMapping("/getCreditCustomerBillNo")
	public List<String> getCreditCustomerBillNo(@RequestParam String contactNo)
	{
		return billingService.getCreditCustomerBillNo(contactNo);
	}
	
	@GetMapping("/getCreditDetails")
	public List<String> getCreditDetails(@RequestParam String billNo, @RequestParam String fkUserId, @RequestParam String role)
	{
		return billingService.getCreditDetailsByBillNo(Long.parseLong(billNo), fkUserId, role);
	}

	/**
	 * 
	 * Save customer payment details.
	 * 
	 * @param customerpaymentdto DTO object for customer payment details
	 * @param role               User role
	 * @param fkUserId           User ID
	 * @return Success message
	 */
	@PostMapping("/saveCustomerPayment")
	public String savecustomerpayment(@RequestBody CustomerPaymentDto customerpaymentdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		cashbookservice.savecustomerpaymentdetails(customerpaymentdto, role, fkUserId);
		return "customer payment successfully";
	}

	/**
	 * 
	 * Saves employee payment details to the cashbook.
	 * 
	 * @param employeepaymentdto the EmployeePaymentDto object containing the
	 *                           payment details
	 * @param role               the role of the user making the request
	 * @param fkUserId           the user ID of the user making the request
	 * @return a String indicating the success of the operation
	 */
	
	
	
	
	
	@PostMapping("/saveEmployeePayment")
	public String saveemployeepayment(@RequestBody EmployeePaymentDto employeepaymentdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		cashbookservice.saveemployeepaymentdetails(employeepaymentdto, role, fkUserId);
		return "employee payment successfully";
	}

	/**
	 * 
	 * Saves bank payment details to the cashbook.
	 * 
	 * @param bankpaymentdto the BankPaymentDto object containing the payment
	 *                       details
	 * @param role           the role of the user making the request
	 * @param fkUserId       the user ID of the user making the request
	 * @return a String indicating the success of the operation
	 */
	@PostMapping("/saveBaankPayment")
	public String savebankpayment(@RequestBody BankPaymentDto bankpaymentdto, @RequestParam String role,
			@RequestParam String fkUserId) {
		cashbookservice.savebankpaymentdetails(bankpaymentdto, role, fkUserId);
		return "bank payment successfully";
	}
}
