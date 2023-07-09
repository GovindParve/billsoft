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
@Table(name = "sale_quotation")
public class SaleQuotation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkSaleQuatationId;

	@Column(name = "sale_quotation_no")
	private String saleQuotationNo;

	@Column(name = "fk_cat_id")
	private Long fkCatId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "fk_subcat_id")
	private Long fksubcatId;

	@Column(name = "subcategory_name")
	private String subCategoryName;

	@Column(name = "fk_shop_id")
	private Long fkShopId;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "fk_product_id")
	private Long fkProductId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "fk_customer_id")
	private Long fkCustomerId;

	@Column(name = "customer_name")
	private String customerName; 
	
	@Column(name = "fk_admin_id")
	private Long fkAdminId;

	@Column(name="admin_name")
	private String adminName;
	
	@Column(name = "fk_oragnization_id")
	private Long fkoragnizationId;

	@Column(name="oragnization_name")
	private String oragnizationName;

	@Column(name = "address")
	private String address;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="contactNo")
	private Long contactNo;
	
	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "barcode_no")
	private String barcodeNo;

	@Column(name = "sale_price_including_tax")
	private Double salePriceIncludingTax;

	@Column(name = "sale_price_excluding_tax")
	private Double salePriceExcludingTax;

	@Column(name = "company")
	private String company;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "quotation_date")
	private String quotationDate;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "sgst")
	private Double sgst;

	@Column(name = "cgst")
	private Double cgst;

	@Column(name = "igst")
	private Double igst;
	
	@Column(name = "tax_percentage")
	private Double taxPercentage;

	@Column(name = "tax_amount")
	private Double taxAmount;

	@Column(name = "hsn_or_sacc")
	private String hsnorsac;

	@Column(name="weight")
	private Double weight;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name = "total_excluding_tax")
	private Double totalExcludingTax;

	@Column(name = "total_amount")
	private Double totalAmount;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "discount_amount")
	private Double discountAmount;

	@Column(name = "labour_expense")
	private Double labourExpense;

	@Column(name = "transport_expense")
	private Double transportExpense;

	@Column(name = "gst_expense")
	private String gstExpense;
	
	@Column(name="labour_tax_amount")
	private Double labourTaxAmount;

	@Column(name = "gross_total")
	private Double grossTotal;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name="status")
	private String status;
	
	

	
}
