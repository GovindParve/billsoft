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
@Table(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_product_id")
	private Long pkProductId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "fk_category_id")
	private Long fkCategoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "fk_subcategory_id")
	private Long fkSubCategoryId;

	@Column(name = "subcategory_name")
	private String subcategoryName;

	@Column(name = "fk_shop_id")
	private Long fkShopId;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "fk_admin_id")
	private Long fkAdminId;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name="fk_tax_id")
	private Long fkTaxId;
	
	@Column(name = "tax")
	private Double tax;
	
	@Column(name="fk_unit_id")
	private Long fkUnitId;

	@Column(name = "unit")
	private String unit;
	
	@Column(name = "fk_oragnization_id")
	private Long fkoragnizationId;

	@Column(name = "oragnization_name")
	private String oragnizationName;

	@Column(name = "manufacture_company")
	private String manufactureCompany;
	
	@Column(name = "weight")
	private Double weight;

	@Column(name = "roll_size")
	private Double rollSize;

	@Column(name="size")
	private String size; 
	
	@Column(name="style")
	private String style;
	
	@Column(name = "model_name")
	private String modelName;

	@Column(name = "color")
	private String color;
	
	@Column(name="is_barcode_product")
	private String isBarcodeProduct;

	@Column(name="buy_price_including_tax")
	private Double buyPriceIncludingTax;
	
	@Column(name="purchase_discount")
	private Double purchaseDiscount;
	
	@Column(name="sale_discount")
	private Double saleDiscount;

	@Column(name="sale_price_including_tax")
	private Double salePriceIncludingTax;
	
	@Column(name = "mrp")
	private Double mrp;

	@Column(name = "hsn_code")
	private String hsnCode;

	@Column(name = "cgst")
	private Double cgst;

	@Column(name = "sgst")
	private Double sgst;

	@Column(name = "igst")
	private Double igst;
	
	@Column(name = "discription")
	private String discription;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "unit_quantity")
	private Double unitQuantity;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;

	
}
