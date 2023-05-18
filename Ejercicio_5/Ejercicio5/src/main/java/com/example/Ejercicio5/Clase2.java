package com.example.Ejercicio5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Clase2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde la clase secundaria");
    }
}
