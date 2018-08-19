package main.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {
	
	@Before("execution(public String getName())")
	public void getLoggingAspect() {
		System.out.println("Method Execution Starts");
	}

}
