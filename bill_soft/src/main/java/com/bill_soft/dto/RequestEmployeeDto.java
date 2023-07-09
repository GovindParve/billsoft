package com.bill_soft.dto;

public class RequestEmployeeDto {
	
	private Long pkEmployeeId;
	private String firstName;
	private String lastName;
	private String userName;
	private String role;
	private String buisnessType;
	
	public RequestEmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestEmployeeDto(Long pkEmployeeId, String firstName, String lastName, String userName, String role) {
		super();
		this.pkEmployeeId = pkEmployeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.role = role;
	}

	
	
	

	public Long getPkEmployeeId() {
		return pkEmployeeId;
	}

	public RequestEmployeeDto(Long pkEmployeeId, String firstName, String lastName, String userName, String role,
		String buisnessType) {
	super();
	this.pkEmployeeId = pkEmployeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.role = role;
	this.buisnessType = buisnessType;
}

	public void setPkEmployeeId(Long pkEmployeeId) {
		this.pkEmployeeId = pkEmployeeId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String getBuisnessType() {
		return buisnessType;
	}

	public void setBuisnessType(String buisnessType) {
		this.buisnessType = buisnessType;
	}

	@Override
	public String toString() {
		return "RequestEmployeeDto [pkEmployeeId=" + pkEmployeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userName=" + userName + ", role=" + role + ", buisnessType=" + buisnessType + "]";
	}

//	@Override
//	public String toString() {
//		return "RequestEmployeeDto [pkEmployeeId=" + pkEmployeeId + ", firstName=" + firstName + ", lastName="
//				+ lastName + ", userName=" + userName + ", role=" + role + "]";
//	}
	
	
	
	
	

}
