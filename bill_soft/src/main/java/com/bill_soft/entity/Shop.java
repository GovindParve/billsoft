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
@Table(name = "shop_details")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_shop_id")
	private Long pkShopId;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "shop_address")
	private String shopAddress;

	@Column(name = "shop_registration_date")
	private String shopRegistrationDate;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "city")
	private String city;
	
	@Column(name = "fk_organization_id")
	private Long fkOrganizationId;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "fk_admin_id")
	private Long fkAdminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name="business_type")
	private String businessType;
	
	@Column(name = "shop_logo")
	private String ShopLogo;

	
}
