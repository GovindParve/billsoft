package com.bill_soft.dto;

public class RequestPermissionDto {
	
	private Long pk_id;

	private String firstname;
	private String lastname;
	private String username;
	private String role;
	private String businessType;
	
	private Long fkOrganizationId;
	private String organizationName;
	
	public RequestPermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RequestPermissionDto(Long pk_id, String firstname, String lastname, String username, String role) {
		super();
		this.pk_id = pk_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.role = role;
	}

	

	public Long getPk_id() {
		return pk_id;
	}


	public RequestPermissionDto(Long pk_id, String firstname, String lastname, String username, String role,
		String businessType) {
	super();
	this.pk_id = pk_id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.role = role;
	this.businessType = businessType;
}


//	public RequestPermissionDto(Long pk_id, String firstname, String lastname, String username, String role,
//			String businessType, Long fkAdminId, String adminName) {
//		super();
//		this.pk_id = pk_id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.username = username;
//		this.role = role;
//		this.businessType = businessType;
//		this.fkAdminId = fkAdminId;
//		this.adminName = adminName;
//	}


//	public RequestPermissionDto(Long pk_id, String firstname, String lastname, String username, String role,
//			String businessType, Long fkAdminId, String adminName, Long fkOrganizationId, String organizationName) {
//		super();
//		this.pk_id = pk_id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.username = username;
//		this.role = role;
//		this.businessType = businessType;
//		
//		this.fkOrganizationId = fkOrganizationId;
//		this.organizationName = organizationName;
//	}


	public String getBusinessType() {
		return businessType;
	}


	public RequestPermissionDto(Long pk_id, String firstname, String lastname, String username, String role,
		String businessType, Long fkOrganizationId, String organizationName) {
	super();
	this.pk_id = pk_id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.role = role;
	this.businessType = businessType;
	this.fkOrganizationId = fkOrganizationId;
	this.organizationName = organizationName;
}


	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}


	public void setPk_id(Long pk_id) {
		this.pk_id = pk_id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


//	public Long getFkAdminId() {
//		return fkAdminId;
//	}
//
//
//	public void setFkAdminId(Long fkAdminId) {
//		this.fkAdminId = fkAdminId;
//	}
//
//
//	public String getAdminName() {
//		return adminName;
//	}
//
//
//	public void setAdminName(String adminName) {
//		this.adminName = adminName;
//	}


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


	@Override
	public String toString() {
		return "RequestPermissionDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", role=" + role + ", businessType=" + businessType + ", fkOrganizationId="
				+ fkOrganizationId + ", organizationName=" + organizationName + "]";
	}


//	@Override
//	public String toString() {
//		return "RequestPermissionDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
//				+ ", username=" + username + ", role=" + role + ", businessType=" + businessType + ", fkAdminId="
//				+ fkAdminId + ", adminName=" + adminName + ", fkOrganizationId=" + fkOrganizationId
//				+ ", organizationName=" + organizationName + "]";
//	}


//	@Override
//	public String toString() {
//		return "RequestPermissionDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
//				+ ", username=" + username + ", role=" + role + ", businessType=" + businessType + ", fkAdminId="
//				+ fkAdminId + ", adminName=" + adminName + "]";
//	}


//	@Override
//	public String toString() {
//		return "RequestPermissionDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
//				+ ", username=" + username + ", role=" + role + ", businessType=" + businessType + "]";
//	}


//	@Override
//	public String toString() {
//		return "RequestPermissionDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
//				+ ", username=" + username + ", role=" + role + "]";
//	}


  
	

}
