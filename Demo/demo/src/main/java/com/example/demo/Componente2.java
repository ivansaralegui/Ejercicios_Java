package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Componente2 {
    Componente1 comp1;

    public Componente2() {
        System.out.println("Iniciando componente 2");
    }

    public String saluda() {
    if (comp1 == null) {
        return "Componente1 es nulo";
    } else {
        return "Hola desde Componente 2\n"+comp1.saluda();
    }
    }

}
