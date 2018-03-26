package com.spring.aop.declareParents;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EncoreableIntroducer {
	@DeclareParents(value="com.spring.aop.Performance",defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;
}
