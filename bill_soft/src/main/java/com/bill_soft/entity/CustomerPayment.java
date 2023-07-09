package com.bill_soft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "customer_payment")
public class CustomerPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkCustomerPaymentId;

	@Column(name = "fk_customer_id")
	private Long fkCustomerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "payment_date")
	private String paymentDate;

	@Column(name = "accountant_name")
	private String accountantName;

	@Column(name = "total_amount")
	private Double totalAmount;

	@Column(name = "balance_amount")
	private Double balanceAmount;

	@Column(name = "payment_amount")
	private Double paymentAmount;

	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name="cash")
	private Double cash;
	
	@Column(name="card")
	private Double card;
	
	@Column(name="upi")
	private Double upi;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "description")
	private String description;

	@Column(name = "receipt_no")
	private Long receiptNo;

	@Column(name = "transaction_id")
	private Long transactionId;

	@Column(name = "fk_shop_id")
	private Long fkShopId;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "fk_admin_id")
	private Long fkAdminId;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "fk_oragnization_id")
	private Long fkoragnizationId;

	@Column(name = "oragnization_name")
	private String oragnizationName;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;

}
