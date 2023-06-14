package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("persona")
@CrossOrigin("*")
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

    @GetMapping("customquery")
    public List<PersonaOutputDTO> findCutsomQueryPersonas(@RequestParam(required = false) String usuario,
                                                          @RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String surname,
                                                          @RequestParam(required = false) String fechaCondition,
                                                          @RequestParam(required = false) String ordenar,
                                                          @RequestParam(required = true) int pagina) {

        HashMap<String, Object> data = new HashMap<>();

        if (usuario != null) data.put("usuario", usuario);
        if (name != null) data.put("name", name);
        if (surname != null) data.put("surname", surname);
        if (fechaCondition != null) data.put("fechaCreacion", fechaCondition);

        return ps.getPersonasQuery(data, ordenar, pagina);
    }

}
