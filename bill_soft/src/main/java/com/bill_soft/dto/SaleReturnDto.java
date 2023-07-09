package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SaleReturnDto {
	
	private Long pkSaleReturnId;
	private String customerName;
	private String contactNo;
	private String billNo;
	private Long fkcategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String subCategoryName;
	private Long fkProductId;
	private String productName;
	private Double availableQuantity;
	private Double returnQuantity;
	private String barcodeNo;
	private String company;
	private Double salePriceIncludingTax;
	private Double salePriceExcludingTax;
	private Double weight;
	private String unit;
	private String color;
	private String size;
	private String packingType;
	private Double discount;
	private Double discountAmount;
	private Double mrp;
	private String hsnsac;
	private Double cgst;
	private Double sgst;
	private Double igst;
	private Double taxPercentage;
	private Double taxAmount;
	private Double totalExcludingTax;
	private Double totalAmount;
	private String batchNo;
	private String manufactureDate;
	private String expiryDate;
	private Double returnTotal;
	private Double grossTotal;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkOragnizationId;
	private String oragnizationName;
	private String createdBy;
	private String createdDate;
	private String returnDate;

	
}
