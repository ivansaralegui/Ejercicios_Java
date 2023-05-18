package com.example.Ejercicio6_ControladoresPersonas;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicio {
    private Persona persona;


    private List<Ciudad> ciudades = crearLista();

    public Persona crearPersona(Persona persona) {
        this.persona = persona;
        return this.persona;
    }

    public Persona getPersona() {
        return this.persona;
    }

    @PostConstruct
    private ArrayList<Ciudad> crearLista() {
      return new ArrayList<Ciudad>();
    }

    public void addCiudad(Ciudad c) {
        ciudades.add(c);
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

}
