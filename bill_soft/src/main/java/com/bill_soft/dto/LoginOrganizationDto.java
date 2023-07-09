package com.bill_soft.dto;

import java.util.List;

public class LoginOrganizationDto {
	
	private Long pk_id;

	private String firstname;
	private String lastname;
	private String username;
	private String role;
	//private List<String> businessType;
	private List<String> buisnessType;
	private Long fkOrganizationId;
	private String organizationName;
	private Long fkAdminId;
	private String adminName;
	public LoginOrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public LoginOrganizationDto(Long pk_id, String firstname, String lastname, String username, String role,
			List<String> buisnessType, Long fkOrganizationId, String organizationName) {
		super();
		this.pk_id = pk_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.role = role;
		this.buisnessType = buisnessType;
		this.fkOrganizationId = fkOrganizationId;
		this.organizationName = organizationName;
	}



	public LoginOrganizationDto(Long pk_id, String firstname, String lastname, String username, String role,
			List<String> buisnessType, Long fkOrganizationId, String organizationName, Long fkAdminId,
			String adminName) {
		super();
		this.pk_id = pk_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.role = role;
		this.buisnessType = buisnessType;
		this.fkOrganizationId = fkOrganizationId;
		this.organizationName = organizationName;
		this.fkAdminId = fkAdminId;
		this.adminName = adminName;
	}



	public Long getPk_id() {
		return pk_id;
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



//	public String getBuisnessType() {
//		return buisnessType;
//	}
//
//
//
//	public void setBuisnessType(String buisnessType) {
//		this.buisnessType = buisnessType;
//	}



//	public LoginOrganizationDto(Long pk_id, String firstname, String lastname, String username, String role,
//			String buisnessType) {
//		super();
//		this.pk_id = pk_id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.username = username;
//		this.role = role;
//		this.buisnessType = buisnessType;
//	}



	public List<String> getBuisnessType() {
		return buisnessType;
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



	public LoginOrganizationDto(Long pk_id, String firstname, String lastname, String username, String role,
		List<String> buisnessType) {
	super();
	this.pk_id = pk_id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.role = role;
	this.buisnessType = buisnessType;
}


//
//	@Override
//	public String toString() {
//		return "LoginOrganizationDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
//				+ ", username=" + username + ", role=" + role + ", buisnessType=" + buisnessType + ", fkOrganizationId="
//				+ fkOrganizationId + ", organizationName=" + organizationName + "]";
//	}
//


	public void setBuisnessType(List<String> buisnessType) {
		this.buisnessType = buisnessType;
	}



	@Override
	public String toString() {
		return "LoginOrganizationDto [pk_id=" + pk_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", role=" + role + ", buisnessType=" + buisnessType + ", fkOrganizationId="
				+ fkOrganizationId + ", organizationName=" + organizationName + ", fkAdminId=" + fkAdminId
				+ ", adminName=" + adminName + "]";
	}

	
	

}
