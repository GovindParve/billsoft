package com.bill_soft.dto;

public class RequestUserDetailsDto {
	private Long pkid;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private String userName;
	private String password;
	private String role;
	private String status;
	private String validityDate;
	private Long fkAdminId;
	private Long fkOrganizationId;
	private String resetPasswordToken;
	private Long fkShopId;
	private String accessToken;
	private String refreshToken;

	public RequestUserDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPkid() {
		return pkid;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}

	public RequestUserDetailsDto(Long pkid, String firstName, String lastName, String emailId, String contactNumber,
		String userName, String password, String role, String status, String validityDate, Long fkAdminId,
		Long fkOrganizationId, String resetPasswordToken, Long fkShopId, String accessToken, String refreshToken) {
	super();
	this.pkid = pkid;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.contactNumber = contactNumber;
	this.userName = userName;
	this.password = password;
	this.role = role;
	this.status = status;
	this.validityDate = validityDate;
	this.fkAdminId = fkAdminId;
	this.fkOrganizationId = fkOrganizationId;
	this.resetPasswordToken = resetPasswordToken;
	this.fkShopId = fkShopId;
	this.accessToken = accessToken;
	this.refreshToken = refreshToken;
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

	public Long getFkOrganizationId() {
		return fkOrganizationId;
	}

	public void setFkOrganizationId(Long fkOrganizationId) {
		this.fkOrganizationId = fkOrganizationId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}

	public Long getFkShopId() {
		return fkShopId;
	}

	public void setFkShopId(Long fkShopId) {
		this.fkShopId = fkShopId;
	}

	@Override
	public String toString() {
		return "RequestUserDetailsDto [pkid=" + pkid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", userName=" + userName + ", password="
				+ password + ", role=" + role + ", status=" + status + ", validityDate=" + validityDate + ", fkAdminId="
				+ fkAdminId + ", fkOrganizationId=" + fkOrganizationId + ", resetPasswordToken=" + resetPasswordToken
				+ ", fkShopId=" + fkShopId + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}

	

}
