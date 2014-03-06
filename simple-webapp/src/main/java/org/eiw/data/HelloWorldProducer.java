package org.eiw.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@RequestScoped
public class HelloWorldProducer {
	private String message;
	
	@Named
	@Produces
	public String getMessage() {
		return message;
	}
	
	@PostConstruct
	public void initMessage() {
		System.out.println("s<dfdsf");
		message = "Hello world !";
	}
}
