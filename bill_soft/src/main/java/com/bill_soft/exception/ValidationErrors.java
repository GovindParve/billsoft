package com.bill_soft.exception;

public class ValidationErrors {
	
	public final String feildName;
	public final String message;
	public ValidationErrors(String feildName, String message) {
		super();
		this.feildName = feildName;
		this.message = message;
	}
	public String getFeildName() {
		return feildName;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "ValidationErrors [feildName=" + feildName + ", message=" + message + "]";
	}
	
	
	
	

}
