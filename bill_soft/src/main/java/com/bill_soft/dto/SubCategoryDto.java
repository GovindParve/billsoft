package com.bill_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SubCategoryDto {
	private Long pkSubCategoryId;
	private String subCategoryName;
	private Long fkCategoryId;
	private String categoryName;
	private Long fkAdminId;
	private String adminName;
	private Long fkShopId;
	private Long fkOragnizationId;
	private String organizationName;
	private String shopName;
	private String businessType;
	private String createdDate;
	private String createBy;

}
