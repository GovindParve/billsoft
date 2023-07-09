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
@Table(name = "supplier_payment")
public class SupplierPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_supplier_payment_id")
	private Long pkSupplierPaymentId;

	@Column(name = "fk_supplier_id")
	private Long fkSupplierId;

	@Column(name = "supplier_name")
	private String SupplierName;

	@Column(name = "bill_no")
	private Long billNo;

	@Column(name = "payment_date")
	private String paymentDate;

	@Column(name = "accountant_name")
	private String accountantName;

	@Column(name = "total_amount")
	private Double totalAmount;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "balance_amount")
	private Double balanceAmount;

	@Column(name = "payment_amount")
	private Double paymentAmount;

	@Column(name = "description")
	private String description;

	@Column(name = "transcation_id")
	private Long transcationId;

	@Column(name = "receipt_no")
	private Long receiptNo;

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
