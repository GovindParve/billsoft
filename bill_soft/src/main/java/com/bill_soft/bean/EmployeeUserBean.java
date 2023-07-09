package com.bill_soft.bean;

public class EmployeeUserBean {

	private Long pkEmployeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private String userName;
	
	public EmployeeUserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeUserBean(Long pkEmployeeId, String firstName, String lastName, String emailId, String contactNumber,
			String userName) {
		super();
		this.pkEmployeeId = pkEmployeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.userName = userName;
	}

	public Long getPkEmployeeId() {
		return pkEmployeeId;
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

	@Override
	public String toString() {
		return "EmployeeUserBean [pkEmployeeId=" + pkEmployeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", userName=" + userName + "]";
	}
	
	
	
}
