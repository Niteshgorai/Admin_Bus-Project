package org.jpa.AdminBusApp.exception;

import org.jpa.AdminBusApp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	
	ResponseStructure<String> structure= new ResponseStructure<>();
	
@ExceptionHandler(AdminNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> handleANFE(AdminNotFoundException exception){
	structure.setData("Cannot find Admin");
	structure.setMessage(exception.getMessage());
	structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(BusNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> handleBNFE(BusNotFoundException exception){
	structure.setData("Cannot find Bus");
	structure.setMessage(exception.getMessage());
	structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
}

}
