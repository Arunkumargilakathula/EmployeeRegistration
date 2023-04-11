package com.tcl.customeException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionalHandler extends RuntimeException {

	private String statusCode;

	public ExceptionalHandler(String message, String statusCode) {

		super(message);
		this.statusCode = statusCode;
	}

}
