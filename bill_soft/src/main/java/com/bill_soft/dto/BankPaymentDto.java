package com.bill_soft.dto;

public class BankPaymentDto {
	private Long pkBankPaymentId;
	private Long fkBankId;
	private String bankName;
	private String contactNumber;
	private String accountantName;
	private String paymentDate;
	private String paymentType;
	private String paymentMode;
	private Double paidAmount;
	private Long transactionId;
	private String description;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkOrganizationId;
	private String organizationName;
	private String createdBy;
	private String createdDate;

	public BankPaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankPaymentDto(Long pkBankPaymentId, Long fkBankId, String bankName, String contactNumber,
			String accountantName, String paymentDate, String paymentType, String paymentMode, Double paidAmount,
			Long transactionId, String description, Long fkShopId, String shopName, Long fkAdminId, String adminName,
			Long fkOrganizationId, String organizationName, String createdBy, String createdDate) {
		super();
		this.pkBankPaymentId = pkBankPaymentId;
		this.fkBankId = fkBankId;
		this.bankName = bankName;
		this.contactNumber = contactNumber;
		this.accountantName = accountantName;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentMode = paymentMode;
		this.paidAmount = paidAmount;
		this.transactionId = transactionId;
		this.description = description;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkOrganizationId = fkOrganizationId;
		this.organizationName = organizationName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Long getPkBankPaymentId() {
		return pkBankPaymentId;
	}

	public void setPkBankPaymentId(Long pkBankPaymentId) {
		this.pkBankPaymentId = pkBankPaymentId;
	}

	public Long getFkBankId() {
		return fkBankId;
	}

	public void setFkBankId(Long fkBankId) {
		this.fkBankId = fkBankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAccountantName() {
		return accountantName;
	}

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
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

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getFkOrganizationId() {
		return fkOrganizationId;
	}

	public void setFkOrganizationId(Long fkOrganizationId) {
		this.fkOrganizationId = fkOrganizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "BankPaymentDto [pkBankPaymentId=" + pkBankPaymentId + ", fkBankId=" + fkBankId + ", bankName="
				+ bankName + ", contactNumber=" + contactNumber + ", accountantName=" + accountantName
				+ ", paymentDate=" + paymentDate + ", paymentType=" + paymentType + ", paymentMode=" + paymentMode
				+ ", paidAmount=" + paidAmount + ", transactionId=" + transactionId + ", description=" + description
				+ ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName="
				+ adminName + ", fkOrganizationId=" + fkOrganizationId + ", organizationName=" + organizationName
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}

}
