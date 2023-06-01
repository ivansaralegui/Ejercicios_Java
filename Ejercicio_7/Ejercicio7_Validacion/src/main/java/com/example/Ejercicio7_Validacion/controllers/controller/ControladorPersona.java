package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.persona.PersonaServiceImpl;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class ControladorPersona {

    @Autowired
    private PersonaService ps;

    @PostMapping("addPersona")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO piDTO) throws Exception{
        return ps.addPersona(piDTO);
    }

    @GetMapping("{id}")
    public PersonaOutputDTO getPersonaID(@PathVariable int id) throws Exception{
        return ps.getPersonaById(id);
    }

    @GetMapping("nombre/{nombre}")
    public PersonaOutputDTO getPersonaName(@PathVariable String name) throws Exception{
        return ps.getPersonaByName(name);
    }

    @GetMapping
    public List<PersonaOutputDTO> getPersonas() throws Exception {
        return ps.getAllPersonas();
    }

    @DeleteMapping("{id}")
    public void deletePersona(@PathVariable int id) throws Exception{
        ps.deletePersonaById(id);
    }

    @PutMapping("{id}")
    public PersonaOutputDTO updatePersona(@PathVariable int id, @RequestBody PersonaInputDTO persona) throws Exception {
       return ps.updatePersona(id, persona);
    }

}
