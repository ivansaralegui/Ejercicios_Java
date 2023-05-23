package com.example.Ejercicio7_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class Consulta {

    @Autowired
    private PersonaRepository repository;

    // Apartado 1
    @GetMapping("/persona/{id}")
    @ResponseBody
    public ResponseEntity<Object> getPersona(@PathVariable Integer id) {
        Optional<Persona> personaOptional = repository.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            return ResponseEntity.ok(persona);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    // Apartado 2
    @GetMapping("persona/nombre/{nombre}")
    @ResponseBody
    public List<Persona> listPersonasNombre(@PathVariable String nombre) {
       List<Persona> listaPersonas = new ArrayList<Persona>();
        for (Persona persona: repository.findAll()) {
            if (persona.getNombre().equals(nombre)) {
                listaPersonas.add(persona);
            }
        }
        return listaPersonas;
    }

}
