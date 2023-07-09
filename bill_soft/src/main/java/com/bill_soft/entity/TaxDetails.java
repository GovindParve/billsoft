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
@Table(name="tax_details")
public class TaxDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long pkTaxId;
	
	@Column(name="tax_name")
	private String taxName;

	@Column(name="percentage")
	private String percentage;
	
	@Column(name="cgst")
	private String cgst;
	
	@Column(name="sgst")
	private String sgst;
	
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
	
	@Column(name="business_type")
	private String businessType;
	

	
}
