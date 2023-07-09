package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BarcodeNoWiseStockBean {
	
	private Long pkBarcodeStockId;
	private Long fkcategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String SubCategoryName;
	private Long fkProductId;
	private String productName;
	private Double availableQuantity;	
	private Double barcodeNoWiseStock;
	private String updateDate;	
	private String companyName;
	private String barcodeNo;
	private Double weight;
	private String color;
	private String size;
	private String batchNumber;
	private String packingType;
	private String unit;
	private String ManufactureDate;
	private String expiryDate;
	private Long fkShopId;

	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	
	
	
	

}
