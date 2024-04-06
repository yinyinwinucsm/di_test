package com.hostmdy.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hostmdy.di.controller.GreetingController;
import com.hostmdy.di.datasource.CloudDataSource;
import com.hostmdy.di.datasource.FakeDataSource;

@SpringBootApplication
public class DiTestApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DiTestApplication.class, args);
		
		FakeDataSource fakeDataSource=context.getBean(FakeDataSource.class);
		System.out.println("DataSource : ");
		System.out.println("username :" +fakeDataSource.getUsername());
		System.out.println("password :" +fakeDataSource.getPassword());
		System.out.println("url :" +fakeDataSource.getUrl());
		System.out.println("engine :" +fakeDataSource.getEngine());
		
		CloudDataSource cloudDataSource=context.getBean(CloudDataSource.class);
		System.out.println("Cloud Config :");
		System.out.println("user : " + cloudDataSource.getUser());
		System.out.println("key : " + cloudDataSource.getKey());
		System.out.println("auth : " + cloudDataSource.getAuth());
		System.out.println("address : " + cloudDataSource.getAddress());

	}

}
