package com.bill_soft.bean;

public class purchaseQuotationGrid {

	private Long pkProductId;
	private String barcodeNo;
	private String productName;
	private String subCategoryName;
	private Double quantity;
	private Double rollSize;
	private String size;
	private String color;
	private String style;
	private Double weight;
	private String unit;
	private String company;
	private String hsnorsac;
	private Double buyPriceIncludingTax;
	private Double buyPriceExcludingTax;
	private Double discount;
	private Double discountAmount;
	private Double gst;
	private Double igst;
	private Double totalExcludingTax;
	private Double taxAmount;
	private Double total;
	private String batchNo;
	private String manufactureDate;
    private String expiryDate;
	public purchaseQuotationGrid() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
//
//	public purchaseQuotationGrid( String barcodeNo, String productname, String subCategoryName,
//			Double quantity, Double rollSize, String size, String color, String style, Double weight, String unit,
//			String company, String hsnorsac, Double buyPriceIncludingTax, Double buyPriceExcludingTax, Double discount,
//			Double discountAmopunt, Double gst, Double igst, Double totalExcludingTax, Double taxAmount, Double total) {
//		super();
//	
//		this.barcodeNo = barcodeNo;
//		this.productname = productname;
//		this.subCategoryName = subCategoryName;
//		this.quantity = quantity;
//		this.rollSize = rollSize;
//		this.size = size;
//		this.color = color;
//		this.style = style;
//		this.weight = weight;
//		this.unit = unit;
//		this.company = company;
//		this.hsnorsac = hsnorsac;
//		this.buyPriceIncludingTax = buyPriceIncludingTax;
//		this.buyPriceExcludingTax = buyPriceExcludingTax;
//		this.discount = discount;
//		this.discountAmopunt = discountAmopunt;
//		this.gst = gst;
//		this.igst = igst;
//		this.totalExcludingTax = totalExcludingTax;
//		this.taxAmount = taxAmount;
//		this.total = total;
//	}






//	public Long getSrNo() {
//		return srNo;
//	}
//
//
//	public void setSrNo(Long srNo) {
//		this.srNo = srNo;
//	}


	public String getBarcodeNo() {
		return barcodeNo;
	}

//	public purchaseQuotationGrid(Long pkProductId, String barcodeNo, String productName, String subCategoryName,
//		Double quantity, Double rollSize, String size, String color, String style, Double weight, String unit,
//		String company, String hsnorsac, Double buyPriceIncludingTax, Double buyPriceExcludingTax, Double discount,
//		Double discountAmount, Double gst, Double igst, Double totalExcludingTax, Double taxAmount, Double total) {
//	super();
//	this.pkProductId = pkProductId;
//	this.barcodeNo = barcodeNo;
//	this.productName = productName;
//	this.subCategoryName = subCategoryName;
//	this.quantity = quantity;
//	this.rollSize = rollSize;
//	this.size = size;
//	this.color = color;
//	this.style = style;
//	this.weight = weight;
//	this.unit = unit;
//	this.company = company;
//	this.hsnorsac = hsnorsac;
//	this.buyPriceIncludingTax = buyPriceIncludingTax;
//	this.buyPriceExcludingTax = buyPriceExcludingTax;
//	this.discount = discount;
//	this.discountAmount = discountAmount;
//	this.gst = gst;
//	this.igst = igst;
//	this.totalExcludingTax = totalExcludingTax;
//	this.taxAmount = taxAmount;
//	this.total = total;
//}





	public void setBarcodeNo(String barcodeNo) {
		this.barcodeNo = barcodeNo;
	}

	public purchaseQuotationGrid(Long pkProductId, String barcodeNo, String productName, String subCategoryName,
		Double quantity, Double rollSize, String size, String color, String style, Double weight, String unit,
		String company, String hsnorsac, Double buyPriceIncludingTax, Double buyPriceExcludingTax, Double discount,
		Double discountAmount, Double gst, Double igst, Double totalExcludingTax, Double taxAmount, Double total,
		String batchNo, String manufactureDate, String expiryDate) {
	super();
	this.pkProductId = pkProductId;
	this.barcodeNo = barcodeNo;
	this.productName = productName;
	this.subCategoryName = subCategoryName;
	this.quantity = quantity;
	this.rollSize = rollSize;
	this.size = size;
	this.color = color;
	this.style = style;
	this.weight = weight;
	this.unit = unit;
	this.company = company;
	this.hsnorsac = hsnorsac;
	this.buyPriceIncludingTax = buyPriceIncludingTax;
	this.buyPriceExcludingTax = buyPriceExcludingTax;
	this.discount = discount;
	this.discountAmount = discountAmount;
	this.gst = gst;
	this.igst = igst;
	this.totalExcludingTax = totalExcludingTax;
	this.taxAmount = taxAmount;
	this.total = total;
	this.batchNo = batchNo;
	this.manufactureDate = manufactureDate;
	this.expiryDate = expiryDate;
}





	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getHsnorsac() {
		return hsnorsac;
	}

	public void setHsnorsac(String hsnorsac) {
		this.hsnorsac = hsnorsac;
	}

	public Double getBuyPriceIncludingTax() {
		return buyPriceIncludingTax;
	}

	public void setBuyPriceIncludingTax(Double buyPriceIncludingTax) {
		this.buyPriceIncludingTax = buyPriceIncludingTax;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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

	public Double getTotalExcludingTax() {
		return totalExcludingTax;
	}

	public void setTotalExcludingTax(Double totalExcludingTax) {
		this.totalExcludingTax = totalExcludingTax;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	
	public Double getRollSize() {
		return rollSize;
	}






	public void setRollSize(Double rollSize) {
		this.rollSize = rollSize;
	}






	public String getSize() {
		return size;
	}






	public void setSize(String size) {
		this.size = size;
	}






	public String getColor() {
		return color;
	}






	public void setColor(String color) {
		this.color = color;
	}






	public String getStyle() {
		return style;
	}






	public void setStyle(String style) {
		this.style = style;
	}






	public Double getBuyPriceExcludingTax() {
		return buyPriceExcludingTax;
	}






	public void setBuyPriceExcludingTax(Double buyPriceExcludingTax) {
		this.buyPriceExcludingTax = buyPriceExcludingTax;
	}






	public Long getPkProductId() {
		return pkProductId;
	}





	public void setPkProductId(Long pkProductId) {
		this.pkProductId = pkProductId;
	}





	public String getProductName() {
		return productName;
	}





	public void setProductName(String productName) {
		this.productName = productName;
	}





	public Double getDiscountAmount() {
		return discountAmount;
	}





	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}





	public String getBatchNo() {
		return batchNo;
	}





	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}





	public String getManufactureDate() {
		return manufactureDate;
	}





	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}





	public String getExpiryDate() {
		return expiryDate;
	}





	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}





	@Override
	public String toString() {
		return "purchaseQuotationGrid [pkProductId=" + pkProductId + ", barcodeNo=" + barcodeNo + ", productName="
				+ productName + ", subCategoryName=" + subCategoryName + ", quantity=" + quantity + ", rollSize="
				+ rollSize + ", size=" + size + ", color=" + color + ", style=" + style + ", weight=" + weight
				+ ", unit=" + unit + ", company=" + company + ", hsnorsac=" + hsnorsac + ", buyPriceIncludingTax="
				+ buyPriceIncludingTax + ", buyPriceExcludingTax=" + buyPriceExcludingTax + ", discount=" + discount
				+ ", discountAmount=" + discountAmount + ", gst=" + gst + ", igst=" + igst + ", totalExcludingTax="
				+ totalExcludingTax + ", taxAmount=" + taxAmount + ", total=" + total + ", batchNo=" + batchNo
				+ ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate + "]";
	}




//
//	@Override
//	public String toString() {
//		return "purchaseQuotationGrid [pkProductId=" + pkProductId + ", barcodeNo=" + barcodeNo + ", productName="
//				+ productName + ", subCategoryName=" + subCategoryName + ", quantity=" + quantity + ", rollSize="
//				+ rollSize + ", size=" + size + ", color=" + color + ", style=" + style + ", weight=" + weight
//				+ ", unit=" + unit + ", company=" + company + ", hsnorsac=" + hsnorsac + ", buyPriceIncludingTax="
//				+ buyPriceIncludingTax + ", buyPriceExcludingTax=" + buyPriceExcludingTax + ", discount=" + discount
//				+ ", discountAmount=" + discountAmount + ", gst=" + gst + ", igst=" + igst + ", totalExcludingTax="
//				+ totalExcludingTax + ", taxAmount=" + taxAmount + ", total=" + total + "]";
//	}





	






	
	
	
	

}
