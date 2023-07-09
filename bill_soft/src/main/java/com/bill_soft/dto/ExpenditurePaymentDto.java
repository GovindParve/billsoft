package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ExpenditurePaymentDto {
	private Long pkExpenditurepaymentId;
	private Long fkExpenseId;
	private String expenditureName;
	private String expenseType;
	private String paymentType;
	private String paymentMode;
	private Double cash;
	private Double card;
	private Double upi;
	private String paymentDate;
	private String serviceProvider;
	private Double totalAmount;
	private String accountantName;
	private Long transactionId;
	private String contactNumber;

	private String description;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;

	
}
