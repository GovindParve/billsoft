package com.bill_soft.dto;

public class CategoryDto {

	private Long pkCategoryId;
	private String categoryName;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String businessType;
	private String createdBy;
	private String createdDate;
	
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public CategoryDto(Long pkCategoryId, String categoryName, Long fkShopId, String shopName, Long fkAdminId,
//			String adminName, Long fkoragnizationId, String oragnizationName, String createdBy, String createdDate) {
//		super();
//		this.pkCategoryId = pkCategoryId;
//		this.categoryName = categoryName;
//		this.fkShopId = fkShopId;
//		this.shopName = shopName;
//		this.fkAdminId = fkAdminId;
//		this.adminName = adminName;
//		this.fkoragnizationId = fkoragnizationId;
//		this.oragnizationName = oragnizationName;
//		this.createdBy = createdBy;
//		this.createdDate = createdDate;
//	}

	
	
	
	public Long getPkCategoryId() {
		return pkCategoryId;
	}

	public CategoryDto(Long pkCategoryId, String categoryName, Long fkShopId, String shopName, Long fkAdminId,
		String adminName, Long fkoragnizationId, String oragnizationName, String businessType, String createdBy,
		String createdDate) {
	super();
	this.pkCategoryId = pkCategoryId;
	this.categoryName = categoryName;
	this.fkShopId = fkShopId;
	this.shopName = shopName;
	this.fkAdminId = fkAdminId;
	this.adminName = adminName;
	this.fkoragnizationId = fkoragnizationId;
	this.oragnizationName = oragnizationName;
	this.businessType = businessType;
	this.createdBy = createdBy;
	this.createdDate = createdDate;
}

	public void setPkCategoryId(Long pkCategoryId) {
		this.pkCategoryId = pkCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	
	
//
//	public String getBuisnessType() {
//		return businessType;
//	}
//
//	public void setBuisnessType(String buisnessType) {
//		this.buinessType = buisnessType;
//	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "CategoryDto [pkCategoryId=" + pkCategoryId + ", categoryName=" + categoryName + ", fkShopId=" + fkShopId
				+ ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
				+ ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName
				+ ", businessType=" + businessType + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}
	
	

//	@Override
//	public String toString() {
//		return "CategoryDto [pkCategoryId=" + pkCategoryId + ", categoryName=" + categoryName + ", fkShopId=" + fkShopId
//				+ ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
//				+ ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName
//				+ ", buisnessType=" + buisnessType + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
//	}

//	@Override
//	public String toString() {
//		return "CategoryDto [pkCategoryId=" + pkCategoryId + ", categoryName=" + categoryName + ", fkShopId=" + fkShopId
//				+ ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
//				+ ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName + ", createdBy="
//				+ createdBy + ", createdDate=" + createdDate + "]";
//	}

	
	
	
	
	
	
}
