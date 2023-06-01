package com.example.Ejercicio7_Validacion.application.estudiante;

import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteService {
    EstudianteSimpleOutputDTO addEstudiante(EstudianteInputDTO estudiante) throws Exception;
    EstudianteSimpleOutputDTO getEstudianteSimpleById(int id) throws Exception;
    EstudianteFullOutputDTO getEstudianteFullById(int id) throws Exception;
    void deleteEstudianteById(int id) throws Exception;
    List<EstudianteFullOutputDTO> getAllEstudiantes() throws Exception;
    EstudianteSimpleOutputDTO updateEstudiante(int id, EstudianteInputDTO estudiante) throws Exception;
    EstudianteFullOutputDTO addAsignatura(int idEstudiante, int idAsignatura) throws Exception;
}
