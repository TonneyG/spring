package com.spring.web.javaConfig.exception;

public class DuplicateSpittleException extends RuntimeException{

	public DuplicateSpittleException() {
	}

	public DuplicateSpittleException(String message) {
		super(message);
	}
	
}
