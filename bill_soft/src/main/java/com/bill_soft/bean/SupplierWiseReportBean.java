package com.bill_soft.bean;

public class SupplierWiseReportBean {

	private Long pkReportId;
	private String barcodeNo;
	private String categoryName;
	private String itemName;
	private Double purchasedQuantity;
	private Double soldQuantity;
	private Double returnQuantity;
	private Double availableQuantity;
	private Double buyPrice;
	private Double availableQunatityBuyPrice;
	private Double salePrice;
	private Double availableQunatitySalePrice;
	private Double taxPercentage;
	
	public SupplierWiseReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierWiseReportBean(Long pkReportId, String barcodeNo, String categoryName, String itemName,
			Double purchasedQuantity, Double soldQuantity, Double returnQuantity, Double availableQuantity,
			Double buyPrice, Double availableQunatityBuyPrice, Double salePrice, Double availableQunatitySalePrice,
			Double taxPercentage) {
		super();
		this.pkReportId = pkReportId;
		this.barcodeNo = barcodeNo;
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.purchasedQuantity = purchasedQuantity;
		this.soldQuantity = soldQuantity;
		this.returnQuantity = returnQuantity;
		this.availableQuantity = availableQuantity;
		this.buyPrice = buyPrice;
		this.availableQunatityBuyPrice = availableQunatityBuyPrice;
		this.salePrice = salePrice;
		this.availableQunatitySalePrice = availableQunatitySalePrice;
		this.taxPercentage = taxPercentage;
	}

	public Long getPkReportId() {
		return pkReportId;
	}

	public void setPkReportId(Long pkReportId) {
		this.pkReportId = pkReportId;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public void setPurchasedQuantity(Double purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}

	public Double getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(Double soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public Double getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(Double returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public Double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getAvailableQunatityBuyPrice() {
		return availableQunatityBuyPrice;
	}

	public void setAvailableQunatityBuyPrice(Double availableQunatityBuyPrice) {
		this.availableQunatityBuyPrice = availableQunatityBuyPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getAvailableQunatitySalePrice() {
		return availableQunatitySalePrice;
	}

	public void setAvailableQunatitySalePrice(Double availableQunatitySalePrice) {
		this.availableQunatitySalePrice = availableQunatitySalePrice;
	}

	public Double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	@Override
	public String toString() {
		return "SupplierWiseReportBean [pkReportId=" + pkReportId + ", barcodeNo=" + barcodeNo + ", categoryName="
				+ categoryName + ", itemName=" + itemName + ", purchasedQuantity=" + purchasedQuantity
				+ ", soldQuantity=" + soldQuantity + ", returnQuantity=" + returnQuantity + ", availableQuantity="
				+ availableQuantity + ", buyPrice=" + buyPrice + ", availableQunatityBuyPrice="
				+ availableQunatityBuyPrice + ", salePrice=" + salePrice + ", availableQunatitySalePrice="
				+ availableQunatitySalePrice + ", taxPercentage=" + taxPercentage + "]";
	}
	
	
	
	
}
