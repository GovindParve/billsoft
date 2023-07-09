package com.bill_soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.entity.BankPayment;
import com.bill_soft.entity.CustomerPayment;
import com.bill_soft.entity.EmployeePayment;
import com.bill_soft.entity.ExpenditurePayment;
import com.bill_soft.entity.SupplierPayment;
import com.bill_soft.repository.BankPaymentRepository;
import com.bill_soft.repository.CustomerPaymentRepository;
import com.bill_soft.repository.EmployeePaymentRepository;
import com.bill_soft.repository.ExpenditurePaymentRepository;
import com.bill_soft.repository.SupplierPaymentRepository;

@Service
public class CashBookReportService {

	@Autowired
	private SupplierPaymentRepository supplierpaymentrepository;
	
	@Autowired
	private CustomerPaymentRepository customerpaymentrepository;
	
	@Autowired
	private EmployeePaymentRepository employeepaymentrepository;
	
	@Autowired
	private ExpenditurePaymentRepository expenditurepaymentrepository;
	
	@Autowired
	private BankPaymentRepository bankpaymentrepository;
	public List<SupplierPayment> getsupplierpaymentreport(String role, String fkUserId,String supplierName) {
		if(role.equals("super-admin"))
		{
			return supplierpaymentrepository.getsupplierpaymentreportforsuperadmin(supplierName);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportfororganization(supplierName,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportforadmin(supplierName,fkAdminId);
		}
		
		return null;
		
		
	}
	public List<SupplierPayment> getsupplierpaymentreportdatewise(String role, String fkUserId, String date) {
		if(role.equals("super-admin"))
		{
			return supplierpaymentrepository.getsupplierpaymentreportdatewiseforsuperadmin(date);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportdatewisefororganization(date,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportdatewiseforadmin(date,fkAdminId);
		}
		return null;
	}
	
	
	public List<SupplierPayment> getsupplierpaymentreportrangeewise(String role, String fkUserId, String Fromdate,
			String Todate) {
		if(role.equals("super-admin"))
		{
			return supplierpaymentrepository.getsupplierpaymentreportdrangewiseforsuperadmin(Fromdate,Todate);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportrangeewisefororganization(Fromdate,Todate,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportrangewiseforadmin(Fromdate,Todate,fkAdminId);
		}
		return null;
	}
	public List<SupplierPayment> getsupplierpaymentreportbillnoewise(String role, String fkUserId, String supplierName,
			String billNo) {
		if(role.equals("super-admin"))
		{
			return supplierpaymentrepository.getsupplierpaymentreportbillnowiseforsuperadmin(supplierName,billNo);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportbillnowisefororganization(supplierName,billNo,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return supplierpaymentrepository.getsupplierpaymentreportbillnowiseforadmin(supplierName,billNo,fkAdminId);
		}
		return null;
	}
	public List<CustomerPayment> getcustomerpaymentreportcustomernameewise(String role, String fkUserId,
			String customerName) {
		if(role.equals("super-admin"))
		{
			return customerpaymentrepository.getcustomerpaymentreportcustomernamewiseforsuperadmin(customerName);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return customerpaymentrepository.getcustomerpaymentreportcustomernamewisefororganization(customerName,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return customerpaymentrepository.getcustomerpaymentreportcustomernamewiseforadmin(customerName,fkAdminId);
		}
	return null;
	}
	public List<CustomerPayment> getcustomerpaymentreportdatewise(String role, String fkUserId, String date) {
		if(role.equals("super-admin"))
		{
			return customerpaymentrepository.getcustomerpaymentreportdateewiseforsuperadmin(date);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return customerpaymentrepository.getcustomerpaymentreportdatewisefororganization(date,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return customerpaymentrepository.getcustomerpaymentreportdatewiseforadmin(date,fkAdminId);
		}
		return null;
	}
	public List<CustomerPayment> customertransactionreportrangewise(String role, String fkUserId, String Fromdate,
			String Todate) {
		if(role.equals("super-admin"))
		{
			return customerpaymentrepository.getcustomerpaymentreportrangewiseforsuperadmin(Fromdate,Todate);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return customerpaymentrepository.getcustomerpaymentreportrangewisefororganization(Fromdate,Todate,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return customerpaymentrepository.getcustomerpaymentreportrangewiseforadmin(Fromdate,Todate,fkAdminId);
		}
		return null;
	}
	public List<CustomerPayment> customertransactionreportbillnowise(String role, String fkUserId, String customerName,
			String billNo) {
		if(role.equals("super-admin"))
		{
			return customerpaymentrepository.getcustomerpaymentreportbillnowiseforsuperadmin(customerName,billNo);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return customerpaymentrepository.getcustomerpaymentreportbillnowisefororganization(customerName,billNo,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return customerpaymentrepository.getcustomerpaymentreportbillnowiseforadmin(customerName,billNo,fkAdminId);
		}
		return null;
	}
	public List<EmployeePayment> employeetransactionreportdatewise(String role, String fkUserId, String date) {
		if(role.equals("super-admin"))
		{
			return employeepaymentrepository.getemployeepaymentreportdatewiseforsuperadmin(date);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return employeepaymentrepository.getcustomerpaymentreportbillnowisefororganization(date,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return employeepaymentrepository.getcustomerpaymentreportbillnowiseforadmin(date,fkAdminId);
		}
		return null;
	}
	public List<EmployeePayment> employeetransactionreportrangewise(String role, String fkUserId, String employeeName,String Fromdate,
			String Todate) {
		if(role.equals("super-admin"))
		{
			return employeepaymentrepository.getemployeepaymentreportrangewiseforsuperadmin(employeeName,Fromdate,Todate);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return employeepaymentrepository.getemployeepaymentreportrangewisefororganization(employeeName,Fromdate,Todate,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return employeepaymentrepository.getemployeepaymentreportrangewiseforadmin(employeeName,Fromdate,Todate,fkAdminId);
		}
		return null;
	}
	public List<ExpenditurePayment> expendituretransactionreportdateewise(String role, String fkUserId, String date) {
		if(role.equals("super-admin"))
		{
			return expenditurepaymentrepository.getexpenditurepaymentreportdatewiseforsuperadmin(date);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return expenditurepaymentrepository.getexpenditurepaymentreportdatewisefororganization(date,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return expenditurepaymentrepository.getexpenditurepaymentreportdatewiseforadmin(date,fkAdminId);
		}
		return null;
	}
	public List<ExpenditurePayment> expendituretransactionreportrangeewise(String role, String fkUserId,String expenditureName,
			String Fromdate, String Todate) {
		if(role.equals("super-admin"))
		{
			return expenditurepaymentrepository.getexpenditurepaymentreportrangewiseforsuperadmin(expenditureName,Fromdate,Todate);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return expenditurepaymentrepository.getexpenditurepaymentreportrangewisefororganization(expenditureName,Fromdate,Todate,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return expenditurepaymentrepository.getexpenditurepaymentreportrangewiseforadmin(expenditureName,Fromdate,Todate,fkAdminId);
		}
		return null;
	}
	public List<BankPayment> banktransactionreportnamewise(String role, String fkUserId, String bankName) {
		if(role.equals("super-admin"))
		{
			return bankpaymentrepository.getbankpaymentreportnamewiseforsuperadmin(bankName);
		}
		if(role.equals("organization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return bankpaymentrepository.getbankpaymentreportnamewisefororganization(bankName,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return bankpaymentrepository.getbankpaymentreportnamewiseforadmin(bankName,fkAdminId);
		}
		return null;
	}
	public List<BankPayment> banktransactionreportrangewise(String role, String fkUserId, String Fromdate,
			String Todate) {
		if(role.equals("super-admin"))
		{
			return bankpaymentrepository.getbankpaymentreportrangewiseforsuperadmin(Fromdate,Todate);
		}
		if(role.equals("oragnization"))
		{
			 Long fkOragnizationId=Long.parseLong(fkUserId);
			 return bankpaymentrepository.getbankpaymentreportrangewisefororganization(Fromdate,Todate,fkOragnizationId);
		}
		if(role.equals("admin"))
		{
			Long fkAdminId=Long.parseLong(fkUserId);
			return bankpaymentrepository.getbankpaymentreportrangewiseforadmin(Fromdate,Todate,fkAdminId);
		
		}
		return null;
	}

	
		
		
	}
	
	
	


