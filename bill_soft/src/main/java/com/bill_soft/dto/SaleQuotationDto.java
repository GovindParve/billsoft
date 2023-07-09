package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleQuotationDto {

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
	private Double salePriceInclusiveTax;
	private Double salePriceExclusiveTax;
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
	
	
}
