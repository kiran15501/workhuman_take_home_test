package com.search.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.search.country")
public class WorkHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkHumanApplication.class, args);
	}

}
