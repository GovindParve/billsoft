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
@Table(name = "purchase_return")
public class PurchaseReturn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseReturnId;

	@Column(name = "fk_supplier_id")
	private Long fkSupplierId;

	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "fk_cat_id")
	private Long fkCatId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "fk_subcat_id")
	private Long fkSubCatId;

	@Column(name = "sub_category_name")
	private String subCategoryName;

	@Column(name = "fk_product_id")
	private Long fkProductId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "purchase_return_no")
	private Long purchaseReturnNo;

	@Column(name = "barcode_number")
	private String barcodeNo;

	@Column(name = "company")
	private String company;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "return_quantity")
	private Double returnQuantity;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "unit")
	private String unit;

	@Column(name = "mrp")
	private Double mrp;

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

	@Column(name = "total_amount")
	private Double totalAmount;

	@Column(name = "return_total")
	private Double returnTotal;

	@Column(name = "return_amount")
	private Double returnAmount;

	@Column(name = "manufacture_date")
	private String manufactureDate;

	@Column(name = "expiry_date")
	private String expiryDate;

	@Column(name = "batch_no")
	private String batchNo;

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

	@Column(name = "fk_goodreceive_id")
	private Long fkGoodReceiveId;

	@Column(name = "good_receive_date")
	private String goodReceiveDate;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "roll_size")
	private Double rollSize;

	@Column(name = "color")
	private String color;

	@Column(name = "size")
	private String size;

	@Column(name = "style")
	private String style;

	@Column(name = "hsn_or_sac")
	private String hsnsac;

	@Column(name = "buy_price_including_tax")
	private Double buyPriceIncludingTax;

	@Column(name = "buy_price_excluding_tax")
	private Double buyPriceExcludingTax;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "discount_amount")
	private Double discountAmount;

	@Column(name = "total_excluding_tax")
	private Double totalExcludingTax;

	@Column(name = "labour_expense")
	private Double labourExpense;

	@Column(name = "transport_expense")
	private Double transportExpense;

	@Column(name = "gst_for_expense")
	private Double gstForExpense;

	@Column(name = "total_quantity")
	private Double totalQuantity;

	@Column(name = "total_tax_amount")
	private Double totalTaxAmount;

	@Column(name = "gross_total")
	private Double grossTotal;

}
