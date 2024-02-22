package com.banking.exceptions;

import java.util.Date;

public class MyErrorResponse {
	private String message;
	private String errorcode;
	private Date time;
	public MyErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	public MyErrorResponse(String message, String errorcode, Date time) {
		super();
		this.message = message;
		this.errorcode = errorcode;
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
