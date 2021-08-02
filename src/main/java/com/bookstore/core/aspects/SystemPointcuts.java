package com.bookstore.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class SystemPointcuts {
	@Pointcut("execution(* com.bookstore.business.concretes.*.get*(..))")
	private void globalConcretesAspects () {}
	
	@Pointcut("execution(* com.bookstore.business.concretes.BookManager.get*(..))")
	private void bookManagerGetAspects () {}
	
	@Pointcut("execution(* com.bookstore.business.concretes.BookManager.getAll(..))")
	private void bookManagerGetAllAspect() {}
	
	@Pointcut("within(com.bookstore.business..*)")
	private void businessLayer() {
		
	}
	
}
