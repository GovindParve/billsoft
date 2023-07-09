package com.bill_soft.dto;

public class CustomerDto {
	private Long pkCustomerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String contactNumber;
	private String alternateNumber;
	private String emailId;
	private String city;
	private String address;
	private String firmname;
	private String gstNo;
	private String zipCode;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	
	
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerDto(Long pkCustomerId, String firstName, String middleName, String lastName, String contactNumber,
			String alternateNumber, String emailId, String city, String address, String firmname, String gstNo,
			String zipCode, String createdDate, String createdBy, Long fkShopId, String shopName, Long fkAdminId,
			String adminName, Long fkoragnizationId, String oragnizationName) {
		super();
		this.pkCustomerId = pkCustomerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.alternateNumber = alternateNumber;
		this.emailId = emailId;
		this.city = city;
		this.address = address;
		this.firmname = firmname;
		this.gstNo = gstNo;
		this.zipCode = zipCode;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkoragnizationId = fkoragnizationId;
		this.oragnizationName = oragnizationName;
	}


	public Long getPkCustomerId() {
		return pkCustomerId;
	}


	public void setPkCustomerId(Long pkCustomerId) {
		this.pkCustomerId = pkCustomerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getFirmname() {
		return firmname;
	}


	public void setFirmname(String firmname) {
		this.firmname = firmname;
	}


	public String getGstNo() {
		return gstNo;
	}


	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
		return "CustomerDto [pkCustomerId=" + pkCustomerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", alternateNumber=" + alternateNumber
				+ ", emailId=" + emailId + ", city=" + city + ", address=" + address + ", firmname=" + firmname
				+ ", gstNo=" + gstNo + ", zipCode=" + zipCode + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId
				+ ", adminName=" + adminName + ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName="
				+ oragnizationName + "]";
	}
	
	

}
