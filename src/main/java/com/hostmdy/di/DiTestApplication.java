package com.hostmdy.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hostmdy.di.controller.GreetingController;

@SpringBootApplication
public class DiTestApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DiTestApplication.class, args);
		
		//GreetingController controller =(GreetingController) context.getBean("greetingController");
		GreetingController controller=context.getBean(GreetingController.class);
		System.out.println(controller.sayHello());
		
	}

}
