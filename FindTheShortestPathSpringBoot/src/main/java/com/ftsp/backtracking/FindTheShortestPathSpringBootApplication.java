package com.ftsp.backtracking;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FindTheShortestPathSpringBootApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(FindTheShortestPathSpringBootApplication.class);
		builder.headless(false)
			   .run(args);
	}
}
