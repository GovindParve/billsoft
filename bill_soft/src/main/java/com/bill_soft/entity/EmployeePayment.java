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
@Table(name="employee_payment")
public class EmployeePayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkEmployeePaymentId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="fk_employee_id")
	private Long fkEmployeeId;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="accountant_name")
	private String accountantName;
	
	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="paid_amount")
	private Double paidAmount;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="transaction_id")
	private Long transactionId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="fk_shop_id")
	private Long fkShopId;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="fk_admin_id")
	private Long fkAdminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="fk_organization_id")
	private Long fkOrganizationId;
	
	@Column(name="organization_name")
	private String organizationName;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private String createdDate;

}
