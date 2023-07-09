package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillDetailsDto {
	
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
	private Double cash;
	private Double card;
	private Double upi;
	private Double salePriceIncludingtax;
	private Double salePriceExcludingTax;
	private Double quantity;
	private Double weight;
	private String unit;
	private String size;
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
	private Double creditAmount;
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

	

}
