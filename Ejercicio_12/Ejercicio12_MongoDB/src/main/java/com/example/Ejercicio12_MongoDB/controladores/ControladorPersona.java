package com.example.Ejercicio12_MongoDB.controladores;

import com.example.Ejercicio12_MongoDB.dto.PersonaInputDTO;
import com.example.Ejercicio12_MongoDB.dto.PersonaOutputDTO;
import com.example.Ejercicio12_MongoDB.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mongo")
public class ControladorPersona {

    @Autowired
    private PersonaService ps;

    @PostMapping("addPersona")
    public PersonaOutputDTO addPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
       return ps.addPersona(personaInputDTO);
    }

    @GetMapping("getPersonas/{page}")
    public List<PersonaOutputDTO> getPersonas(@PathVariable int page) throws Exception {
        return ps.getAllPersonas(page);
    }

    @GetMapping("{nombre}")
    public PersonaOutputDTO getPersonaNombre(@PathVariable String nombre) throws Exception {
        return ps.getPersonaByName(nombre);
    }

    @PutMapping("{id}")
    public PersonaOutputDTO updatePersonaID(@PathVariable String id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return ps.updatePersona(id, personaInputDTO);
    }

    @DeleteMapping("{id}")
    public void deletePersonaByID(@PathVariable String id) throws Exception {
        ps.deletePersonaById(id);
    }

}
