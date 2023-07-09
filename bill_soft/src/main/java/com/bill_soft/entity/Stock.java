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
@Table(name="stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pkStockId;
	
	@Column(name="fk_category_id")
	private Long fkcategoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="fk_subcategory_id")
	private Long fkSubCategoryId;
	
	@Column(name="subcategory_name")
	private String SubCategoryName;
	
	@Column(name="fk_product_id")
	private Long fkProductId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="quantity")
	private Double quantity;	

	@Column(name="update_date")
	private String updateDate;	

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="available_quantity")
	private Double availableQuantity;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="batch_number")
	private String batchNumber;
	
	@Column(name="packing_type")
	private String packingType;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="manufacture_date")
	private String ManufactureDate;
	
	@Column(name="expiry_date")
	private String expiryDate;
	
	@Column(name = "fk_shop_id")
	private Long fkShopId;
	
	@Column(name ="fk_godown_id")
	private Long fkGodownId;

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
