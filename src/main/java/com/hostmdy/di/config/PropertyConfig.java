package com.hostmdy.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.hostmdy.di.datasource.CloudDataSource;
import com.hostmdy.di.datasource.FakeDataSource;

@Configuration
//@PropertySource({"mysql_config.properties","oracle_config.properties"})
@PropertySources({
	@PropertySource("mysql_config.properties"),
	@PropertySource("oracle_config.properties")
})
public class PropertyConfig {
	@Autowired
	Environment env;
	
	@Value("${mysql.username}")
	String username;
	
	@Value("${mysql.password}")
	String password;
	
	@Value("${mysql.url}")
	String url;
	
	@Value("${mysql.engine}")
	String engine;
	
	@Bean
	FakeDataSource fakeDataSource() {
		return new FakeDataSource(env.getProperty("username"), env.getProperty("password"), url, engine);
	}
	
	@Bean
	CloudDataSource cloudDataSource() {
		return new CloudDataSource(env.getProperty("cloud.user"), env.getProperty("cloud.key"), env.getProperty("cloud.auth"), env.getProperty("cloud.address"));
	}
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	

}
