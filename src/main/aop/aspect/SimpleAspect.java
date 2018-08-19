package main.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {
	
	@Before("allGetters()")
	public void getLoggingAspect() {
		System.out.println("Method Execution Starts");
	}
	
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}

}
