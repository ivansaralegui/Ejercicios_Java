package com.example.Ejercicio7_Validacion.controllers.controller;

import com.example.Ejercicio7_Validacion.application.estudiante.EstudianteService;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante")
public class ControladorEstudiante {

    @Autowired
    private EstudianteService es;

    @PostMapping("addEstudiante")
    public EstudianteSimpleOutputDTO addEstudiante(@RequestBody EstudianteInputDTO eiDTO) throws Exception{
        return es.addEstudiante(eiDTO);
    }

    @GetMapping("{id}")
    public Object getEstudianteID(@PathVariable int id, @RequestParam(value="type", defaultValue = "simple") String type) throws Exception{
       if (type.equals("simple")) {
           return es.getEstudianteSimpleById(id);
       } else if (type.equals("full")) {
           return es.getEstudianteFullById(id);
       } else {
           throw new Exception("ERROR EN GETESTUDIANTEID: Error en los parametros");
       }
    }

    @GetMapping
    public List<EstudianteFullOutputDTO> getEstudiantes() throws Exception {
        return es.getAllEstudiantes();
    }

    @DeleteMapping("{id}")
    public void deleteEstudiantes(@PathVariable int id) throws Exception{
        es.deleteEstudianteById(id);
    }

    @PutMapping("{id}")
    public EstudianteSimpleOutputDTO updateEstudiante(@PathVariable int id, @RequestBody EstudianteInputDTO estudiante) throws Exception {
        return es.updateEstudiante(id, estudiante);
    }

    @PutMapping("add/{idEstudiante},{idAsignatura}")
    public EstudianteFullOutputDTO addAsignatura(@PathVariable int idEstudiante, @PathVariable int idAsignatura) throws Exception {
       return es.addAsignatura(idEstudiante, idAsignatura);
    }

}
