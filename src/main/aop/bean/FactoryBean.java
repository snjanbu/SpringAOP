package main.aop.bean;

import main.aop.dto.Circle;

public class FactoryBean {
	
	public Object returnBean(String beanName) {
		if(beanName.equals("circle")) {
			return new Circle();
		}
		return null;
	}

}
