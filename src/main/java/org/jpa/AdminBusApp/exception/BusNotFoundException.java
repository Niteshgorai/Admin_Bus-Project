package org.jpa.AdminBusApp.exception;

public class BusNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

  @Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "Bus not found";
}
	
}
