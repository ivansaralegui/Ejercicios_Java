package com.example.Ejercicio5_Perfiles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Ejercicio5PerfilesApplication implements CommandLineRunner {

	@Value("${spring.profiles.active}")
	private String name;

	@Value("${bd.url}")
	private String environment;

	public static void main(String[] args) {

		SpringApplication.run(Ejercicio5PerfilesApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		log.info("My app name: {}. Environment: {}", name, environment);
	}
}
