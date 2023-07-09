package com.bill_soft.bean;

public class CategoryWiseStockBean {

	private Long srNo;
	private String categoryName;
	private String productName;
	private Double AvailableQuantity;
	private  String Date;
	
	public CategoryWiseStockBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryWiseStockBean(Long srNo, String categoryName, String productName, Double availableQuantity,
			String date) {
		super();
		this.srNo = srNo;
		this.categoryName = categoryName;
		this.productName = productName;
		AvailableQuantity = availableQuantity;
		Date = date;
	}

	public Long getSrNo() {
		return srNo;
	}

	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getAvailableQuantity() {
		return AvailableQuantity;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		AvailableQuantity = availableQuantity;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "CategoryWiseStockBean [srNo=" + srNo + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", AvailableQuantity=" + AvailableQuantity + ", Date=" + Date + "]";
	}
	
	
	
	
}
