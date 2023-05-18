package com.example.Ejercicio5;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Clase1 {

    @PostConstruct
    public void saludo() {
        System.out.println("Hola desde la clase inicial");
    }

}
