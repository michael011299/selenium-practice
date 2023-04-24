package com.qa.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No cat found with that id")
public class CatNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7282969538187154540L;

}
