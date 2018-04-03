package com.spring.web.javaConfig.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//控制器通知(Spring3.2之后引入)
@ControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler(){
		return "error/duplicate";
	}
}
