package org.jpa.AdminBusApp.dto;


public class ResponseStructure<T> {
 private String message;
 private T data;
 private int StatusCode;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public int getStatusCode() {
	return StatusCode;
}
public void setStatusCode(int statusCode) {
	StatusCode = statusCode;
}
 
 
 
	
}
