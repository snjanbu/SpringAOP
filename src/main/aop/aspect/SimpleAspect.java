package main.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("@annotation(main.aop.annotation.Loggable)")
	public Object aroundImplementation(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue=null;
		try {
			System.out.println("Before Proceeding");
			returnValue=proceedingJoinPoint.proceed();
			System.out.println("After Proceeding");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("Catching Exception");
		}
		System.out.println("Completed Around");
		return returnValue;
	}
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}
	
	@Pointcut("within(main.aop.dto.Triangle)")
	public void allTriangleMethods() {}

}
