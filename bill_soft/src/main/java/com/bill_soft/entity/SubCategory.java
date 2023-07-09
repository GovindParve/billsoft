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
@Table(name="subcategory_details")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_subcategory_id")
	private Long pkSubCategoryId;
	
	@Column(name="subcategory_name")
	private String subCategoryName;
	
	@Column(name="fk_category_id")
	private Long fkCategoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="fk_admin_id")
	private Long fkAdminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="fk_shop_id")
	private Long fkShopId;
	
	@Column(name="fk_oragnization_id")
	private Long fkOragnizationId;
	
	@Column(name="oragnization_name")
	private String oragnizationName;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="business_type")
	private String businessType;
	
    @Column(name="created_date")
    private String createdDate;
   
    @Column(name="created_by")
    private String createBy;
	
 
}
