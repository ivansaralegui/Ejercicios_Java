package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.profesor.ProfesorService;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor")
public class ControladorProfesor {

    @Autowired
    private ProfesorService ps;

    @PostMapping("addProfesor")
    public ProfesorOutputDTO addProfesor(@RequestBody ProfesorInputDTO piDTO) throws Exception{
        return ps.addProfesor(piDTO);
    }

    @GetMapping("{id}")
    public ProfesorOutputDTO getProfesorID(@PathVariable int id){
        return ps.getProfesorById(id);
    }

    @GetMapping
    public List<ProfesorOutputDTO> getProfesores(){
        return ps.getAllProfesores();
    }

    @DeleteMapping("{id}")
    public void deleteProfesor(@PathVariable int id){
        ps.deleteProfesorById(id);
    }

    @PutMapping("{id}")
    public ProfesorOutputDTO updateProfesor(@PathVariable int id, @RequestBody ProfesorInputDTO profesor){
        return ps.updateProfesor(id, profesor);
    }

}
