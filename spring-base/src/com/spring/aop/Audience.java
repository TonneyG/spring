package com.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
	@Pointcut("execution(* com.spring.aop.Performance.perform(..))")
	public void performance(){}
	
	@Before("performance()")
	public void silenceCellPhones(){
		System.out.println("手机静音");
	}
	
	@Before("performance()")
	public void takeSeats(){
		System.out.println("入座");
	}
	
	@AfterReturning("performance()")
	public void applause(){
		System.out.println("鼓掌啪啪啪");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("WTF?!我要退票");
	}
}
