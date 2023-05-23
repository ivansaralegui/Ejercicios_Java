package com.example.Ejercicio7_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/delete")
public class Delete {

    @Autowired
    private PersonaRepository repository;

    @DeleteMapping("/persona/{id}")
    @ResponseBody
    public ResponseEntity<Object> deletePersona(@PathVariable Integer id) {
        Optional<Persona> personaOptional = repository.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            repository.delete(persona);
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }


    }


}
