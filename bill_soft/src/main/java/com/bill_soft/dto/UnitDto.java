package com.bill_soft.dto;

public class UnitDto {
	private Long pkUnitId;
	private String unitName;
	private String description;
	private String unitValue;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String businessType;
	
	
	public UnitDto() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public UnitDto(Long pkUnitId, String unitName, String description, String unitValue, String createdDate,
//			String createdBy, Long fkShopId, String shopName, Long fkAdminId, String adminName, Long fkoragnizationId,
//			String oragnizationName) {
//		super();
//		this.pkUnitId = pkUnitId;
//		this.unitName = unitName;
//		this.description = description;
//		this.unitValue = unitValue;
//		this.createdDate = createdDate;
//		this.createdBy = createdBy;
//		this.fkShopId = fkShopId;
//		this.shopName = shopName;
//		this.fkAdminId = fkAdminId;
//		this.adminName = adminName;
//		this.fkoragnizationId = fkoragnizationId;
//		this.oragnizationName = oragnizationName;
//	}
//
	
	

	public Long getPkUnitId() {
		return pkUnitId;
	}


	public UnitDto(Long pkUnitId, String unitName, String description, String unitValue, String createdDate,
		String createdBy, Long fkShopId, String shopName, Long fkAdminId, String adminName, Long fkoragnizationId,
		String oragnizationName, String businessType) {
	super();
	this.pkUnitId = pkUnitId;
	this.unitName = unitName;
	this.description = description;
	this.unitValue = unitValue;
	this.createdDate = createdDate;
	this.createdBy = createdBy;
	this.fkShopId = fkShopId;
	this.shopName = shopName;
	this.fkAdminId = fkAdminId;
	this.adminName = adminName;
	this.fkoragnizationId = fkoragnizationId;
	this.oragnizationName = oragnizationName;
	this.businessType = businessType;
}


	public void setPkUnitId(Long pkUnitId) {
		this.pkUnitId = pkUnitId;
	}


	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUnitValue() {
		return unitValue;
	}


	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
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

	

	public String getBusinessType() {
		return businessType;
	}


	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}


	@Override
	public String toString() {
		return "UnitDto [pkUnitId=" + pkUnitId + ", unitName=" + unitName + ", description=" + description
				+ ", unitValue=" + unitValue + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName="
				+ adminName + ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName
				+ ", businessType=" + businessType + "]";
	}


//	@Override
//	public String toString() {
//		return "UnitDto [pkUnitId=" + pkUnitId + ", unitName=" + unitName + ", description=" + description
//				+ ", unitValue=" + unitValue + ", createdDate=" + createdDate + ", createdBy=" + createdBy
//				+ ", fkShopId=" + fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName="
//				+ adminName + ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName + "]";
//	}


	
	
}
