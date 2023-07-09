package com.bill_soft.dto;

public class ShopDto {

	private Long pkShopId;
	private String shopName;
	private String shopAddress;
	private String shopRegistrationDate;
	private String contactNo;
	private String gstNo;
	private String city;
	private Long fkOrganizationId;
	private String organizationName;
	private Long fkAdminId;
	private String adminName;
	private String businessType;
	private String shopLogo;

	public ShopDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ShopDto(Long pkShopId, String shopName, String shopAddress, String shopRegistrationDate, String contactNo,
//			String gstNo, String city, Long fkOrganizationId, String organizationName, Long fkAdminId, String adminName,
//			String shopLogo) {
//		super();
//		this.pkShopId = pkShopId;
//		this.shopName = shopName;
//		this.shopAddress = shopAddress;
//		this.shopRegistrationDate = shopRegistrationDate;
//		this.contactNo = contactNo;
//		this.gstNo = gstNo;
//		this.city = city;
//		this.fkOrganizationId = fkOrganizationId;
//		this.organizationName = organizationName;
//		this.fkAdminId = fkAdminId;
//		this.adminName = adminName;
//		this.shopLogo = shopLogo;
//	}
	
	

	public Long getPkShopId() {
		return pkShopId;
	}

	public ShopDto(Long pkShopId, String shopName, String shopAddress, String shopRegistrationDate, String contactNo,
		String gstNo, String city, Long fkOrganizationId, String organizationName, Long fkAdminId, String adminName,
		String businessType, String shopLogo) {
	super();
	this.pkShopId = pkShopId;
	this.shopName = shopName;
	this.shopAddress = shopAddress;
	this.shopRegistrationDate = shopRegistrationDate;
	this.contactNo = contactNo;
	this.gstNo = gstNo;
	this.city = city;
	this.fkOrganizationId = fkOrganizationId;
	this.organizationName = organizationName;
	this.fkAdminId = fkAdminId;
	this.adminName = adminName;
	this.businessType = businessType;
	this.shopLogo = shopLogo;
}

	public void setPkShopId(Long pkShopId) {
		this.pkShopId = pkShopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopRegistrationDate() {
		return shopRegistrationDate;
	}

	public void setShopRegistrationDate(String shopRegistrationDate) {
		this.shopRegistrationDate = shopRegistrationDate;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "ShopDto [pkShopId=" + pkShopId + ", shopName=" + shopName + ", shopAddress=" + shopAddress
				+ ", shopRegistrationDate=" + shopRegistrationDate + ", contactNo=" + contactNo + ", gstNo=" + gstNo
				+ ", city=" + city + ", fkOrganizationId=" + fkOrganizationId + ", organizationName=" + organizationName
				+ ", fkAdminId=" + fkAdminId + ", adminName=" + adminName + ", businessType=" + businessType
				+ ", shopLogo=" + shopLogo + "]";
	}

//	@Override
//	public String toString() {
//		return "ShopDto [pkShopId=" + pkShopId + ", shopName=" + shopName + ", shopAddress=" + shopAddress
//				+ ", shopRegistrationDate=" + shopRegistrationDate + ", contactNo=" + contactNo + ", gstNo=" + gstNo
//				+ ", city=" + city + ", fkOrganizationId=" + fkOrganizationId + ", organizationName=" + organizationName
//				+ ", fkAdminId=" + fkAdminId + ", adminName=" + adminName + ", shopLogo=" + shopLogo + "]";
//	}

	
}
