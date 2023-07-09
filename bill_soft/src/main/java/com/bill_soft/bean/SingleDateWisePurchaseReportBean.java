package com.bill_soft.bean;

public class SingleDateWisePurchaseReportBean {

	private Long srNo;
	private String date;
	private String billNo;
	private Long voucherNo;
	private String supplierName;
	private String categoryName;
	private String subCategoryName;
	private String productName;
	private String hsnsac;
	private Double quantity;
	private Double returnQuantity;
	private Double soldQuantity;
	private Double buyPrice;
	private Double discount;
	private Double discountAmount;
	private Double gst;
	private Double igst;
	
	private Double taxAmount;
	private Double salePrice;
	private Double totalAmount;
	private Double grossAmount;
	
	
	public SingleDateWisePurchaseReportBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SingleDateWisePurchaseReportBean(Long srNo, String date, String billNo, Long voucherNo, String supplierName,
			String categoryName, String subCategoryName, String productName, String hsnsac, Double quantity,
			Double returnQuantity, Double soldQuantity, Double buyPrice, Double discount, Double discountAmount,
			Double gst, Double igst, Double taxAmount, Double salePrice, Double totalAmount, Double grossAmount) {
		super();
		this.srNo = srNo;
		this.date = date;
		this.billNo = billNo;
		this.voucherNo = voucherNo;
		this.supplierName = supplierName;
		this.categoryName = categoryName;
		this.subCategoryName = subCategoryName;
		this.productName = productName;
		this.hsnsac = hsnsac;
		this.quantity = quantity;
		this.returnQuantity = returnQuantity;
		this.soldQuantity = soldQuantity;
		this.buyPrice = buyPrice;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.gst = gst;
		this.igst = igst;
		this.taxAmount = taxAmount;
		this.salePrice = salePrice;
		this.totalAmount = totalAmount;
		this.grossAmount = grossAmount;
	}


	public Long getSrNo() {
		return srNo;
	}


	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public Long getVoucherNo() {
		return voucherNo;
	}


	public void setVoucherNo(Long voucherNo) {
		this.voucherNo = voucherNo;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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


	public String getHsnsac() {
		return hsnsac;
	}


	public void setHsnsac(String hsnsac) {
		this.hsnsac = hsnsac;
	}


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	public Double getReturnQuantity() {
		return returnQuantity;
	}


	public void setReturnQuantity(Double returnQuantity) {
		this.returnQuantity = returnQuantity;
	}


	public Double getSoldQuantity() {
		return soldQuantity;
	}


	public void setSoldQuantity(Double soldQuantity) {
		this.soldQuantity = soldQuantity;
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


	public Double getGst() {
		return gst;
	}


	public void setGst(Double gst) {
		this.gst = gst;
	}


	public Double getIgst() {
		return igst;
	}


	public void setIgst(Double igst) {
		this.igst = igst;
	}


	public Double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public Double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Double getGrossAmount() {
		return grossAmount;
	}


	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}


	@Override
	public String toString() {
		return "SingleDateWisePurchaseReportBean [srNo=" + srNo + ", date=" + date + ", billNo=" + billNo
				+ ", voucherNo=" + voucherNo + ", supplierName=" + supplierName + ", categoryName=" + categoryName
				+ ", subCategoryName=" + subCategoryName + ", productName=" + productName + ", hsnsac=" + hsnsac
				+ ", quantity=" + quantity + ", returnQuantity=" + returnQuantity + ", soldQuantity=" + soldQuantity
				+ ", buyPrice=" + buyPrice + ", discount=" + discount + ", discountAmount=" + discountAmount + ", gst="
				+ gst + ", igst=" + igst + ", taxAmount=" + taxAmount + ", salePrice=" + salePrice + ", totalAmount="
				+ totalAmount + ", grossAmount=" + grossAmount + "]";
	}
	
	
}
