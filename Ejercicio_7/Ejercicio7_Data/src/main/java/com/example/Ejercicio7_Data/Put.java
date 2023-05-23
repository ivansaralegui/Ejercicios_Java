package com.example.Ejercicio7_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/put")
public class Put {

    @Autowired
    private PersonaRepository repository;

    @PutMapping("/persona/{id}")
    @ResponseBody
    public ResponseEntity<Object> updatePersona(@PathVariable Integer id, @RequestBody Persona personaData) {
      Optional<Persona> personaOptional = repository.findById(id);

      if (personaOptional.isPresent()) {
         if (personaData.getNombre() != null && personaData.getPoblacion() != null && personaData.getEdad() != null) {
             Persona persona = personaOptional.get();
             persona.setNombre(personaData.getNombre());
             persona.setEdad(personaData.getEdad());
             persona.setPoblacion(personaData.getPoblacion());
             return ResponseEntity.ok(repository.save(persona));
         } else {
             return ResponseEntity.badRequest().build();
         }
      } else {
          return ResponseEntity.notFound().build();
      }
    }

}
