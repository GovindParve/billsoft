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
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pkid;

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
	
	@Column(name="status")
	private String status;
	
	@Column(name="validity_date")
	private String validityDate;
	
	@Column(name="fk_organization_id")
	private Long fkOrganizationId;
	
	@Column(name="fk_admin_id")
	private Long fkAdminId;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private String createdDate;

	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "refresh_token")
	private String refreshToken;

	@Column(name="fk_shop_id")
	private Long fkShopId;
	
	@Column(name="login_time")
	private String loginTime;
	
}
