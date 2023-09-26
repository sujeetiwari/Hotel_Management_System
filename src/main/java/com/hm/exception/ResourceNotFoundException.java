package com.hm.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName; // hotel,customer,staff
	private String fieldName; // id,email,name
	private Object fieldObject; // 99,..@gmail.com
	
//	hotel not found with id:'99'
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldObject) {
		super(String.format("%s not found with %s:'%s'",resourceName,fieldName,fieldObject));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldObject = fieldObject;
	}
}
