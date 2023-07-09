package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class GoodReceiveDto {

	private Long pkGoodReceiveId;
	private Long fkPurchaseOrderId;
	private Long purchaseOrderNumber;
	private Long fkPurchaseQuotationId;
	private Long quotationNumber;
	private String supplierName;
	private Long fkSupplierId;
	private String billNo;
	private Long fkCategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String subCategoryName;
	private Long fkProductId;
	private String productName;
	private String goodReceiveDate;
	private String contactNo;
	private Double quantity;
	private Double rollSize;
	private String size;

	private String color;
	private String style;
	private Double weight;
	private String unit;
	private String company;
	private String hsnsac;
	private Double buyPriceIncludingTax;
	private Double buyPriceExcludingTax;
	private Double discount;
	private Double discountAmount;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private String batchNo;
	private String manufactureDate;
    private String expiryDate;
    private Double totalExcludingTax;
	private Double totalAmount;
	private Double taxPercentage;
	private Double taxAmount;
	private String payDuedate;
	private Double labourExpense;
	private Double transportExpense;
	private Double gstForExpense;
	private Double totalQuantity;
	private Double totalTaxAmount;
	private Double grossTotal;
	private Double salePrice;
	private Double mrp;
	

	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	private Double supplierUnPaidAmt;
	
	private Long goodReceiveNumber;

	
	
}
