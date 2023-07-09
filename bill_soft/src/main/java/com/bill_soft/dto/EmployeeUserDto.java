package com.bill_soft.dto;

public class EmployeeUserDto {

	private Long pkEmployeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private String userName;
	private String password;
	private String role;
	private Long fkAdminId;
	private String adminName;
	private Long fkOragnizationId;
	private String oragnizationName;
	private String createdDate;
	private String createdBy;
	private String resetPasswordToken;
	private String accessToken;
	private String refreshToken;

	public EmployeeUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public EmployeeUserDto(Long pkEmployeeId, String firstName, String lastName, String emailId, String contactNumber,
//			String userName, String password, String role, Long fkAdminId, Long fkOragnizationId, String createdDate,
//			String createdBy, String resetPasswordToken, String accessToken, String refreshToken) {
//		super();
//		this.pkEmployeeId = pkEmployeeId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.emailId = emailId;
//		this.contactNumber = contactNumber;
//		this.userName = userName;
//		this.password = password;
//		this.role = role;
//		this.fkAdminId = fkAdminId;
//		this.fkOragnizationId = fkOragnizationId;
//		this.createdDate = createdDate;
//		this.createdBy = createdBy;
//		this.resetPasswordToken = resetPasswordToken;
//		this.accessToken = accessToken;
//		this.refreshToken = refreshToken;
//	}

	
	public Long getPkEmployeeId() {
		return pkEmployeeId;
	}

	public EmployeeUserDto(Long pkEmployeeId, String firstName, String lastName, String emailId, String contactNumber,
		String userName, String password, String role, Long fkAdminId, String adminName, Long fkOragnizationId,
		String oragnizationName, String createdDate, String createdBy, String resetPasswordToken, String accessToken,
		String refreshToken) {
	super();
	this.pkEmployeeId = pkEmployeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.contactNumber = contactNumber;
	this.userName = userName;
	this.password = password;
	this.role = role;
	this.fkAdminId = fkAdminId;
	this.adminName = adminName;
	this.fkOragnizationId = fkOragnizationId;
	this.oragnizationName = oragnizationName;
	this.createdDate = createdDate;
	this.createdBy = createdBy;
	this.resetPasswordToken = resetPasswordToken;
	this.accessToken = accessToken;
	this.refreshToken = refreshToken;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getFkAdminId() {
		return fkAdminId;
	}

	public void setFkAdminId(Long fkAdminId) {
		this.fkAdminId = fkAdminId;
	}

	public Long getFkOragnizationId() {
		return fkOragnizationId;
	}

	public void setFkOragnizationId(Long fkOragnizationId) {
		this.fkOragnizationId = fkOragnizationId;
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

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getOragnizationName() {
		return oragnizationName;
	}

	public void setOragnizationName(String oragnizationName) {
		this.oragnizationName = oragnizationName;
	}

	@Override
	public String toString() {
		return "EmployeeUserDto [pkEmployeeId=" + pkEmployeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", userName=" + userName + ", password="
				+ password + ", role=" + role + ", fkAdminId=" + fkAdminId + ", adminName=" + adminName
				+ ", fkOragnizationId=" + fkOragnizationId + ", oragnizationName=" + oragnizationName + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", resetPasswordToken=" + resetPasswordToken
				+ ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}

//	@Override
//	public String toString() {
//		return "EmployeeUserDto [pkEmployeeId=" + pkEmployeeId + ", firstName=" + firstName + ", lastName=" + lastName
//				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", userName=" + userName + ", password="
//				+ password + ", role=" + role + ", fkAdminId=" + fkAdminId + ", fkOragnizationId=" + fkOragnizationId
//				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", resetPasswordToken="
//				+ resetPasswordToken + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
//	}
	

}
