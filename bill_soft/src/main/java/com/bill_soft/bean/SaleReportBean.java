package com.bill_soft.bean;

public class SaleReportBean {
	
	private Long srNo;
	private String billNo;
	private String barcodeNo;
	private String categoryName;
	private String subCategoryName;
	private String productName;
	private Double quantity;
	private Double buyPriceExclusiveTax;
	private Double salePrice;
	private Double gst;
	private Double salePriceExcludingTax;
	private Double taxPercentage;
	private Double discount;
	private Double discountAmount;
	private Double taxAmountAfterDiscount;
	private Double totalAmount;
	private String date;
	
	
	public SaleReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public SaleReportBean(Long srNo, String billNo, String barcodeNo, String categoryName, String subCategoryName,
			String productName, Double quantity, Double buyPriceExclusiveTax, Double salePrice, Double gst,
			Double salePriceExcludingTax, Double taxPercentage, Double discount, Double discountAmount,
			Double taxAmountAfterDiscount, Double totalAmount, String date) {
		super();
		this.srNo = srNo;
		this.billNo = billNo;
		this.barcodeNo = barcodeNo;
		this.categoryName = categoryName;
		this.subCategoryName = subCategoryName;
		this.productName = productName;
		this.quantity = quantity;
		this.buyPriceExclusiveTax = buyPriceExclusiveTax;
		this.salePrice = salePrice;
		this.gst = gst;
		this.salePriceExcludingTax = salePriceExcludingTax;
		this.taxPercentage = taxPercentage;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.taxAmountAfterDiscount = taxAmountAfterDiscount;
		this.totalAmount = totalAmount;
		this.date = date;
	}




	public Long getSrNo() {
		return srNo;
	}


	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public String getBarcodeNo() {
		return barcodeNo;
	}


	public void setBarcodeNo(String barcodeNo) {
		this.barcodeNo = barcodeNo;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getSubCategoryName() {
		return subCategoryName;
	}


	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public Double getBuyPriceExclusiveTax() {
		return buyPriceExclusiveTax;
	}


	public void setBuyPriceExclusiveTax(Double buyPriceExclusiveTax) {
		this.buyPriceExclusiveTax = buyPriceExclusiveTax;
	}


	public Double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}


	public Double getGst() {
		return gst;
	}


	public void setGst(Double gst) {
		this.gst = gst;
	}


	public Double getSalePriceExcludingTax() {
		return salePriceExcludingTax;
	}


	public void setSalePriceExcludingTax(Double salePriceExcludingTax) {
		this.salePriceExcludingTax = salePriceExcludingTax;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public Double getDiscountAmount() {
		return discountAmount;
	}


	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}


	public Double getTaxAmountAfterDiscount() {
		return taxAmountAfterDiscount;
	}


	public void setTaxAmountAfterDiscount(Double taxAmountAfterDiscount) {
		this.taxAmountAfterDiscount = taxAmountAfterDiscount;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Double getTaxPercentage() {
		return taxPercentage;
	}




	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}




	@Override
	public String toString() {
		return "SaleReportBean [srNo=" + srNo + ", billNo=" + billNo + ", barcodeNo=" + barcodeNo + ", categoryName="
				+ categoryName + ", subCategoryName=" + subCategoryName + ", productName=" + productName + ", quantity="
				+ quantity + ", buyPriceExclusiveTax=" + buyPriceExclusiveTax + ", salePrice=" + salePrice + ", gst="
				+ gst + ", salePriceExcludingTax=" + salePriceExcludingTax + ", taxPercentage=" + taxPercentage
				+ ", discount=" + discount + ", discountAmount=" + discountAmount + ", taxAmountAfterDiscount="
				+ taxAmountAfterDiscount + ", totalAmount=" + totalAmount + ", date=" + date + "]";
	}




	
	
	
	
}
