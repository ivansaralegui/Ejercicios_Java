package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Componente1 implements ComponenteInterface{

    public String nombre = "SIN NOMBRE";

    public Componente1() {
        System.out.println("iniciando componente 1");
    }

    public String saluda() {

        return "Hola desde componente 1. Nombre: " + nombre;
    }

    public String getNombre(){
        return nombre;
    }

}
