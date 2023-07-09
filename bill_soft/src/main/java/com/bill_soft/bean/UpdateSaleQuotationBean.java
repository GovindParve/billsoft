package com.bill_soft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleQuotationBean {

	
	private Long pkSaleQuatationId;
	private Long pkGoodReceiveId;
	private Integer srNo;
	private String barcodeNo;
	private String productName;
	private Long fkProductId;
	private String company;
	private String hsnsac;
	private Double salePriceInclusiveTax;
	private Double salePriceExclusiveTax;
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
	private Double labourExpenses;
	private Double transportExpenses;
	private Double labourTaxAmount;
	private String quotationNumber;
	
	
	
	private Long fkCatId;
	private String categoryName;
	private Long fksubcatId;
	private String subCategoryName;
	private Long fkCustomerId;
	private String customerName;
	private String address;
	private String emailId;
	private Long contactNo;
	private String gstNo;
	private String quotationDate;
	private String paymentMode;
	private Double weight;
	private String gstExpense;
	private Double taxPercentage;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String status;
	
////Constructor For the Update Sale Quotation Grid to get data from Sale Quotation Details While updating the Product 
	
	public UpdateSaleQuotationBean(String quotationNumber, String barcodeNo, String productName, Long fkProductId, String company, String hsnsac,
			Double salePriceInclusiveTax, Double salePriceExclusiveTax, Double quantity, String unit, Double sgst,
			Double cgst, Double igst, Double taxAmount, Double discount, Double discountAmount,
			Double totalExcludingTax, Double totalAmount, Double grossTotal, Double labourExpenses,
			Double transportExpenses, Double labourTaxAmount) {
		super();
		this.quotationNumber = quotationNumber;
		this.barcodeNo = barcodeNo;
		this.productName = productName;
		this.fkProductId = fkProductId;
		this.company = company;
		this.hsnsac = hsnsac;
		this.salePriceInclusiveTax = salePriceInclusiveTax;
		this.salePriceExclusiveTax = salePriceExclusiveTax;
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
		this.labourExpenses = labourExpenses;
		this.transportExpenses = transportExpenses;
		this.labourTaxAmount = labourTaxAmount;
	}


	
	
	
////Constructor For the Update Sale Quotation Grid to get data from Sale Quotation Details While adding the new  Product in Sale Quotation
	

	public UpdateSaleQuotationBean(String productName, Long fkProductId, String company, String hsnsac,
			Double salePriceInclusiveTax, Double salePriceExclusiveTax, Double quantity, String unit, Double sgst,
			Double cgst, Double igst, Double taxAmount, Double discount, Double discountAmount,
			Double totalExcludingTax, Double totalAmount, Double grossTotal, Double labourExpenses,
			Double transportExpenses, Double labourTaxAmount) {
		super();
		this.productName = productName;
		this.fkProductId = fkProductId;
		this.company = company;
		this.hsnsac = hsnsac;
		this.salePriceInclusiveTax = salePriceInclusiveTax;
		this.salePriceExclusiveTax = salePriceExclusiveTax;
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
		this.labourExpenses = labourExpenses;
		this.transportExpenses = transportExpenses;
		this.labourTaxAmount = labourTaxAmount;
	}
}
