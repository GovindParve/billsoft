package com.bill_soft.dto;

public class PurchaseOrderDto {

	private Long pkPurchaseOrderId;
	private Long fkPurchaseQuotationId;
	private Long quotationNumber;
	private Long purchaseOrderNumber;
	private Long fkSupplierId;
	private String supplierName;
	private String emailId;
	private String city;
	private String address;
	private String contactNo;
	private String gstNo;
	
	private Long fkCategoryId;
	private String categoryName;
	private Long fkSubCategoryId;
	private String subCategoryName;
	private Long fkProductId;
	private String productName;
	private String purchaseOrderDate;
	private String barcodeNo;
	private Double quantity;
	private Double weight;
	private Double rollSize;
	private String size; 
	private String style;
	private String color;
	private String unit;
	private String company;
	private String hsnsacc;
	private Double buyPriceIncludingTax;
	private Double buyPriceExcludingTax;
	private Double discount;
	private Double discountAmount;
	private Double salePrice;
	private Double mrp;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double taxpercentage;
	private Double taxAmount;
	private Double totalExcludingTax;
	private Double totalAmount;
	private String payDuedate;
	private Double transportExpense;
	private Double labourExpense;
	private Double totalQuantity;
	private Double totalTaxAmount;
	private String paymentMode;
	private Double grossTotal;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;

	public PurchaseOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderDto(Long pkPurchaseOrderId, Long fkPurchaseQuotationId, Long quotationNumber,
			Long purchaseOrderNumber, Long fkSupplierId, String supplierName, String emailId, String city,
			String address, String contactNo, String gstNo, Long fkCategoryId, String categoryName,
			Long fkSubCategoryId, String subCategoryName, Long fkProductId, String productName,
			String purchaseOrderDate, String barcodeNo, Double quantity, Double weight, Double rollSize, String size,
			String style, String color, String unit, String company, String hsnsacc, Double buyPriceIncludingTax,
			Double buyPriceExcludingTax, Double discount, Double discountAmount, Double salePrice, Double mrp,
			Double sgst, Double cgst, Double igst, Double taxpercentage, Double taxAmount, Double totalExcludingTax,
			Double totalAmount, String payDuedate, Double transportExpense, Double labourExpense, Double totalQuantity,
			Double totalTaxAmount, String paymentMode, Double grossTotal, Long fkShopId, String shopName,
			Long fkAdminId, String adminName, Long fkoragnizationId, String oragnizationName, String createdDate,
			String createdBy) {
		super();
		this.pkPurchaseOrderId = pkPurchaseOrderId;
		this.fkPurchaseQuotationId = fkPurchaseQuotationId;
		this.quotationNumber = quotationNumber;
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.fkSupplierId = fkSupplierId;
		this.supplierName = supplierName;
		this.emailId = emailId;
		this.city = city;
		this.address = address;
		this.contactNo = contactNo;
		this.gstNo = gstNo;
		this.fkCategoryId = fkCategoryId;
		this.categoryName = categoryName;
		this.fkSubCategoryId = fkSubCategoryId;
		this.subCategoryName = subCategoryName;
		this.fkProductId = fkProductId;
		this.productName = productName;
		this.purchaseOrderDate = purchaseOrderDate;
		this.barcodeNo = barcodeNo;
		this.quantity = quantity;
		this.weight = weight;
		this.rollSize = rollSize;
		this.size = size;
		this.style = style;
		this.color = color;
		this.unit = unit;
		this.company = company;
		this.hsnsacc = hsnsacc;
		this.buyPriceIncludingTax = buyPriceIncludingTax;
		this.buyPriceExcludingTax = buyPriceExcludingTax;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.salePrice = salePrice;
		this.mrp = mrp;
		this.sgst = sgst;
		this.cgst = cgst;
		this.igst = igst;
		this.taxpercentage = taxpercentage;
		this.taxAmount = taxAmount;
		this.totalExcludingTax = totalExcludingTax;
		this.totalAmount = totalAmount;
		this.payDuedate = payDuedate;
		this.transportExpense = transportExpense;
		this.labourExpense = labourExpense;
		this.totalQuantity = totalQuantity;
		this.totalTaxAmount = totalTaxAmount;
		this.paymentMode = paymentMode;
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

	public Long getFkPurchaseQuotationId() {
		return fkPurchaseQuotationId;
	}

	public void setFkPurchaseQuotationId(Long fkPurchaseQuotationId) {
		this.fkPurchaseQuotationId = fkPurchaseQuotationId;
	}

	public Long getQuotationNumber() {
		return quotationNumber;
	}

	public void setQuotationNumber(Long quotationNumber) {
		this.quotationNumber = quotationNumber;
	}

	public Long getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(Long purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
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

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
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

	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public String getBarcodeNo() {
		return barcodeNo;
	}

	public void setBarcodeNo(String barcodeNo) {
		this.barcodeNo = barcodeNo;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public Double getBuyPriceIncludingTax() {
		return buyPriceIncludingTax;
	}

	public void setBuyPriceIncludingTax(Double buyPriceIncludingTax) {
		this.buyPriceIncludingTax = buyPriceIncludingTax;
	}

	public Double getBuyPriceExcludingTax() {
		return buyPriceExcludingTax;
	}

	public void setBuyPriceExcludingTax(Double buyPriceExcludingTax) {
		this.buyPriceExcludingTax = buyPriceExcludingTax;
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

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
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

	public Double getTaxpercentage() {
		return taxpercentage;
	}

	public void setTaxpercentage(Double taxpercentage) {
		this.taxpercentage = taxpercentage;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalExcludingTax() {
		return totalExcludingTax;
	}

	public void setTotalExcludingTax(Double totalExcludingTax) {
		this.totalExcludingTax = totalExcludingTax;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPayDuedate() {
		return payDuedate;
	}

	public void setPayDuedate(String payDuedate) {
		this.payDuedate = payDuedate;
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

	public Double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(Double totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
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
		return "PurchaseOrderDto [pkPurchaseOrderId=" + pkPurchaseOrderId + ", fkPurchaseQuotationId="
				+ fkPurchaseQuotationId + ", quotationNumber=" + quotationNumber + ", purchaseOrderNumber="
				+ purchaseOrderNumber + ", fkSupplierId=" + fkSupplierId + ", supplierName=" + supplierName
				+ ", emailId=" + emailId + ", city=" + city + ", address=" + address + ", contactNo=" + contactNo
				+ ", gstNo=" + gstNo + ", fkCategoryId=" + fkCategoryId + ", categoryName=" + categoryName
				+ ", fkSubCategoryId=" + fkSubCategoryId + ", subCategoryName=" + subCategoryName + ", fkProductId="
				+ fkProductId + ", productName=" + productName + ", purchaseOrderDate=" + purchaseOrderDate
				+ ", barcodeNo=" + barcodeNo + ", quantity=" + quantity + ", weight=" + weight + ", rollSize="
				+ rollSize + ", size=" + size + ", style=" + style + ", color=" + color + ", unit=" + unit
				+ ", company=" + company + ", hsnsacc=" + hsnsacc + ", buyPriceIncludingTax=" + buyPriceIncludingTax
				+ ", buyPriceExcludingTax=" + buyPriceExcludingTax + ", discount=" + discount + ", discountAmount="
				+ discountAmount + ", salePrice=" + salePrice + ", mrp=" + mrp + ", sgst=" + sgst + ", cgst=" + cgst
				+ ", igst=" + igst + ", taxpercentage=" + taxpercentage + ", taxAmount=" + taxAmount
				+ ", totalExcludingTax=" + totalExcludingTax + ", totalAmount=" + totalAmount + ", payDuedate="
				+ payDuedate + ", transportExpense=" + transportExpense + ", labourExpense=" + labourExpense
				+ ", totalQuantity=" + totalQuantity + ", totalTaxAmount=" + totalTaxAmount + ", paymentMode="
				+ paymentMode + ", grossTotal=" + grossTotal + ", fkShopId=" + fkShopId + ", shopName=" + shopName
				+ ", fkAdminId=" + fkAdminId + ", adminName=" + adminName + ", fkoragnizationId=" + fkoragnizationId
				+ ", oragnizationName=" + oragnizationName + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ "]";
	}
    
	
	
	

}
