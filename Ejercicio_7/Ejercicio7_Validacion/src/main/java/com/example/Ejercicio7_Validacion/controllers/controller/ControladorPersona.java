package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.PersonaService;
import com.example.Ejercicio7_Validacion.application.PersonaServiceImpl;
import com.example.Ejercicio7_Validacion.classes.persona.Persona;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class ControladorPersona {

    @Autowired
    private PersonaServiceImpl psImpl;

    @PostMapping("addPersona")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO piDTO) throws Exception{
        return psImpl.addPersona(piDTO);
    }

    @GetMapping("id:{id}")
    public PersonaOutputDTO getPersonaID(@PathVariable int id) throws Exception{
        return psImpl.getPersonaById(id);
    }

    @GetMapping("nombre:{nombre}")
    public PersonaOutputDTO getPersonaName(@PathVariable String name) throws Exception{
        return psImpl.getPersonaByName(name);
    }

    @GetMapping("mostrar")
    public List<PersonaOutputDTO> getPersonas() throws Exception {
        return psImpl.getAllPersonas();
    }

    @DeleteMapping("delete:{id}")
    public void deletePersona(@PathVariable int id) throws Exception{
        psImpl.deletePersonaById(id);
    }

    @PutMapping("actualizar:{id}")
    public PersonaOutputDTO updatePersona(@PathVariable int id, @RequestBody PersonaInputDTO persona) throws Exception {
       return psImpl.updatePersona(id, persona);
    }

}
