package com.bill_soft.dto;

public class BankDto {
	private Long pkBankId;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String accountNumber;
	private String accountHolderName;
	private String contactNumber;
	private String bankEmail;
	private String address;
	private Long fkOragnizationId;
	private Long fkAdminId;
	private String createdBy;
	private String createdDate;

	public BankDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDto(Long pkBankId, String bankName, String branchName, String ifscCode, String accountNumber,
			String accountHolderName, String contactNumber, String bankEmail, String address, Long fkOragnizationId,
			Long fkAdminId, String createdBy, String createdDate) {
		super();
		this.pkBankId = pkBankId;
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.contactNumber = contactNumber;
		this.bankEmail = bankEmail;
		this.address = address;
		this.fkOragnizationId = fkOragnizationId;
		this.fkAdminId = fkAdminId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public Long getPkBankId() {
		return pkBankId;
	}

	public void setPkBankId(Long pkBankId) {
		this.pkBankId = pkBankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getFkOragnizationId() {
		return fkOragnizationId;
	}

	public void setFkOragnizationId(Long fkOragnizationId) {
		this.fkOragnizationId = fkOragnizationId;
	}

	public Long getFkAdminId() {
		return fkAdminId;
	}

	public void setFkAdminId(Long fkAdminId) {
		this.fkAdminId = fkAdminId;
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

	public String getBankEmail() {
		return bankEmail;
	}

	public void setBankEmail(String bankEmail) {
		this.bankEmail = bankEmail;
	}

	@Override
	public String toString() {
		return "BankDto [pkBankId=" + pkBankId + ", bankName=" + bankName + ", branchName=" + branchName + ", ifscCode="
				+ ifscCode + ", accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", contactNumber=" + contactNumber + ", bankEmail=" + bankEmail + ", address=" + address
				+ ", fkOragnizationId=" + fkOragnizationId + ", fkAdminId=" + fkAdminId + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + "]";
	}

}
