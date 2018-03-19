package com.oauth.resource.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private  int resourceId;
	
	public ResourceNotFoundException(String resourceName, int resourceId) {
      this.resourceName = resourceName;
      this.resourceId = resourceId;
    }
	
	public ResourceNotFoundException() {	
		super();
	}
	
	public ResourceNotFoundException(String resourceName) {	
		this.resourceName = resourceName;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public int getResourceId() {
		return resourceId;
	}
	
}
