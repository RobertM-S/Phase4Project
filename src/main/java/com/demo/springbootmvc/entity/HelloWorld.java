package com.demo.springbootmvc.entity;

public class HelloWorld {

	private String message;
	private String dateTime;
	
	public HelloWorld() {
		
	}
	
	public HelloWorld(String message, String dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
