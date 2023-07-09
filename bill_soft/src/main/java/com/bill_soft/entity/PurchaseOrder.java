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


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkPurchaseOrderId;

	@Column(name = "fk_purchase_quotation_id")
	private Long fkPurchaseQuotationId;

	@Column(name = "quotation_number")
	private Long quotationNumber;

	@Column(name = "purchase_order_number")
	private Long purchaseOrderNumber;

	@Column(name = "fk_supplier_id")
	private Long fkSupplierId;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "gst_no")
	private String gstNo;
	
	@Column(name = "fk_category_id")
	private Long fkCategoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "fk_subcategory_id")
	private Long fkSubCategoryId;

	@Column(name = "subcategory_name")
	private String subCategoryName;

	@Column(name = "fk_product_id")
	private Long fkProductId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "purchase_order_date")
	private String purchaseOrderDate;

	@Column(name = "barcode_number")
	private String barcodeNo;
	
	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "roll_size")
	private Double rollSize;

	@Column(name="size")
	private String size; 
	
	@Column(name="style")
	private String style;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "company")
	private String company;

	@Column(name = "hsn_or_sacc")
	private String hsnsacc;

	@Column(name = "buy_price_including_tax")
	private Double buyPriceIncludingTax;

	@Column(name = "buy_price_excluding_tax")
	private Double buyPriceExcludingTax;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "discount_amount")
	private Double discountAmount;
	
	@Column(name = "sale_price")
	private Double salePrice;
	
	@Column(name = "mrp")
	private Double mrp;
	
	@Column(name = "sgst")
	private Double sgst;

	@Column(name = "cgst")
	private Double cgst;

	@Column(name = "igst")
	private Double igst;
	
	@Column(name = "tax_amount")
	private Double taxAmount;

	@Column(name = "total_excluding_tax")
	private Double totalExcludingTax;

	@Column(name = "total_amount")
	private Double totalAmount;
	
	@Column(name = "pay_due_date")
	private String payDuedate;

	@Column(name = "transport_expense")
	private Double transportExpense;

	@Column(name = "labour_expense")
	private Double labourExpense;
	
	@Column(name="total_quantity")
	private Double totalQuantity;
	
	@Column(name="total_tax_amount")
	private Double totalTaxAmount;

	@Column(name = "tax_percentage")
	private Double taxpercentage;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "gross_total")
	private Double grossTotal;
	
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
