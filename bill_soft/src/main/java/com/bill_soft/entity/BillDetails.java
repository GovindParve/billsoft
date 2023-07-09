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
@Table(name = "bill_details")
public class BillDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkBillId;

	@Column(name="sale_quotation_no")
	private Long  saleQuotationNo;
	
	@Column(name = "comapny_name")
	private String companyName;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name="address")
	private String address;
	
	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "bill_no")
	private Long billNo;

	@Column(name = "bill_date")
	private String billDate;

	@Column(name = "barcode_no")
	private String barcodeNo;

	@Column(name = "customer_type")
	private String customerType;

	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name="cash_amount")
	private Double cashAmount;
	
	@Column(name="card_amount")
	private Double cardAmount;
	
	@Column(name="upi_amount")
	private Double upiAmount;

	@Column(name = "sale_price_including_tax")
	private Double salePriceIncludingtax;

	@Column(name = "sale_price_excluding_tax")
	private Double salePriceExcludingTax;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "unit")
	private String unit;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "discount_amount")
	private Double discountAmount;

	@Column(name = "cgst")
	private Double cgst;

	@Column(name = "sgst")
	private Double sgst;

	@Column(name = "igst")
	private Double igst;

	@Column(name = "tax_percentage")
	private Double taxPercentage;

	@Column(name = "tax_amount")
	private Double taxAmount;

	@Column(name = "total_excluding_tax")
	private Double totalExcludingTax;

	@Column(name = "total_amount")
	private Double totalAmount;

	@Column(name = "gross_total")
	private Double grossTotal;

	@Column(name = "labour_expense")
	private Double labourExpense;

	@Column(name = "transport_expense")
	private Double transportExpense;

	@Column(name = "gst_expense")
	private Double gstExpense;

	@Column(name = "batch_no")
	private String batchno;

	@Column(name = "manufaturing_date")
	private String manufacturingDate;

	@Column(name = "expiry_date")
	private String expiryDate;

	@Column(name = "credit_amount")
	private Double creditAmount;

	@Column(name = "fk_cat_id")
	private Long fkCatId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "fk_subcat_id")
	private Long fkSubCatId;

	@Column(name = "subcategory_name")
	private String subCategoryName;

	@Column(name = "fk_product_id")
	private Long fkProductId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "fk_shop_id")
	private Long fkShopId;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "fk_admin_id")
	private Long fkAdminId;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "fk_oragnization_id")
	private Long fkOragnizationId;

	@Column(name = "oragnization_name")
	private String oragnizationName;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	
}
