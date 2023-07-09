package com.bill_soft.dto;

public class SupplierPaymentDto {
	private Long pkSupplierPaymentId;
	private Long fkSupplierId;
	private String SupplierName;
	private Long billNo;
	private String paymentDate;
	private String accountantName;
	private Double totalAmount;
	private String paymentType;
	private String paymentMode;
	private Double balanceAmount;
	private Double paymentAmount;
	private String description;
	private Long transcationId;
	private Long receiptNo;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	
	
	public SupplierPaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SupplierPaymentDto(Long pkSupplierPaymentId, Long fkSupplierId, String supplierName, Long billNo,
			String paymentDate, String accountantName, Double totalAmount, String paymentType, String paymentMode,
			Double balanceAmount, Double paymentAmount, String description, Long transcationId, Long receiptNo,
			Long fkShopId, String shopName, Long fkAdminId, String adminName, Long fkoragnizationId,
			String oragnizationName, String createdDate, String createdBy) {
		super();
		this.pkSupplierPaymentId = pkSupplierPaymentId;
		this.fkSupplierId = fkSupplierId;
		SupplierName = supplierName;
		this.billNo = billNo;
		this.paymentDate = paymentDate;
		this.accountantName = accountantName;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		this.paymentMode = paymentMode;
		this.balanceAmount = balanceAmount;
		this.paymentAmount = paymentAmount;
		this.description = description;
		this.transcationId = transcationId;
		this.receiptNo = receiptNo;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkoragnizationId = fkoragnizationId;
		this.oragnizationName = oragnizationName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}


	public Long getPkSupplierPaymentId() {
		return pkSupplierPaymentId;
	}


	public void setPkSupplierPaymentId(Long pkSupplierPaymentId) {
		this.pkSupplierPaymentId = pkSupplierPaymentId;
	}


	public Long getFkSupplierId() {
		return fkSupplierId;
	}


	public void setFkSupplierId(Long fkSupplierId) {
		this.fkSupplierId = fkSupplierId;
	}


	public String getSupplierName() {
		return SupplierName;
	}


	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}


	public Long getBillNo() {
		return billNo;
	}


	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getAccountantName() {
		return accountantName;
	}


	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public Double getBalanceAmount() {
		return balanceAmount;
	}


	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}


	public Double getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getTranscationId() {
		return transcationId;
	}


	public void setTranscationId(Long transcationId) {
		this.transcationId = transcationId;
	}


	public Long getReceiptNo() {
		return receiptNo;
	}


	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
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
		return "SupplierPaymentDto [pkSupplierPaymentId=" + pkSupplierPaymentId + ", fkSupplierId=" + fkSupplierId
				+ ", SupplierName=" + SupplierName + ", billNo=" + billNo + ", paymentDate=" + paymentDate
				+ ", accountantName=" + accountantName + ", totalAmount=" + totalAmount + ", paymentType=" + paymentType
				+ ", paymentMode=" + paymentMode + ", balanceAmount=" + balanceAmount + ", paymentAmount="
				+ paymentAmount + ", description=" + description + ", transcationId=" + transcationId + ", receiptNo="
				+ receiptNo + ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId
				+ ", adminName=" + adminName + ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName="
				+ oragnizationName + ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}
	
	
	
	
}
