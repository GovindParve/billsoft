package com.bill_soft.dto;

public class GodownDto {

	private Long pkGodownId;
	private String godownName;
	private Long fkShopId;
	private String shopName;
	private Long fkAdminId;
	private Long fkOrganizationId;
	private String createdDate;
	private String createdBy;

	public GodownDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GodownDto(Long pkGodownId, String godownName, Long fkShopId, String shopName, Long fkAdminId,
			Long fkOrganizationId, String createdDate, String createdBy) {
		super();
		this.pkGodownId = pkGodownId;
		this.godownName = godownName;
		this.fkShopId = fkShopId;
		this.shopName = shopName;
		this.fkAdminId = fkAdminId;
		this.fkOrganizationId = fkOrganizationId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}


	public Long getPkGodownId() {
		return pkGodownId;
	}

	public void setPkGodownId(Long pkGodownEntryId) {
		this.pkGodownId = pkGodownEntryId;
	}

	public String getGodownName() {
		return godownName;
	}

	public void setGodownName(String godownName) {
		this.godownName = godownName;
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

	public Long getFkOrganizationId() {
		return fkOrganizationId;
	}

	public void setFkOrganizationId(Long fkOrganizationId) {
		this.fkOrganizationId = fkOrganizationId;
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


	@Override
	public String toString() {
		return "GodownDto [pkGodownId=" + pkGodownId + ", godownName=" + godownName + ", fkShopId=" + fkShopId
				+ ", shopName=" + shopName + ", fkAdminId=" + fkAdminId + ", fkOrganizationId=" + fkOrganizationId
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + "]";
	}


	

}
