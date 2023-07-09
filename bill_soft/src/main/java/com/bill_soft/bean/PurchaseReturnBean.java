package com.bill_soft.bean;

public class PurchaseReturnBean {

	private Long srNO;
	private String purchaseReturnDate;
	private String billNo;
	private String barcodeNo;
	private String categoryName;
	private String productName;
	private Double returnQuantity;
	private Double buyPrice;
	private Double discount;
	private Double discountAmount;
	private Double tax;
	private Double taxAmount;
	private Double returnAmount;
	
	
	public PurchaseReturnBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getSrNO() {
		return srNO;
	}


	public void setSrNO(Long srNO) {
		this.srNO = srNO;
	}


	public String getPurchaseReturnDate() {
		return purchaseReturnDate;
	}


	public void setPurchaseReturnDate(String purchaseReturnDate) {
		this.purchaseReturnDate = purchaseReturnDate;
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


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getReturnQuantity() {
		return returnQuantity;
	}


	public void setReturnQuantity(Double returnQuantity) {
		this.returnQuantity = returnQuantity;
	}


	public Double getBuyPrice() {
		return buyPrice;
	}


	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
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


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}


	public Double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public Double getReturnAmount() {
		return returnAmount;
	}


	public void setReturnAmount(Double returnAmount) {
		this.returnAmount = returnAmount;
	}


	@Override
	public String toString() {
		return "PurchaseReturnBean [srNO=" + srNO + ", purchaseReturnDate=" + purchaseReturnDate + ", billNo=" + billNo
				+ ", barcodeNo=" + barcodeNo + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", returnQuantity=" + returnQuantity + ", buyPrice=" + buyPrice + ", discount=" + discount
				+ ", discountAmount=" + discountAmount + ", tax=" + tax + ", taxAmount=" + taxAmount + ", returnAmount="
				+ returnAmount + "]";
	}
	
	
	
}
