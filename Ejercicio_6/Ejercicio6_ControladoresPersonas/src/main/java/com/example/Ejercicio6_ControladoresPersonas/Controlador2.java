package com.example.Ejercicio6_ControladoresPersonas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/controlador2")
public class Controlador2 {

    private Servicio servicio;

    public Controlador2(Servicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/getPersona")
    @ResponseBody
    public Persona getPersona(){
        Persona persona = servicio.getPersona();
        persona.setEdad(persona.getEdad() * 2);
        return persona;
    }

    @GetMapping("/getCiudades")
    @ResponseBody
    public List<Ciudad> getCiudades() {
        return servicio.getCiudades();
    }

}
