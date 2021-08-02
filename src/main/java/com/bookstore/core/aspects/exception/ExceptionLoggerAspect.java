package com.bookstore.core.aspects.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggerAspect {

	
	@AfterThrowing(pointcut="execution(* com.bookstore.business.*.*(..)) || execution(* com.bookstore.repository.*.*(..)) || execution(* com.bookstore.api.controllers.*.*(..))",throwing="ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex)  
	{  
	System.out.println("After Throwing exception in method:"+joinPoint.getSignature());  
	System.out.println("Exception is:"+ex.getMessage());  
	}     
}
