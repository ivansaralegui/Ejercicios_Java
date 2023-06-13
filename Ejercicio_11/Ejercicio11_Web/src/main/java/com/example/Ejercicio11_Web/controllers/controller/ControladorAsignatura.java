package com.example.Ejercicio11_Web.controllers.controller;

import com.example.Ejercicio11_Web.application.asignatura.AsignaturaService;
import com.example.Ejercicio11_Web.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio11_Web.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio11_Web.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("asignatura")
public class ControladorAsignatura {

    @Autowired
    private AsignaturaService as;

    @PostMapping("addAsignatura")
    public AsignaturaSimpleOutputDTO addAsignatura(@RequestBody AsignaturaInputDTO aiDTO){
        return as.addAsignatura(aiDTO);
    }

    @GetMapping("{id}")
    public AsignaturaFullOutputDTO getAsignaturaID(@PathVariable int id){
        return as.getAsignaturaById(id);
    }

    @GetMapping
    public List<AsignaturaFullOutputDTO> getAsignaturas(){
        return as.getAllAsignatura();
    }

    @DeleteMapping("{id}")
    public void deleteAsignatura(@PathVariable int id){
        as.deleteAsignaturaById(id);
    }

    @PutMapping("{id}")
    public AsignaturaSimpleOutputDTO updateAsignatura(@PathVariable int id, @RequestBody AsignaturaInputDTO asignatura){
        return as.updateAsignatura(id, asignatura);
    }

    @PutMapping("add/{idAsignatura},{idEstudiante}")
    public AsignaturaFullOutputDTO addEstudiantes(@PathVariable int idAsignatura, @PathVariable int idEstudiante){
       return as.addEstudiantes(idAsignatura, idEstudiante);
    }

    @GetMapping("estudiante/{id}")
    public List<AsignaturaSimpleOutputDTO> getAsignaturaByEstudianteId(@PathVariable int id){
        return as.getAsignaturaByEstudianteId(id);
    }

}
