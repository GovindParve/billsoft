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
@Table(name="supplier_details")
public class SupplierDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pkSuppplierId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="alternate_number")
	private String alternateNumber;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Column(name="gst_or_tin_no")
	private String gstNo;
	
	@Column(name="account_holder_name")
	private String accountHolderName;
	
	@Column(name="account_no")
	private String accountNumber;
	
	@Column(name="ifsc_no")
	private String ifscNo;
	
	@Column(name="upi_id")
	private String upiId;
	
	@Column(name="opening_balance")
	private String openingBalane;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="fk_shop_id")
	private Long fkShopId;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="fk_admin_id")
	private Long fkAdminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="fk_oragnization_id")
	private Long fkoragnizationId;
	
	@Column(name="oragnization_name")
	private String oragnizationName;

	
}
