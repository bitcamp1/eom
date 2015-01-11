package com.eom.web.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*@Aspect
public class LogAspect {
	
	@Before("execution (* *..service.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println(">>>>> logBefore()...");
		System.out.println("호출할 메서드:" + 
					joinPoint.getSignature().getName());
	}
	
	@After("execution (* *..service.*.*(..))")
	public void logAfter() {
		System.out.println(">>>>> logAfter()...");
	}
	
	@AfterReturning("execution (* *..service.*.*(..))")
	public void logAfterReturning() {
		System.out.println(">>>>> logAfterReturning()...");
	}
}
*/