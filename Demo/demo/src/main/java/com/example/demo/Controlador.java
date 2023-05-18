package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    ComponenteInterface comp1;
    Componente2 comp2;

    @Autowired
    Componente3 comp3;

    public Controlador(ComponenteInterface componente1, Componente2 comp2) {
        this.comp1 = componente1;
        this.comp2 = comp2;
        System.out.println("Componente 1: " + comp1.getNombre());
        System.out.println("Componente 2: " + comp2.saluda());
    }

    @GetMapping
    public String saluda() {
        var componente2 = new Componente2();
        return "Hola..." + comp1.saluda();
    }

    @GetMapping("3")
    public String saluda3() {
        return "Hola..."+comp3.saluda();
    }


}
