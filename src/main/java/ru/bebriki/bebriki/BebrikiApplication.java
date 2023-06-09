package ru.bebriki.bebriki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BebrikiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BebrikiApplication.class, args);
	}
}
