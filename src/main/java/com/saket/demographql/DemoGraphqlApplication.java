package com.saket.demographql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.saket.demographql.entity")
public class DemoGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphqlApplication.class, args);
	}

}
