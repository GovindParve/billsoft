package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesBean {
	
	private Long pkSaleQuatationId;
	private String saleQuotationNo;
	private Long fkCatId;
	private String categoryName;
	private Long fksubcatId;
	private String subCategoryName;
	private Long fkProductId;
	private String productName;
	private Long fkCustomerId;
	private String customerName;
	private String address;
	private String emailId;
	private Long contactNo;
	private String gstNo;
	private String barcodeNo;
	private String quotationDate;
	private String paymentMode;
	private Double salePriceIncludingTax;
	private Double salePriceExcludingTax;
	private String company;
	private Double quantity;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double taxAmount;
	private String hsnorsac;
	private Double weight;
	private String unit;
	private Double totalExcludingTax;
	private Double totalAmount;
	private Double discount;
	private Double discountAmount;
	private String gstExpense;
	private Double labourExpense;
	private Double transportExpense;
	private Double taxPercentage;
	private Double labourTaxAmount;
	private Double grossTotal;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String status;
	
	
	
	/// Constructor to Retrieve the data of Product Details By Barcode Number 
	
	public SalesBean(String barcodeNo, String productName,Long fkProductId,  String company, String hsnorsac, Double salePriceIncludingTax,
			 Double quantity,String unit, Double sgst, Double cgst, Double igst,
			 Double taxAmount, Double discount, Double discountAmount, Double totalExcludingTax, Double totalAmount,
			  Double grossTotal) {
		super();
		this.barcodeNo = barcodeNo;
		this.fkProductId = fkProductId;
		this.productName = productName;
		this.company = company;
		this.hsnorsac = hsnorsac;
		this.salePriceIncludingTax = salePriceIncludingTax;
		this.quantity = quantity;
		this.unit = unit;
		this.sgst = sgst;
		this.cgst = cgst;
		this.igst = igst;
		this.taxAmount = taxAmount;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.totalExcludingTax = totalExcludingTax;
		this.totalAmount = totalAmount;	
		this.grossTotal = grossTotal;
	}
	
	/// Constructor to Retrieve the data of Product Details By Product Id
	
		public SalesBean( String productName, Long fkProductId,  String company, String hsnorsac,  Double salePriceIncludingTax,
				 Double quantity,String unit, Double sgst, Double cgst, Double igst,
				 Double taxAmount, Double discount, Double discountAmount, Double totalExcludingTax, Double totalAmount,
				  Double grossTotal) {
			super();
			this.fkProductId = fkProductId;
			this.productName = productName;
			this.company = company;
			this.salePriceIncludingTax = salePriceIncludingTax;
			this.quantity = quantity;
			this.hsnorsac = hsnorsac;
			this.unit = unit;
			this.sgst = sgst;
			this.cgst = cgst;
			this.igst = igst;
			this.taxAmount = taxAmount;
			this.discount = discount;
			this.discountAmount = discountAmount;
			this.totalExcludingTax = totalExcludingTax;
			this.totalAmount = totalAmount;	
			this.grossTotal = grossTotal;
		}
	
	
	
	
	
	
}
