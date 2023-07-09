package com.bill_soft.dto;

public class ProductDto {
	
	private Long pkProductId;
	private String productName;
	private Long fkCategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String subcategoryName;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkTaxId;
	private Long fkUnitId;
	private Long fkoragnizationId;
	private String oragnizationName;
	private Double cgst;
	private Double sgst;
	private Double igst;
	private String manufactureCompany;
	private Double weight;
	private String unit;
	private Double rollSize;
	private String size;
	private String modelName;
	private String color;
	private String style;
	private Double buyPriceIncludingTax;
	private Double purchaseDiscount;
	private Double salePriceIncludingTax;
	private Double saleDiscount;
	private Double mrp;
	private Double tax;
	private String hsnCode;
	private String isBarcodeProduct;
	private String discription;
	private String imagePath;

	private Double unitQuantity;
	private String createdDate;
	private String createdBy;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPkProductId() {
		return pkProductId;
	}

	public ProductDto(Long pkProductId, String productName, Long fkCategoryId, String categoryName,
			Long fkSubCategoryId, String subcategoryName, Long fkShopId, String shopName, Long fkAdminId,
			String adminName, Long fkTaxId, Long fkUnitId, Long fkoragnizationId, String oragnizationName, Double cgst,
			Double sgst, Double igst, String manufactureCompany, Double weight, String unit, Double rollSize,
			String size, String modelName, String color, String style, Double buyPriceIncludingTax,
			Double purchaseDiscount, Double salePriceIncludingTax, Double saleDiscount, Double mrp, Double tax,
			String hsnCode, String isBarcodeProduct, String discription, String imagePath, Double unitQuantity,
			String createdDate, String createdBy) {
		super();
		this.pkProductId = pkProductId;
		this.productName = productName;
		this.fkCategoryId = fkCategoryId;
		this.categoryName = categoryName;
		this.fkSubCategoryId = fkSubCategoryId;
		this.subcategoryName = subcategoryName;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkTaxId = fkTaxId;
		this.fkUnitId = fkUnitId;
		this.fkoragnizationId = fkoragnizationId;
		this.oragnizationName = oragnizationName;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.manufactureCompany = manufactureCompany;
		this.weight = weight;
		this.unit = unit;
		this.rollSize = rollSize;
		this.size = size;
		this.modelName = modelName;
		this.color = color;
		this.style = style;
		this.buyPriceIncludingTax = buyPriceIncludingTax;
		this.purchaseDiscount = purchaseDiscount;
		this.salePriceIncludingTax = salePriceIncludingTax;
		this.saleDiscount = saleDiscount;
		this.mrp = mrp;
		this.tax = tax;
		this.hsnCode = hsnCode;
		this.isBarcodeProduct = isBarcodeProduct;
		this.discription = discription;
		this.imagePath = imagePath;
		this.unitQuantity = unitQuantity;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
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

	public Long getFkCategoryId() {
		return fkCategoryId;
	}

	public void setFkCategoryId(Long fkCategoryId) {
		this.fkCategoryId = fkCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getFkSubCategoryId() {
		return fkSubCategoryId;
	}

	public void setFkSubCategoryId(Long fkSubCategoryId) {
		this.fkSubCategoryId = fkSubCategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public Long getFkShopId() {
		return fkShopId;
	}

	public void setFkShopId(Long fkShopId) {
		this.fkShopId = fkShopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getFkAdminId() {
		return fkAdminId;
	}

	public void setFkAdminId(Long fkAdminId) {
		this.fkAdminId = fkAdminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Long getFkTaxId() {
		return fkTaxId;
	}

	public void setFkTaxId(Long fkTaxId) {
		this.fkTaxId = fkTaxId;
	}

	public Long getFkUnitId() {
		return fkUnitId;
	}

	public void setFkUnitId(Long fkUnitId) {
		this.fkUnitId = fkUnitId;
	}

	public Long getFkoragnizationId() {
		return fkoragnizationId;
	}

	public void setFkoragnizationId(Long fkoragnizationId) {
		this.fkoragnizationId = fkoragnizationId;
	}

	public String getOragnizationName() {
		return oragnizationName;
	}

	public void setOragnizationName(String oragnizationName) {
		this.oragnizationName = oragnizationName;
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

	public String getManufactureCompany() {
		return manufactureCompany;
	}

	public void setManufactureCompany(String manufactureCompany) {
		this.manufactureCompany = manufactureCompany;
	}

//	public String getPacking() {
//		return packing;
//	}
//
//	public void setPacking(String packing) {
//		this.packing = packing;
//	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getRollSize() {
		return rollSize;
	}

	public void setRollSize(Double rollSize) {
		this.rollSize = rollSize;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
//	public String getGstType() {
//		return gstType;
//	}
//
//	public void setGstType(String gstType) {
//		this.gstType = gstType;
//	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

//	public Double getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(Double discount) {
//		this.discount = discount;
//	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

//	public String getUnitType() {
//		return unitType;
//	}
//
//	public void setUnitType(String unitType) {
//		this.unitType = unitType;
//	}

	public Double getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(Double unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getBuyPriceIncludingTax() {
		return buyPriceIncludingTax;
	}

	public void setBuyPriceIncludingTax(Double buyPriceIncludingTax) {
		this.buyPriceIncludingTax = buyPriceIncludingTax;
	}

	public Double getSalePriceIncludingTax() {
		return salePriceIncludingTax;
	}

	public void setSalePriceIncludingTax(Double salePriceIncludingTax) {
		this.salePriceIncludingTax = salePriceIncludingTax;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Double getPurchaseDiscount() {
		return purchaseDiscount;
	}

	public void setPurchaseDiscount(Double purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	public Double getSaleDiscount() {
		return saleDiscount;
	}

	public void setSaleDiscount(Double saleDiscount) {
		this.saleDiscount = saleDiscount;
	}

	public String getIsBarcodeProduct() {
		return isBarcodeProduct;
	}

	public void setIsBarcodeProduct(String isBarcodeProduct) {
		this.isBarcodeProduct = isBarcodeProduct;
	}

	@Override
	public String toString() {
		return "ProductDto [pkProductId=" + pkProductId + ", productName=" + productName + ", fkCategoryId="
				+ fkCategoryId + ", categoryName=" + categoryName + ", fkSubCategoryId=" + fkSubCategoryId
				+ ", subcategoryName=" + subcategoryName + ", fkShopId=" + fkShopId + ", shopName=" + shopName
				+ ", fkAdminId=" + fkAdminId + ", adminName=" + adminName + ", fkTaxId=" + fkTaxId + ", fkUnitId="
				+ fkUnitId + ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName
				+ ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", manufactureCompany=" + manufactureCompany
				+ ", weight=" + weight + ", unit=" + unit + ", rollSize=" + rollSize + ", size=" + size + ", modelName="
				+ modelName + ", color=" + color + ", style=" + style + ", buyPriceIncludingTax=" + buyPriceIncludingTax
				+ ", purchaseDiscount=" + purchaseDiscount + ", salePriceIncludingTax=" + salePriceIncludingTax
				+ ", saleDiscount=" + saleDiscount + ", mrp=" + mrp + ", tax=" + tax + ", hsnCode=" + hsnCode
				+ ", isBarcodeProduct=" + isBarcodeProduct + ", discription=" + discription + ", imagePath=" + imagePath
				+ ", unitQuantity=" + unitQuantity + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}

}
