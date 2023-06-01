package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.asignatura.AsignaturaService;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
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
    public AsignaturaSimpleOutputDTO addAsignatura(@RequestBody AsignaturaInputDTO aiDTO) throws Exception{
        return as.addAsignatura(aiDTO);
    }

    @GetMapping("{id}")
    public AsignaturaFullOutputDTO getAsignaturaID(@PathVariable int id) throws Exception{
        return as.getAsignaturaById(id);
    }

    @GetMapping
    public List<AsignaturaFullOutputDTO> getAsignatura() throws Exception {
        return as.getAllAsignatura();
    }

    @DeleteMapping("{id}")
    public void deleteAsignatura(@PathVariable int id) throws Exception{
        as.deleteAsignaturaById(id);
    }

    @PutMapping("{id}")
    public AsignaturaSimpleOutputDTO updateAsignatura(@PathVariable int id, @RequestBody AsignaturaInputDTO asignatura) throws Exception {
        return as.updateAsignatura(id, asignatura);
    }

    @PutMapping("add/{idAsignatura},{idEstudiante}")
    public AsignaturaFullOutputDTO addEstudiantes(@PathVariable int idAsignatura, @PathVariable int idEstudiante) throws Exception {
       return as.addEstudiantes(idAsignatura, idEstudiante);
    }

    @GetMapping("estudiante/{id}")
    public Set<AsignaturaSimpleOutputDTO> getAsignaturaByEstudianteId(@PathVariable int id) throws Exception {
        return as.getAsignaturaByEstudianteId(id);
    }

}
