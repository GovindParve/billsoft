package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseQuotationBean {

	private Long pkPurchaseQuotationId;
	private Long fkSupplierId;
	private String supplierName;
	private String emailId;
	private String city;
	private String address;
	private String contactNo;
	private String gstNo;
	private String quotationDate;
	private Long fkCategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String subcategoryName;
	private Long fkProductId;
	private String productName;
	private String barcodeNo;

	private Double buyPriceIncludingTax;
	private Double buyPriceExcludingTax;
	private Double quantity;
	private Double rollSize;
	private String size;
	private String style;
	private String color;
	private Double weight;
	private String unit;
	private String company;
	private String hsnsacc;
	private Double discountAmount;
	private Double discountPercentage;
	private Double salePrice;
	private Double mrp;
	private Double gst;
	private Double igst;
	private Double taxpercentage;
	private Double taxAmount;
	private Double totalExcludingTax;
	private Double totalAmount;
	private String paymentMode;
	private Double labourExpence;
	private Double grossTotal;
	private Double transportExpence;
	private Long quotationNumber;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private Double totalQuantity;
	private Double totalTaxAmount;
	private String createdDate;
	private String createdBy;

}
