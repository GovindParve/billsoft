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
@Table(name = "sale_return")
public class SaleReturn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkSaleReturnId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "fk_category_id")
	private Long fkcategoryId;

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

	@Column(name = "available_quantity")
	private Double availableQuantity;

	@Column(name = "return_quantity")
	private Double returnQuantity;

	@Column(name = "barcode_no")
	private String barcodeNo;

	@Column(name = "company")
	private String company;

	@Column(name = "sale_price_including_tax")
	private Double salePriceIncludingTax;

	@Column(name = "sale_price_excluding_tax")
	private Double salePriceExcludingTax;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "unit")
	private String unit;

	@Column(name = "color")
	private String color;

	@Column(name = "size")
	private String size;

	@Column(name = "packing_type")
	private String packingType;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "discount_amount")
	private Double discountAmount;

	@Column(name = "mrp")
	private Double mrp;

	@Column(name = "hsn_or_sac_code")
	private String hsnsac;

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

	@Column(name = "batch_no")
	private String batchNo;

	@Column(name = "manufacture_date")
	private String manufacture_date;

	@Column(name = "expiry_date")
	private String expiryDate;

	@Column(name = "return_total")
	private Double returnTotal;

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
	private Long fkOragnizationId;

	@Column(name = "oragnization_name")
	private String oragnizationName;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "return_date")
	private String returnDate;

	
}
