package com.example.Ejercicio7_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/post")
public class Post {
    @Autowired
    private PersonaRepository repository;
    @PostMapping("/addpersona")
    @ResponseBody
    public Persona addPersona(@RequestBody Persona persona) {
        return repository.save(persona);
    }

    @GetMapping("/listpersonas")
    public List<Persona> listPersonas() {
        return repository.findAll();
    }
}
