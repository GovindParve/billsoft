package com.bill_soft.bean;

public class SupplierWisePurchaseReport {

private String billNo;
private String supplierName;
private String categoryName;
private String subCategoryName;
private String productName;
private String barcodeNo;
private String size;
private String hsnsac;
private Double quantity;
private Double returnQuantity;

private Double availableQuantity;
private Double soldQuantity;

public SupplierWisePurchaseReport() {
	super();
	// TODO Auto-generated constructor stub
}






public SupplierWisePurchaseReport(String billNo, String supplierName, String categoryName, String subCategoryName,
		String productName, String barcodeNo, String size, String hsnsac, Double quantity, Double returnQuantity,
		Double soldQuantity, Double availableQuantity) {
	super();
	this.billNo = billNo;
	this.supplierName = supplierName;
	this.categoryName = categoryName;
	this.subCategoryName = subCategoryName;
	this.productName = productName;
	this.barcodeNo = barcodeNo;
	this.size = size;
	this.hsnsac = hsnsac;
	this.quantity = quantity;
	this.returnQuantity = returnQuantity;
	this.soldQuantity = soldQuantity;
	this.availableQuantity = availableQuantity;
}






public String getBillNo() {
	return billNo;
}

public void setBillNo(String billNo) {
	this.billNo = billNo;
}









public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}



public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getBarcodeNo() {
	return barcodeNo;
}

public void setBarcodeNo(String barcodeNo) {
	this.barcodeNo = barcodeNo;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
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

public Double getAvailableQuantity() {
	return availableQuantity;
}

public void setAvailableQuantity(Double availableQuantity) {
	this.availableQuantity = availableQuantity;
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






public String getHsnsac() {
	return hsnsac;
}






public void setHsnsac(String hsnsac) {
	this.hsnsac = hsnsac;
}






@Override
public String toString() {
	return "SupplierWisePurchaseReport [billNo=" + billNo + ", supplierName=" + supplierName + ", categoryName="
			+ categoryName + ", subCategoryName=" + subCategoryName + ", productName=" + productName + ", barcodeNo="
			+ barcodeNo + ", size=" + size + ", hsnsac=" + hsnsac + ", quantity=" + quantity + ", returnQuantity="
			+ returnQuantity + ", soldQuantity=" + soldQuantity + ", availableQuantity=" + availableQuantity + "]";
}




}
