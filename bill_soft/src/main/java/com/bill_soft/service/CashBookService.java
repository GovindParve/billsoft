package com.bill_soft.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill_soft.dto.BankPaymentDto;
import com.bill_soft.dto.CustomerPaymentDto;
import com.bill_soft.dto.EmployeePaymentDto;
import com.bill_soft.dto.ExpenditurePaymentDto;
import com.bill_soft.dto.SupplierPaymentDto;
import com.bill_soft.entity.BankPayment;
import com.bill_soft.entity.CustomerPayment;
import com.bill_soft.entity.EmployeePayment;
import com.bill_soft.entity.ExpenditurePayment;
import com.bill_soft.entity.SupplierPayment;
import com.bill_soft.repository.BankPaymentRepository;
import com.bill_soft.repository.CustomerPaymentRepository;
import com.bill_soft.repository.EmployeePaymentRepository;
import com.bill_soft.repository.ExpenditurePaymentRepository;
import com.bill_soft.repository.LoginRepository;
import com.bill_soft.repository.SupplierPaymentRepository;

@Service
public class CashBookService {

	@Autowired
	private SupplierPaymentRepository supplierpaymentrepository;
	
	@Autowired
	private LoginRepository loginrepository;
	
	@Autowired
	private EmployeePaymentRepository employeepaymentrepository;
	@Autowired
	private CustomerPaymentRepository customerpaymentrepository;
	@Autowired
	private ExpenditurePaymentRepository expenditurepaymentrepository;
	
	@Autowired
	private BankPaymentRepository bankpaymentrepository;
	public String savesupplierpaymentdetails(SupplierPaymentDto supplierpaymentdto, String role, String fkUserId) 
	{
	
		Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		
		 if(user.equals(null))
		 { 
			
			 return "UserName Not Found"; 
			
		 }
		 
		 		LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			SupplierPayment supplier=new SupplierPayment();
			supplier.setPkSupplierPaymentId(supplierpaymentdto.getPkSupplierPaymentId());
			supplier.setFkSupplierId(supplierpaymentdto.getFkSupplierId());
			supplier.setSupplierName(supplierpaymentdto.getShopName());
			supplier.setBillNo(supplierpaymentdto.getBillNo());
			supplier.setAccountantName(supplierpaymentdto.getAccountantName());
			supplier.setBalanceAmount(supplierpaymentdto.getBalanceAmount());
			supplier.setPaymentAmount(supplierpaymentdto.getPaymentAmount());
			supplier.setTotalAmount(supplierpaymentdto.getTotalAmount());
			supplier.setPaymentDate(dateString);
			supplier.setTranscationId(supplierpaymentdto.getTranscationId());
			supplier.setPaymentType(supplierpaymentdto.getPaymentType());
			supplier.setPaymentMode(supplierpaymentdto.getPaymentMode());
			supplier.setDescription(supplierpaymentdto.getDescription());
			supplier.setReceiptNo(supplierpaymentdto.getReceiptNo());
			supplier.setFkShopId(supplierpaymentdto.getFkShopId());
			supplier.setFkAdminId(supplierpaymentdto.getFkAdminId());
			supplier.setFkoragnizationId(supplierpaymentdto.getFkoragnizationId());
			supplier.setShopName(supplierpaymentdto.getShopName());
			supplier.setAdminName(supplierpaymentdto.getAdminName());
			supplier.setOragnizationName(supplierpaymentdto.getOragnizationName());
			supplier.setCreatedBy(user + "(" + role + ")");
			supplier.setCreatedDate(dateString);
			supplierpaymentrepository.save(supplier);
			return "supplier payment successfully";
	}
	
	
	public String saveexpenditurepaymentdetails(ExpenditurePaymentDto expenditurepaymentdto, String role,String fkUserId) 
	{
		Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		
		 if(user.equals(null))
		 { 
			
			 return "UserName Not Found"; 
			
		 }
		 
		 		LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			ExpenditurePayment expenditure=new ExpenditurePayment();
		  expenditure.setPkExpenditurepaymentId(expenditurepaymentdto.getPkExpenditurepaymentId());
		  expenditure.setAccountantName(expenditurepaymentdto.getAccountantName());
		  expenditure.setFkExpenseId(expenditurepaymentdto.getFkExpenseId());
		  expenditure.setExpenditureName(expenditurepaymentdto.getExpenditureName());
		  
		  expenditure.setExpenseType(expenditurepaymentdto.getExpenseType());
		  expenditure.setPaymentType(expenditurepaymentdto.getPaymentType());
		  expenditure.setPaymentMode(expenditurepaymentdto.getPaymentMode());
		  expenditure.setCash(expenditurepaymentdto.getCash());
		  expenditure.setCard(expenditurepaymentdto.getCard());
		  expenditure.setUpi(expenditurepaymentdto.getUpi());
		  expenditure.setPaymentDate(expenditurepaymentdto.getPaymentDate());
		  expenditure.setServiceProvider(expenditurepaymentdto.getServiceProvider());
		  expenditure.setTotalAmount(expenditurepaymentdto.getTotalAmount());
		  expenditure.setContactNumber(expenditurepaymentdto.getContactNumber());
		  expenditure.setDescription(expenditurepaymentdto.getDescription());
		  expenditure.setAccountantName(expenditurepaymentdto.getAccountantName());
		  expenditure.setTransactionId(expenditurepaymentdto.getTransactionId());
		  expenditure.setFkShopId(expenditurepaymentdto.getFkShopId());
		  expenditure.setShopName(expenditurepaymentdto.getShopName());
		  expenditure.setFkAdminId(expenditurepaymentdto.getFkAdminId());
		  expenditure.setAdminName(expenditurepaymentdto.getAdminName());
		  expenditure.setFkoragnizationId(expenditurepaymentdto.getFkoragnizationId());
		  expenditure.setOragnizationName(expenditurepaymentdto.getOragnizationName());
		  expenditure.setCreatedBy(user + "(" + role + ")");
		  expenditure.setCreatedDate(dateString);
		  expenditurepaymentrepository.save(expenditure);
			return "expenditure payment successfully";
			
		
	}


	public String savecustomerpaymentdetails(CustomerPaymentDto customerpaymentdto, String role, String fkUserId)
	{
		Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		
		 if(user.equals(null))
		 { 
			
			 return "UserName Not Found"; 
			
		 }
		 
		 		LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
		CustomerPayment customer=new CustomerPayment();
		customer.setPkCustomerPaymentId(customerpaymentdto.getPkCustomerPaymentId());
		customer.setCustomerName(customerpaymentdto.getCustomerName());
		customer.setFkCustomerId(customerpaymentdto.getFkCustomerId());
		customer.setBillNo(customerpaymentdto.getBillNo());
		customer.setBalanceAmount(customerpaymentdto.getBalanceAmount());
		customer.setTotalAmount(customerpaymentdto.getTotalAmount());
		customer.setPaymentAmount(customerpaymentdto.getPaymentAmount());
		customer.setPaymentMode(customerpaymentdto.getPaymentMode());
		customer.setCash(customerpaymentdto.getCash());
		customer.setCard(customerpaymentdto.getCard());
		customer.setUpi(customerpaymentdto.getUpi());;
		customer.setPaymentType(customerpaymentdto.getPaymentType());
		customer.setPaymentDate(customerpaymentdto.getPaymentDate());
		customer.setAccountantName(customerpaymentdto.getAccountantName());
		customer.setReceiptNo(customerpaymentdto.getReceiptNo());
		customer.setContactNumber(customerpaymentdto.getContactNumber());
		customer.setDescription(customerpaymentdto.getDescription());
		customer.setTransactionId(customerpaymentdto.getTransactionId());
		customer.setFkShopId(customerpaymentdto.getFkShopId());
		customer.setShopName(customerpaymentdto.getShopName());
		customer.setFkAdminId(customerpaymentdto.getFkAdminId());
	    customer.setAdminName(customerpaymentdto.getAdminName());
		customer.setFkoragnizationId(customerpaymentdto.getFkoragnizationId());
		customer.setOragnizationName(customerpaymentdto.getOragnizationName());
		customer.setCreatedBy(user + "(" + role + ")");
		customer.setCreatedDate(dateString);
		customerpaymentrepository.save(customer);
		return "customer payment successfully";
	}


	public String saveemployeepaymentdetails(EmployeePaymentDto employeepaymentdto, String role, String fkUserId) 
	{
		
		Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		
		 if(user.equals(null))
		 { 
			
			 return "UserName Not Found"; 
			
		 }
		 LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
			EmployeePayment employee=new EmployeePayment();
			employee.setPkEmployeePaymentId(employeepaymentdto.getPkEmployeePaymentId());
			employee.setFkEmployeeId(employeepaymentdto.getFkEmployeeId());
			employee.setEmployeeName(employeepaymentdto.getEmployeeName());
			employee.setReason(employeepaymentdto.getReason());
			employee.setPaidAmount(employeepaymentdto.getPaidAmount());
			employee.setPaymentMode(employeepaymentdto.getPaymentMode());
			employee.setPaymentType(employeepaymentdto.getPaymentType());
			employee.setPaymentDate(dateString);
			employee.setAccountantName(employeepaymentdto.getAccountantName());
			employee.setContactNumber(employeepaymentdto.getContactNumber());
			employee.setDescription(employeepaymentdto.getDescription());
			employee.setTransactionId(employeepaymentdto.getTransactionId());
			employee.setFkShopId(employeepaymentdto.getFkShopId());
			employee.setShopName(employeepaymentdto.getShopName());
			employee.setFkAdminId(employeepaymentdto.getFkAdminId());
			employee.setAdminName(employeepaymentdto.getAdminName());
			employee.setFkOrganizationId(employeepaymentdto.getFkOrganizationId());
			employee.setOrganizationName(employeepaymentdto.getOrganizationName());
			employee.setCreatedBy(user + "(" + role + ")");
			employee.setCreatedDate(dateString);
			employeepaymentrepository.save(employee);
			return "employee payment successfully";
		
	}


	public String savebankpaymentdetails(BankPaymentDto bankpaymentdto, String role, String fkUserId)
	{
		Long pkid=Long.parseLong(fkUserId);
		String user=loginrepository.getusernameforcategory(role,pkid);
		
		 if(user.equals(null))
		 { 
			
			 return "UserName Not Found"; 
			
		 }
		 LocalDate date=LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateString = date.format(formatter);
		     BankPayment bank=new BankPayment();
		     bank.setPkBankPaymentId(bankpaymentdto.getPkBankPaymentId());
		     bank.setFkBankId(bankpaymentdto.getFkBankId());
				bank.setBankName(bankpaymentdto.getBankName());
				bank.setPaidAmount(bankpaymentdto.getPaidAmount());
				bank.setPaymentMode(bankpaymentdto.getPaymentMode());
				bank.setPaymentType(bankpaymentdto.getPaymentType());
				bank.setPaymentDate(dateString);
				bank.setAccountantName(bankpaymentdto.getAccountantName());
				bank.setContactNumber(bankpaymentdto.getContactNumber());
				bank.setDescription(bankpaymentdto.getDescription());
				bank.setTransactionId(bankpaymentdto.getTransactionId());
				bank.setFkShopId(bankpaymentdto.getFkShopId());
				bank.setShopName(bankpaymentdto.getShopName());
				bank.setFkAdminId(bankpaymentdto.getFkAdminId());
				bank.setAdminName(bankpaymentdto.getAdminName());
				bank.setFkOrganizationId(bankpaymentdto.getFkOrganizationId());
				bank.setOrganizationName(bankpaymentdto.getOrganizationName());
				bank.setCreatedBy(user + "(" + role + ")");
				bank.setCreatedDate(dateString);
				bankpaymentrepository.save(bank);
				return "bank payment successfully";
		
	}

}
