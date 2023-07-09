package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodReceiveGridBean {

	private Long pkProductId;
	private String productName;
	private Long fkCategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String subcategoryName;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkTaxId;
	private Long fkUnitId;
	private Long fkoragnizationId;
	private String oragnizationName;
	private Double gst;
	private Double igst;
	private String manufactureCompany;
	private Double weight;
	private String unit;
	private Double rollSize;
	private String size;
	private String modelName;
	private String color;
	private String style;
	private Double buyPriceIncludingTax;
	private Double purchaseDiscount;
	private Double salePriceIncludingTax;
	private Double saleDiscount;
	private Double mrp;
	private Double tax;
	private String hsnCode;
	private String isBarcodeProduct;
	private String discription;
	private Double unitQuantity;
	private String createdDate;
	private String createdBy;
	private Long pkPurchaseOrderId;
	private Long fkPurchaseQuotationId;
	private Long quotationNumber;
	private Long purchaseOrderNumber;
	private Long fkSupplierId;
	private String supplierName;
	private String emailId;
	private String city;
	private String address;
	private String contactNo;
	private String gstNo;
	private Long fkProductId;
	private String purchaseOrderDate;
	private String barcodeNo;
	private Double quantity;
	private String company;
	private String hsnsacc;
	private Double buyPriceExcludingTax;
	private Double discount;
	private Double discountAmount;
	private Double salePrice;
	private Double taxpercentage;
	private Double taxAmount;
	private Double totalExcludingTax;
	private Double totalAmount;
	private String payDuedate;
	private Double transportExpense;
	private Double labourExpense;
	private Double totalQuantity;
	private Double totalTaxAmount;
	private String paymentMode;
	private Double grossTotal;
	private Long pkPurchaseQuotationId;
	private String quotationDate;
	private Double discountPercentage;
	private Double labourExpence;
	private Double transportExpence;

}
