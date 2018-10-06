package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.test.restcontroller" })
@EnableJpaRepositories(basePackages = { "com.test.dao" })
@EntityScan(basePackages = {"com.test.entity"})
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class,  args);
	}
}
