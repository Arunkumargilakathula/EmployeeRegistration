package com.tcl.customeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tcl.model.ErrorResponse;

@ControllerAdvice
public class ResponseEntityHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ExceptionalHandler.class)
	public ResponseEntity<ErrorResponse> customeException(ExceptionalHandler exceptionHandler) {
		return new ResponseEntity<>(new ErrorResponse().builder().messsage(exceptionHandler.getMessage())
				.statusCode(exceptionHandler.getStatusCode()).build(), HttpStatus.OK);

	}

}
