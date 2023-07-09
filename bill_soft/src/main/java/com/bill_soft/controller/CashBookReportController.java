package com.bill_soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill_soft.entity.BankPayment;
import com.bill_soft.entity.CustomerPayment;
import com.bill_soft.entity.EmployeePayment;
import com.bill_soft.entity.ExpenditurePayment;

import com.bill_soft.entity.SupplierPayment;
import com.bill_soft.service.CashBookReportService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CashBookReportController implements ErrorController {
	@Autowired
	private CashBookReportService cashbookreportservice;

	@GetMapping("/suppliertransactionreportsuppliernamewise")
	private List<SupplierPayment> getsuppliercashbookreport(String role, String fkUserId, String supplierName) {
		return cashbookreportservice.getsupplierpaymentreport(role, fkUserId, supplierName);
	}

	@GetMapping("/suppliertransactionreportdatewise")
	private List<SupplierPayment> suppliertransactionreportdatewise(String role, String fkUserId, String date) {
		return cashbookreportservice.getsupplierpaymentreportdatewise(role, fkUserId, date);
	}

	@GetMapping("/suppliertransactionreportrangewise")
	private List<SupplierPayment> suppliertransactionreportrangewise(String role, String fkUserId, String Fromdate,
			String Todate) {
		return cashbookreportservice.getsupplierpaymentreportrangeewise(role, fkUserId, Fromdate, Todate);
	}

	@GetMapping("/suppliertransactionreportbillnowise")
	private List<SupplierPayment> suppliertransactionreportbillnowise(String role, String fkUserId, String supplierName,
			String billNo) {
		return cashbookreportservice.getsupplierpaymentreportbillnoewise(role, fkUserId, supplierName, billNo);
	}

	@GetMapping("/customertransactionreportcustomernamewise")
	private List<CustomerPayment> customerrtransactionreportcustnamewise(String role, String fkUserId,
			String customerName) {
		return cashbookreportservice.getcustomerpaymentreportcustomernameewise(role, fkUserId, customerName);
	}

	@GetMapping("/customertransactionreportdatewise")
	private List<CustomerPayment> customerrtransactionreportcusywise(String role, String fkUserId, String date) {
		return cashbookreportservice.getcustomerpaymentreportdatewise(role, fkUserId, date);
	}

	@GetMapping("/customertransactionreportrangewise")
	private List<CustomerPayment> customertransactionreportrangewise(String role, String fkUserId, String Fromdate,
			String Todate) {
		return cashbookreportservice.customertransactionreportrangewise(role, fkUserId, Fromdate, Todate);
	}

	@GetMapping("/customertransactionreportbillnowise")
	private List<CustomerPayment> customertransactionreportbillnowise(String role, String fkUserId, String customerName,
			String billNo) {
		return cashbookreportservice.customertransactionreportbillnowise(role, fkUserId, customerName, billNo);
	}

	@GetMapping("/employeetransactionreportdatewise")
	private List<EmployeePayment> employeetransactionreportdatewise(String role, String fkUserId, String date) {
		return cashbookreportservice.employeetransactionreportdatewise(role, fkUserId, date);
	}

	@GetMapping("/employeetransactionreportrangewise")
	private List<EmployeePayment> employeetransactionreportrangewise(String role, String fkUserId, String employeeName,
			String Fromdate, String Todate) {
		return cashbookreportservice.employeetransactionreportrangewise(role, fkUserId, employeeName, Fromdate, Todate);
	}

	@GetMapping("/expendituretransactionreportdatewise")
	private List<ExpenditurePayment> expendituretransactionreportdatewise(String role, String fkUserId, String date) {
		return cashbookreportservice.expendituretransactionreportdateewise(role, fkUserId, date);
	}

	@GetMapping("/expendituretransactionreportrangeewise")
	private List<ExpenditurePayment> expendituretransactionreportrangewise(String role, String fkUserId,
			String expenditureName, String Fromdate, String Todate) {
		return cashbookreportservice.expendituretransactionreportrangeewise(role, fkUserId, expenditureName, Fromdate,
				Todate);
	}

	@GetMapping("/banktransactionreportnamewise")
	private List<BankPayment> banktransactionreportnamewise(String role, String fkUserId, String bankName) {
		return cashbookreportservice.banktransactionreportnamewise(role, fkUserId, bankName);
	}

	@GetMapping("/banktransactionreportrangewise")
	private List<BankPayment> banktransactionreportrangewise(String role, String fkUserId, String Fromdate,
			String Todate) {
		return cashbookreportservice.banktransactionreportrangewise(role, fkUserId, Fromdate, Todate);
	}

}
