package com.bill_soft.bean;

import java.util.ArrayList;
import java.util.List;

import com.bill_soft.dto.LoginOrganizationDto;

public class LoginBean {
	private String token;
	private String refreshToken;
//	List<RequestPermissionDto> perList = new ArrayList<RequestPermissionDto>();
//	List<RequestEmployeeDto> perList1=new ArrayList<RequestEmployeeDto>();
	List<LoginOrganizationDto> perList2=new ArrayList<LoginOrganizationDto>();
	
	
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public LoginBean(String token, String refreshToken, List<RequestPermissionDto> perList,
//			List<RequestEmployeeDto> perList1) {
//		super();
//		this.token = token;
//		this.refreshToken = refreshToken;
//		this.perList = perList;
//		this.perList1 = perList1;
//	}
//
//
//	public LoginBean(String token, String refreshToken, List<RequestPermissionDto> perList,
//			List<RequestEmployeeDto> perList1, List<LoginOrganizationDto> perList2) {
//		super();
//		this.token = token;
//		this.refreshToken = refreshToken;
//		this.perList = perList;
//		this.perList1 = perList1;
//		this.perList2 = perList2;
//	}


	public String getToken() {
		return token;
	}


	public LoginBean(String token, String refreshToken, List<LoginOrganizationDto> perList2) {
	super();
	this.token = token;
	this.refreshToken = refreshToken;
	this.perList2 = perList2;
}


	public void setToken(String token) {
		this.token = token;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}


//	public List<RequestPermissionDto> getPerList() {
//		return perList;
//	}
//
//
//	public void setPerList(List<RequestPermissionDto> perList) {
//		this.perList = perList;
//	}
//
//
//	public List<RequestEmployeeDto> getPerList1() {
//		return perList1;
//	}
//
//
//	public void setPerList1(List<RequestEmployeeDto> perList1) {
//		this.perList1 = perList1;
//	}


	public List<LoginOrganizationDto> getPerList2() {
		return perList2;
	}


	public void setPerList2(List<LoginOrganizationDto> perList2) {
		this.perList2 = perList2;
	}
	
	
	
	
	
}
