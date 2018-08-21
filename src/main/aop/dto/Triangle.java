package main.aop.dto;

import main.aop.annotation.Loggable;

public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Method execution in Setter");
	}
	
	@Loggable
	public void setNameAndException(String name) {
		this.name=name;
		throw(new RuntimeException());
	}

}
