package com.example.Ejercicio6_ControladoresPersonas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/controlador1")
public class Controlador1 {

    private Servicio servicio;

    @Autowired
    public Controlador1(Servicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/addPersona")
    @ResponseBody
    public Persona addPersona(@RequestHeader String nombre,@RequestHeader String ciudad,@RequestHeader int edad) {
        Persona p = new Persona(nombre, ciudad, edad);
        return servicio.crearPersona(p);
    }

    @PostMapping("/addCiudad")
    @ResponseBody
    public String addCiudad(@RequestHeader String nombre, @RequestHeader int numeroHabitantes) {
        Ciudad c = new Ciudad(nombre, numeroHabitantes);
        servicio.addCiudad(c);
        return "Se ha añadido la ciudad: " + nombre + " con " + numeroHabitantes + " habitantes.";
    }

}
