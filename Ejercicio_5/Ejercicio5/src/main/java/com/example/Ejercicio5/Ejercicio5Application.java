package com.example.Ejercicio5;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio5Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ejercicio5Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5Application.class, args);

		LOGGER.error("Esto es un mensaje de error"); // Log de nivel "ERROR"
		LOGGER.warn("Esto es un mensaje de advertencia"); // Log de nivel "WARNING"
		LOGGER.info("Esto es un mensaje informativo"); // Log de nivel "INFO"
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");

	}

}
