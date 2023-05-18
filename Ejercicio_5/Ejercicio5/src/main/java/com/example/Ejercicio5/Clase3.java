package com.example.Ejercicio5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Clase3 implements CommandLineRunner {

    @Value("${C3.nombre}")
    private String nombre;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase: " + nombre);
    }
}
