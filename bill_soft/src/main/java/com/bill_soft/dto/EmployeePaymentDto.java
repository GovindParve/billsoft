package com.bill_soft.dto;

public class EmployeePaymentDto {
	private Long pkEmployeePaymentId;
	private String employeeName;
	private Long fkEmployeeId;
	private String contactNumber;
	private String accountantName;
	private String paymentDate;
	private String paymentType;
	private String paymentMode;
	private Double paidAmount;
	private String reason;
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

	public EmployeePaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePaymentDto(Long pkEmployeePaymentId, String employeeName, Long fkEmployeeId, String contactNumber,
			String accountantName, String paymentDate, String paymentType, String paymentMode, Double paidAmount,
			String reason, Long transactionId, String description, Long fkShopId, String shopName, Long fkAdminId,
			String adminName, Long fkOrganizationId, String organizationName, String createdBy, String createdDate) {
		super();
		this.pkEmployeePaymentId = pkEmployeePaymentId;
		this.employeeName = employeeName;
		this.fkEmployeeId = fkEmployeeId;
		this.contactNumber = contactNumber;
		this.accountantName = accountantName;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.paymentMode = paymentMode;
		this.paidAmount = paidAmount;
		this.reason = reason;
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

	public Long getPkEmployeePaymentId() {
		return pkEmployeePaymentId;
	}

	public void setPkEmployeePaymentId(Long pkEmployeePaymentId) {
		this.pkEmployeePaymentId = pkEmployeePaymentId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getFkEmployeeId() {
		return fkEmployeeId;
	}

	public void setFkEmployeeId(Long fkEmployeeId) {
		this.fkEmployeeId = fkEmployeeId;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
		return "EmployeePaymentDto [pkEmployeePaymentId=" + pkEmployeePaymentId + ", employeeName=" + employeeName
				+ ", fkEmployeeId=" + fkEmployeeId + ", contactNumber=" + contactNumber + ", accountantName="
				+ accountantName + ", paymentDate=" + paymentDate + ", paymentType=" + paymentType + ", paymentMode="
				+ paymentMode + ", paidAmount=" + paidAmount + ", reason=" + reason + ", transactionId=" + transactionId
				+ ", description=" + description + ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId="
				+ fkAdminId + ", adminName=" + adminName + ", fkOrganizationId=" + fkOrganizationId
				+ ", organizationName=" + organizationName + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ "]";
	}

}
