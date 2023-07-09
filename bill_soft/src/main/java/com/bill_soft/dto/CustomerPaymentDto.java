package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerPaymentDto {
	
	private Long pkCustomerPaymentId;
	private Long fkCustomerId;
	private String customerName;
	private String contactNumber;
	private String billNo;
	private String paymentDate;
	private String accountantName;
	private Double totalAmount;
	private Double balanceAmount;
	private Double paymentAmount;
	private String paymentMode;
	private Double cash;
	private Double card;
	private Double upi;
	private String paymentType;
	private String description;
	private Long receiptNo;
	private Long transactionId;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	
	
}
