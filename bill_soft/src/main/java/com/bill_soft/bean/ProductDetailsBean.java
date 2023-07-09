package com.bill_soft.bean;

public class ProductDetailsBean {

//	private Long fkCategoryId;
//	private Long fkSubCategoryId;
//
//	private Long pkProductId;
	private String productName;
	private String subcategoryName;
	private String hsnCode;
	private String manufactureCompany;
	private String unit;
	
	private Double weight;
	private Double mrp;
	private String tax_name;
	private Double cgst;
	private Double sgst;
	private Double igst;
	//private Double buyPrice;
	//private Double salePrice;
//	private String barcodeNo; 
//	private Double buyPriceExcludingTax;
//	private Double quantity;
//	private String batchNumber;
//	private String expiryDate;
//	private String manufacturingDate;
//	private Double discount;
//	private Double discountAmount;
//	private Double taxpercentage;
//	private Double taxAmount;
//	private Double totalExcludingTax;
//	private Double totalAmount;
//	
	//private Double quantity;

    
	
public ProductDetailsBean() {
	super();
	// TODO Auto-generated constructor stub
}

	

	public ProductDetailsBean(String productName, String subcategoryName, String hsnCode, String manufactureCompany,
		String unit, Double weight, Double mrp, String tax_name, Double cgst, Double sgst, Double igst, Double buyPrice,
		Double salePrice) {
	super();
	this.productName = productName;
	this.subcategoryName = subcategoryName;
	this.hsnCode = hsnCode;
	this.manufactureCompany = manufactureCompany;
	this.unit = unit;
	this.weight = weight;
	this.mrp = mrp;
	this.tax_name = tax_name;
	this.cgst = cgst;
	this.sgst = sgst;
	this.igst = igst;
	//this.buyPrice = buyPrice;
	//this.salePrice = salePrice;
}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getManufactureCompany() {
		return manufactureCompany;
	}

	public void setManufactureCompany(String manufactureCompany) {
		this.manufactureCompany = manufactureCompany;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public String getTax_name() {
		return tax_name;
	}

	public void setTax_name(String tax_name) {
		this.tax_name = tax_name;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}



	public ProductDetailsBean(String productName, String subcategoryName, String hsnCode, String manufactureCompany,
			String unit, Double weight, Double mrp, String tax_name, Double cgst, Double sgst, Double igst) {
		super();
		this.productName = productName;
		this.subcategoryName = subcategoryName;
		this.hsnCode = hsnCode;
		this.manufactureCompany = manufactureCompany;
		this.unit = unit;
		this.weight = weight;
		this.mrp = mrp;
		this.tax_name = tax_name;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
	}

//	public Double getBuyPrice() {
//		return buyPrice;
//	}
//
//	public void setBuyPrice(Double buyPrice) {
//		this.buyPrice = buyPrice;
//	}
//
//	public Double getSalePrice() {
//		return salePrice;
//	}
//
//	public void setSalePrice(Double salePrice) {
//		this.salePrice = salePrice;
//	}
//
//	@Override
//	public String toString() {
//		return "ProductDetailsBean [productName=" + productName + ", subcategoryName=" + subcategoryName + ", hsnCode="
//				+ hsnCode + ", manufactureCompany=" + manufactureCompany + ", unit=" + unit + ", weight=" + weight
//				+ ", mrp=" + mrp + ", tax_name=" + tax_name + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst
//				+ ", buyPrice=" + buyPrice + ", salePrice=" + salePrice + "]";
//	}

	


	
}
