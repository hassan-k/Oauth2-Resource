package com.oauth.resource.domain;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.validation.FieldError;

/**
 * Multiple errors container
 */
@SuppressWarnings("unused")
public class ErrorModel {

	private final String code;	
	private final String message;

	public ErrorModel(String code, String message) {
		this.code = code;		
		this.message = message;
	}

	public ErrorModel(FieldError fieldError) {
		this.code = fieldError.getCode();		
		this.message = fieldError.getDefaultMessage();
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
