package com.bill_soft.dto;

public class TaxDto {
	private Long pkTaxId;
	private String taxName;
	private String percentage;
	private String cgst;
	private String sgst;
	private String createdDate;
	private String createdBy;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private String adminName;
	private Long fkoragnizationId;
	private String oragnizationName;
	private String businessType;
	
	public TaxDto() {
		super();
		
	}

//	public TaxDto(Long pkTaxId, String taxName, String percentage, String cgst, String sgst, String createdDate,
//			String createdBy, Long fkShopId, String shopName, Long fkAdminId, String adminName, Long fkoragnizationId,
//			String oragnizationName) {
//		super();
//		this.pkTaxId = pkTaxId;
//		this.taxName = taxName;
//		this.percentage = percentage;
//		this.cgst = cgst;
//		this.sgst = sgst;
//		this.createdDate = createdDate;
//		this.createdBy = createdBy;
//		this.fkShopId = fkShopId;
//		this.shopName = shopName;
//		this.fkAdminId = fkAdminId;
//		this.adminName = adminName;
//		this.fkoragnizationId = fkoragnizationId;
//		this.oragnizationName = oragnizationName;
//	}

	
	public Long getPkTaxId() {
		return pkTaxId;
	}

	public TaxDto(Long pkTaxId, String taxName, String percentage, String cgst, String sgst, String createdDate,
		String createdBy, Long fkShopId, String shopName, Long fkAdminId, String adminName, Long fkoragnizationId,
		String oragnizationName, String businessType) {
	super();
	this.pkTaxId = pkTaxId;
	this.taxName = taxName;
	this.percentage = percentage;
	this.cgst = cgst;
	this.sgst = sgst;
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

	public void setPkTaxId(Long pkTaxId) {
		this.pkTaxId = pkTaxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
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

	public void setBusisnessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "TaxDto [pkTaxId=" + pkTaxId + ", taxName=" + taxName + ", percentage=" + percentage + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", fkShopId="
				+ fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
				+ ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName
				+ ", businessType=" + businessType + "]";
	}

//	@Override
//	public String toString() {
//		return "TaxDto [pkTaxId=" + pkTaxId + ", taxName=" + taxName + ", percentage=" + percentage + ", cgst=" + cgst
//				+ ", sgst=" + sgst + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", fkShopId="
//				+ fkShopId + ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
//				+ ", fkoragnizationId=" + fkoragnizationId + ", oragnizationName=" + oragnizationName + "]";
//	}

	

}
