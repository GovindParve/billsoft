package com.bill_soft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "employee_details")
public class EmployeeUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkEmployeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "fk_admin_id")
	private Long fkAdminId;

	@Column(name="admin_name")
	private String adminName;
	
	@Column(name = "fk_oragnization_id")
	private Long fkOragnizationId;
	
	@Column(name="oragnization_name")
	private String oragnizationName;

	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "refresh_token")
	private String refreshToken;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name="login_time")
	private String loginTime;
	
}
