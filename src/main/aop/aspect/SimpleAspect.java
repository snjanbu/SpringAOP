package main.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {
	
	@Before("allGetters() && allTriangleMethods()")
	public void getLoggingAspect(JoinPoint joinPoint) {
		System.out.println("Method Execution Starts "+joinPoint.getTarget());
	}
	
	@After("args(name)")
	public void printAfter(String name) {
		System.out.println("After Method");
	}
	
	@AfterThrowing(pointcut="args(name)",throwing="exception")
	public void afterThrowingException(String name,Exception exception) {
		System.out.println("Method name is: " +name+" with Exception "+exception);
	}
	
	@AfterReturning(pointcut="args(name)",returning="returnName")
	public void afterThrowingException(String name,String returnName) {
		System.out.println("Method name is: " +name+" with returnName "+returnName);
	}
	
	@Before("allTriangleMethods() && args(name)")
	public void printArgument(String name) {
		System.out.println(name);
	}
	
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}
	
	@Pointcut("within(main.aop.dto.Triangle)")
	public void allTriangleMethods() {}

}
