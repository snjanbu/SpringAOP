package main.aop.controller;

import main.aop.bean.FactoryBean;
import main.aop.dto.Circle;

public class ProxyController {
	
	public static void main(String args[]) {

		FactoryBean factoryBean=new FactoryBean();
		Circle circle=(Circle)factoryBean.returnBean("circle");
		circle.setName("New Circle");
		System.out.println(circle.getName());
	}
	

}
