package com.seomoon.movieApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

}
