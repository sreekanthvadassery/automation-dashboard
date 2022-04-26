package com.company.dashboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220425
 * Exception class : ResourceNotFound
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
