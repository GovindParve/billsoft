package com.bill_soft.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString

public class SaleQuotationGrid {

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
	
	
	////Constructor For to get Product Details in Update Sale Quotation Grid From Good Receive/////////

	public SaleQuotationGrid( Long pkGoodReceiveId, String barcodeNo, String productName, Long fkProductId,
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
	

	/// Constructor for the Sale Quotation Update Grid to Save the Data 
	
		public SaleQuotationGrid(Long pkSaleQuatationId, String barcodeNo, String productName, Long fkProductId, String company, Double salePriceInclusiveTax, Double salePriceExclusiveTax, Double quantity, String unit,
				Double sgst, Double cgst, Double igst, Double taxAmount, Double discount, Double discountAmount,
				Double totalExcludingTax, Double totalAmount, Double grossTotal, Double labourExpenses, Double transportExpenses, Double labourTaxAmount, String quotationNumber) {
			super();
			this.pkSaleQuatationId = pkSaleQuatationId;
			this.barcodeNo = barcodeNo;
			this.productName = productName;
			this.fkProductId = fkProductId;
			this.company = company;
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
			this.labourExpenses= labourExpenses;
			this.transportExpenses= transportExpenses;
			this.labourTaxAmount= labourTaxAmount;
			this.quotationNumber = quotationNumber;
		}

	
	
	/// Constructor for the Sale Quotation Update Grid
	
	public SaleQuotationGrid(Long pkSaleQuatationId, String barcodeNo, String productName, Long fkProductId, String company, Double salePriceInclusiveTax, Double salePriceExclusiveTax, Double quantity, String unit,
			Double sgst, Double cgst, Double igst, Double taxAmount, Double discount, Double discountAmount,
			Double totalExcludingTax, Double totalAmount, Double grossTotal, Double labourExpenses, Double transportExpenses, Double labourTaxAmount) {
		super();
		this.pkSaleQuatationId = pkSaleQuatationId;
		this.barcodeNo = barcodeNo;
		this.productName = productName;
		this.fkProductId = fkProductId;
		this.company = company;
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
		this.labourExpenses= labourExpenses;
		this.transportExpenses= transportExpenses;
		this.labourTaxAmount= labourTaxAmount;
	}


	
	
	
	
}
