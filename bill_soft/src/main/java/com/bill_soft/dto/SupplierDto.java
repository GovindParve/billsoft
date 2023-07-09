package com.bill_soft.dto;

public class SupplierDto {
	private Long pkSuppplierId;
	private String firstName;
	private String lastName;
	private String personName;
	private String contactNumber;
	private String alternateNumber;
	private String emailId;
	private String city;
	private String address;
	private String gstNo;
	private String accountHolderName;
	private String accountNumber;
	private String ifscNo;
	private String upiId;
	private String openingBalane;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	
	public SupplierDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public SupplierDto(Long pkSuppplierId, String firstName, String lastName, String personName, String contactNumber,
			String alternateNumber, String emailId, String city, String address, String gstNo, String accountHolderName,
			String accountNumber, String ifscNo, String upiId, String openingBalane, String createdDate,
			String createdBy, Long fkShopId, String shopName, Long fkAdminId, String adminName, Long fkoragnizationId,
			String oragnizationName) {
		super();
		this.pkSuppplierId = pkSuppplierId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personName = personName;
		this.contactNumber = contactNumber;
		this.alternateNumber = alternateNumber;
		this.emailId = emailId;
		this.city = city;
		this.address = address;
		this.gstNo = gstNo;
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.ifscNo = ifscNo;
		this.upiId = upiId;
		this.openingBalane = openingBalane;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkoragnizationId = fkoragnizationId;
		this.oragnizationName = oragnizationName;
	}



	public Long getPkSuppplierId() {
		return pkSuppplierId;
	}

	public void setPkSuppplierId(Long pkSuppplierId) {
		this.pkSuppplierId = pkSuppplierId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
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

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getOpeningBalane() {
		return openingBalane;
	}

	public void setOpeningBalane(String openingBalane) {
		this.openingBalane = openingBalane;
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

	@Override
	public String toString() {
		return "SupplierDto [pkSuppplierId=" + pkSuppplierId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", personName=" + personName + ", contactNumber=" + contactNumber + ", alternateNumber="
				+ alternateNumber + ", emailId=" + emailId + ", City=" + city + ", address=" + address + ", gstNo="
				+ gstNo + ", accountHolderName=" + accountHolderName + ", accountNumber=" + accountNumber + ", ifscNo="
				+ ifscNo + ", upiId=" + upiId + ", openingBalane=" + openingBalane + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId="
				+ fkAdminId + ", adminName=" + adminName + ", fkoragnizationId=" + fkoragnizationId
				+ ", oragnizationName=" + oragnizationName + "]";
	}

	
	
	

	
	

}
