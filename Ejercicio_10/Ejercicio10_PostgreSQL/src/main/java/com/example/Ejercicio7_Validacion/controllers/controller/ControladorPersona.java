package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.persona.PersonaServiceImpl;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    public PersonaOutputDTO getPersonaID(@PathVariable int id){
        return ps.getPersonaById(id);
    }

    @GetMapping("nombre/{nombre}")
    public PersonaOutputDTO getPersonaName(@PathVariable String name){
        return ps.getPersonaByName(name);
    }

    @GetMapping
    public List<PersonaOutputDTO> getPersonas() {
        return ps.getAllPersonas();
    }

    @DeleteMapping("{id}")
    public void deletePersona(@PathVariable int id){
        ps.deletePersonaById(id);
    }

    @PutMapping("{id}")
    public PersonaOutputDTO updatePersona(@PathVariable int id, @RequestBody PersonaInputDTO persona) {
       return ps.updatePersona(id, persona);
    }

    @GetMapping("profesor/{id}")
    public ProfesorOutputDTO getProfesor(@PathVariable int id) {
        RestTemplate rt = new RestTemplate();
        return rt.getForObject("http://localhost:8080/profesor/" + id, ProfesorOutputDTO.class);
    }

}
