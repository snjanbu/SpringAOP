package main.aop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.aop.dto.Triangle;
import main.aop.service.ShapeService;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		ShapeService shapeService=context.getBean("shapeService",ShapeService.class);
		System.out.println(shapeService.getTriangle().getName());
		shapeService.getCircle().setNameAndReturn("Type");
		shapeService.getTriangle().setNameAndException("New Triangle");
	}

}
