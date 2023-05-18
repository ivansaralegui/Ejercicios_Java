package com.example.Ejercicio6_Controladores;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controlador {

    @GetMapping(value = "/user/{nombre}")
    @ResponseBody
    public String mostrarNombre(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/prueba")
    @ResponseBody
    public String prueba() {
        return "Prueba de POST";
    }

    @PostMapping("/useradd")
    @ResponseBody
    public Persona sacarPersona(@RequestBody Persona persona) {
        Persona p= new Persona(persona.getNombre(), persona.getEdad() + 1,
                persona.getCiudad());
        return p;
    }


}
