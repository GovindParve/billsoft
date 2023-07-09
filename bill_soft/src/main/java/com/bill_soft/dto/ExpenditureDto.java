package com.bill_soft.dto;

public class ExpenditureDto {

	private Long pkExpenditureId;
	private String expenditureName;
	private String expenditureType;
	private String description;
	private Double expenditureAmount;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;

	public ExpenditureDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenditureDto(Long pkExpenditureId, String expenditureName, String expenditureType, String description,
			Double expenditureAmount, String createdDate, String createdBy, Long fkShopId, String shopName,
			Long fkAdminId, String adminName, Long fkoragnizationId, String oragnizationName) {
		super();
		this.pkExpenditureId = pkExpenditureId;
		this.expenditureName = expenditureName;
		this.expenditureType = expenditureType;
		this.description = description;
		this.expenditureAmount = expenditureAmount;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
		this.fkoragnizationId = fkoragnizationId;
		this.oragnizationName = oragnizationName;
	}

	public Long getPkExpenditureId() {
		return pkExpenditureId;
	}

	public void setPkExpenditureId(Long pkExpenditureId) {
		this.pkExpenditureId = pkExpenditureId;
	}

	public String getExpenditureName() {
		return expenditureName;
	}

	public void setExpenditureName(String expenditureName) {
		this.expenditureName = expenditureName;
	}

	public String getExpenditureType() {
		return expenditureType;
	}

	public void setExpenditureType(String expenditureType) {
		this.expenditureType = expenditureType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getExpenditureAmount() {
		return expenditureAmount;
	}

	public void setExpenditureAmount(Double expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
	}

	@Override
	public String toString() {
		return "ExpenditureDto [pkExpenditureId=" + pkExpenditureId + ", expenditureName=" + expenditureName
				+ ", expenditureType=" + expenditureType + ", description=" + description + ", expenditureAmount="
				+ expenditureAmount + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", fkShopId="
				+ fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
				+ ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName + "]";
	}

}
