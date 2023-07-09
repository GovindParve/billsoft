package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleInvoiceGridBean {
	
	private long pkGoodReceiveId;
	private int srNo;
	private String barcodeNo; 
	private String productName;
	private long fkProductId;
	private String company; 
	private String hsnsac;
	private Double salePriceInclusiveTax;
	private Double salePriceExclusiveTax;
	private Double availableQuantity;
	private Double quantity;
	private String unit;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double taxAmount;
	private Double discount;
	private Double discountAmount;
	private Double totalExcludingTax;
	private Double totalAmount;
	private Double grossTotal;
	
	private String quotationDate; 
	private String customerName; 
	private Long contactNo; 
	private String address;
	private String customerGstno; 
	private String email;
	
	///  Controller To get the Sale Invoice Grid Details from Product Details Table
	public SaleInvoiceGridBean(long pkGoodReceiveId, String barcodeNo, String productName, long fkProductId,
			String company, String hsnsac, Double salePriceInclusiveTax, Double availableQuantity, Double quantity, String unit,
			Double sgst, Double cgst, Double igst, Double taxAmount, Double discount, Double discountAmount,
			Double totalExcludingTax, Double totalAmount, Double grossTotal) {
		super();
		this.pkGoodReceiveId = pkGoodReceiveId;
		this.barcodeNo = barcodeNo;
		this.productName = productName;
		this.fkProductId = fkProductId;
		this.company = company;
		this.hsnsac = hsnsac;
		this.salePriceInclusiveTax = salePriceInclusiveTax;
		this.availableQuantity = availableQuantity;
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

	
	
	
	///Controller To get the Sale Invoice Grid Details from Sale Quotation Details Table
	
	
	public SaleInvoiceGridBean(String barcodeNo, String productName, long fkProductId, String company, String hsnsac,
			Double salePriceInclusiveTax, Double salePriceExclusiveTax, Double availableQuantity, Double quantity,
			String unit, Double sgst, Double cgst, Double igst, Double taxAmount, Double discount,
			Double discountAmount, Double totalExcludingTax, Double totalAmount, Double grossTotal,
			String quotationDate, String customerName, Long contactNo, String address, String customerGstno,
			String email) {
		super();
		this.barcodeNo = barcodeNo;
		this.productName = productName;
		this.fkProductId = fkProductId;
		this.company = company;
		this.hsnsac = hsnsac;
		this.salePriceInclusiveTax = salePriceInclusiveTax;
		this.salePriceExclusiveTax = salePriceExclusiveTax;
		this.availableQuantity = availableQuantity;
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
		this.quotationDate = quotationDate;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.customerGstno = customerGstno;
		this.email = email;
	}
	
	

	// Constructor For Sale Invoice By Barcode Number
	public SaleInvoiceGridBean(long pkGoodReceiveId, String barcodeNo, String productName, long fkProductId,
			String company, String hsnsac, Double salePriceInclusiveTax, Double quantity, String unit, Double sgst,
			Double cgst, Double igst, Double taxAmount, Double discount, Double discountAmount,
			Double totalExcludingTax, Double totalAmount, Double grossTotal) {
		super();
		this.pkGoodReceiveId = pkGoodReceiveId;
		this.barcodeNo = barcodeNo;
		this.productName = productName;
		this.fkProductId = fkProductId;
		this.company = company;
		this.hsnsac = hsnsac;
		this.salePriceInclusiveTax = salePriceInclusiveTax;
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




	
	
	

}
