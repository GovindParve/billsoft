package com.bill_soft.bean;

public class PurchaseOrderBean {
	private Long pkPurchaseOrderId;
	private Long fkSupplierId;
	private String supplierName;
	
	 private String emailId;
	 private String contactNo;
	 private String barcodeNo;
	private Long fkCategoryId;
	 private Long categoryName;
	private Long fkSubCategoryId;
	 private Long subCategoryName;
	private Long fkProductId;
	private String productName;
	private String purchaseDate;
	private String payDuedate;
	private Double buypriceincludingtax;
	private Double buypriceexcludingtax;
	private Double buyPrice;
	private String unit;
	 private String company;
	 private String hsnsacc;
	private Double quantity;
	private Double weight;
	private Double discount;
	 private Double discountAmount;
	 private Double sgst;
	 private Double cgst;
	 private Double igst;
	 private Double totalExcludingTax;
	 private Double taxAmount;
	
	//private String totalGst;
	private Double transportExpense;
	private Double labourExpense;
	private Double total;
	private Double grossTotal;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	
	public PurchaseOrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderBean(Long pkPurchaseOrderId, Long fkSupplierId, String supplierName, String emailId,
			String contactNo, String barcodeNo, Long fkCategoryId, Long categoryName, Long fkSubCategoryId,
			Long subCategoryName, Long fkProductId, String productName, String purchaseDate, String payDuedate,
			Double buypriceincludingtax, Double buypriceexcludingtax, Double buyPrice, String unit, String company,
			String hsnsacc, Double quantity, Double weight, Double discount, Double discountAmount, Double sgst,
			Double cgst, Double igst, Double totalExcludingTax, Double taxAmount, Double transportExpense,
			Double labourExpense, Double total, Double grossTotal, Long fkShopId, String shopName, Long fkAdminId,
			String adminName, Long fkoragnizationId, String oragnizationName, String createdDate, String createdBy) {
		super();
		this.pkPurchaseOrderId = pkPurchaseOrderId;
		this.fkSupplierId = fkSupplierId;
		this.supplierName = supplierName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.barcodeNo = barcodeNo;
		this.fkCategoryId = fkCategoryId;
		this.categoryName = categoryName;
		this.fkSubCategoryId = fkSubCategoryId;
		this.subCategoryName = subCategoryName;
		this.fkProductId = fkProductId;
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		this.payDuedate = payDuedate;
		this.buypriceincludingtax = buypriceincludingtax;
		this.buypriceexcludingtax = buypriceexcludingtax;
		this.buyPrice = buyPrice;
		this.unit = unit;
		this.company = company;
		this.hsnsacc = hsnsacc;
		this.quantity = quantity;
		this.weight = weight;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.sgst = sgst;
		this.cgst = cgst;
		this.igst = igst;
		this.totalExcludingTax = totalExcludingTax;
		this.taxAmount = taxAmount;
		this.transportExpense = transportExpense;
		this.labourExpense = labourExpense;
		this.total = total;
		this.grossTotal = grossTotal;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkoragnizationId = fkoragnizationId;
		this.oragnizationName = oragnizationName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Long getPkPurchaseOrderId() {
		return pkPurchaseOrderId;
	}

	public void setPkPurchaseOrderId(Long pkPurchaseOrderId) {
		this.pkPurchaseOrderId = pkPurchaseOrderId;
	}

	public Long getFkSupplierId() {
		return fkSupplierId;
	}

	public void setFkSupplierId(Long fkSupplierId) {
		this.fkSupplierId = fkSupplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getBarcodeNo() {
		return barcodeNo;
	}

	public void setBarcodeNo(String barcodeNo) {
		this.barcodeNo = barcodeNo;
	}

	public Long getFkCategoryId() {
		return fkCategoryId;
	}

	public void setFkCategoryId(Long fkCategoryId) {
		this.fkCategoryId = fkCategoryId;
	}

	public Long getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(Long categoryName) {
		this.categoryName = categoryName;
	}

	public Long getFkSubCategoryId() {
		return fkSubCategoryId;
	}

	public void setFkSubCategoryId(Long fkSubCategoryId) {
		this.fkSubCategoryId = fkSubCategoryId;
	}

	public Long getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(Long subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Long getFkProductId() {
		return fkProductId;
	}

	public void setFkProductId(Long fkProductId) {
		this.fkProductId = fkProductId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPayDuedate() {
		return payDuedate;
	}

	public void setPayDuedate(String payDuedate) {
		this.payDuedate = payDuedate;
	}

	public Double getBuypriceincludingtax() {
		return buypriceincludingtax;
	}

	public void setBuypriceincludingtax(Double buypriceincludingtax) {
		this.buypriceincludingtax = buypriceincludingtax;
	}

	public Double getBuypriceexcludingtax() {
		return buypriceexcludingtax;
	}

	public void setBuypriceexcludingtax(Double buypriceexcludingtax) {
		this.buypriceexcludingtax = buypriceexcludingtax;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
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

	public String getHsnsacc() {
		return hsnsacc;
	}

	public void setHsnsacc(String hsnsacc) {
		this.hsnsacc = hsnsacc;
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

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
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

	public Double getTransportExpense() {
		return transportExpense;
	}

	public void setTransportExpense(Double transportExpense) {
		this.transportExpense = transportExpense;
	}

	public Double getLabourExpense() {
		return labourExpense;
	}

	public void setLabourExpense(Double labourExpense) {
		this.labourExpense = labourExpense;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
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

	@Override
	public String toString() {
		return "PurchaseOrderBean [pkPurchaseOrderId=" + pkPurchaseOrderId + ", fkSupplierId=" + fkSupplierId
				+ ", supplierName=" + supplierName + ", emailId=" + emailId + ", contactNo=" + contactNo
				+ ", barcodeNo=" + barcodeNo + ", fkCategoryId=" + fkCategoryId + ", categoryName=" + categoryName
				+ ", fkSubCategoryId=" + fkSubCategoryId + ", subCategoryName=" + subCategoryName + ", fkProductId="
				+ fkProductId + ", productName=" + productName + ", purchaseDate=" + purchaseDate + ", payDuedate="
				+ payDuedate + ", buypriceincludingtax=" + buypriceincludingtax + ", buypriceexcludingtax="
				+ buypriceexcludingtax + ", buyPrice=" + buyPrice + ", unit=" + unit + ", company=" + company
				+ ", hsnsacc=" + hsnsacc + ", quantity=" + quantity + ", weight=" + weight + ", discount=" + discount
				+ ", discountAmount=" + discountAmount + ", sgst=" + sgst + ", cgst=" + cgst + ", igst=" + igst
				+ ", totalExcludingTax=" + totalExcludingTax + ", taxAmount=" + taxAmount + ", transportExpense="
				+ transportExpense + ", labourExpense=" + labourExpense + ", total=" + total + ", grossTotal="
				+ grossTotal + ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId
				+ ", adminName=" + adminName + ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName="
				+ oragnizationName + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}
	
	

}
