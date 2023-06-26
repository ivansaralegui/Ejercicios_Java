package com.example.Ejercicio7_Validacion.application.estudiante;

import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteService {
    EstudianteFullOutputDTO addEstudiante(EstudianteInputDTO estudiante) throws Exception;
    EstudianteSimpleOutputDTO getEstudianteSimpleById(int id);
    EstudianteFullOutputDTO getEstudianteFullById(int id);
    void deleteEstudianteById(int id);
    List<EstudianteFullOutputDTO> getAllEstudiantes();
    EstudianteSimpleOutputDTO updateEstudiante(int id, EstudianteInputDTO estudiante);
    EstudianteFullOutputDTO addAsignatura(int idEstudiante, int idAsignatura);
}
