package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseReturnGridBean {

	private Long purchaseReturnId;
	private Long fkSupplierId;
	private String supplierName;
	private Long fkCatId;
	private String categoryName;
	private Long fkSubCatId;
	private String subCategoryName;
	private Long fkProductId;
	private String productName;
	private String billNo;
	private Long purchaseReturnNo;
	private String barcodeNo;
	private String company;
	private Double quantity;
	private Double returnQuantity;
	private Double weight;
	private String unit;
	private Double mrp;
	private Double gst;
	private Double igst;
	private Double taxPercentage;
	private Double taxAmount;
	private Double totalAmount;
	private Double returnTotal;
	private Double returnAmount;
	private String manufactureDate;
	private String expiryDate;
	private String batchNo;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	private Long fkGoodReceiveId;
	private String goodReceiveDate;
	private String contactNo;
	private Double rollSize;
	private String color;
	private String size;
	private String style;
	private String hsnsac;
	private Double buyPriceIncludingTax;
	private Double buyPriceExcludingTax;
	private Double discount;
	private Double discountAmount;
	private Double totalExcludingTax;
	private Double labourExpense;
	private Double transportExpense;
	private Double gstForExpense;
	private Double totalQuantity;
	private Double totalTaxAmount;
	private Double grossTotal;

}
