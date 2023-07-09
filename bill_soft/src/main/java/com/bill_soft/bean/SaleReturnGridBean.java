package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleReturnGridBean {

	private Long pkBillId;
	private Long saleQuotationNo;
	private String companyName;
	private String customerName;
	private String contactNo;
	private String emailId;
	private String address;
	private String gstNo;
	private Long billNo;
	private String billDate;
	private String barcodeNo;
	private String customerType;
	private String paymentMode;
	private Double salePriceIncludingtax;
	private Double salePriceExcludingTax;
	private Double quantity;
	private Double weight;
	private String unit;
	private String color;
	private String packingType;
	private Double discount;
	private Double discountAmount;
	private Double cgst;
	private Double sgst;
	private Double igst;
	private Double taxPercentage;
	private Double taxAmount;
	private Double totalExcludingTax;
	private Double totalAmount;
	private Double grossTotal;
	private Double labourExpense;
	private Double transportExpense;
	private Double gstExpense;
	private String batchno;
	private String manufacturingDate;
	private String expiryDate;
	private Double amountRecieved;
	private Long fkCatId;
	private String categoryName;
	private Long fkSubCatId;
	private String subCategoryName;
	private Long fkProductId;
	private String productName;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkOragnizationId;
	private String oragnizationName;
	private String createdBy;
	private String createdDate;
	private Double returnQuantity;
	private Double returnAmount;
	
	
	
	public SaleReturnGridBean( Long saleQuotationNo, String companyName, String customerName,
			String contactNo, String emailId, String address, String gstNo, Long billNo, String billDate,
			String barcodeNo, String customerType, String paymentMode, Double salePriceIncludingtax,
			Double salePriceExcludingTax, Double quantity, Double weight, String unit, Double discount, Double discountAmount, Double cgst, Double sgst, Double igst,
			Double taxPercentage, Double taxAmount, Double totalExcludingTax, Double totalAmount, Double grossTotal,
			Double labourExpense, Double transportExpense, Double gstExpense, String batchno, String manufacturingDate,
			String expiryDate, Double amountRecieved, Long fkCatId, String categoryName, Long fkSubCatId,
			String subCategoryName, Long fkProductId, String productName, Long fkShopId, String shopName,
			Long fkAdminId, String adminName, Long fkOragnizationId, String oragnizationName, String createdBy,
			String createdDate, Double returnQuantity) {
		super();
		this.saleQuotationNo = saleQuotationNo;
		this.companyName = companyName;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.address = address;
		this.gstNo = gstNo;
		this.billNo = billNo;
		this.billDate = billDate;
		this.barcodeNo = barcodeNo;
		this.customerType = customerType;
		this.paymentMode = paymentMode;
		this.salePriceIncludingtax = salePriceIncludingtax;
		this.salePriceExcludingTax = salePriceExcludingTax;
		this.quantity = quantity;
		this.weight = weight;
		this.unit = unit;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.taxPercentage = taxPercentage;
		this.taxAmount = taxAmount;
		this.totalExcludingTax = totalExcludingTax;
		this.totalAmount = totalAmount;
		this.grossTotal = grossTotal;
		this.labourExpense = labourExpense;
		this.transportExpense = transportExpense;
		this.gstExpense = gstExpense;
		this.batchno = batchno;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.amountRecieved = amountRecieved;
		this.fkCatId = fkCatId;
		this.categoryName = categoryName;
		this.fkSubCatId = fkSubCatId;
		this.subCategoryName = subCategoryName;
		this.fkProductId = fkProductId;
		this.productName = productName;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkOragnizationId = fkOragnizationId;
		this.oragnizationName = oragnizationName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.returnQuantity= returnQuantity;
	}
	
	

	
	
	
}
