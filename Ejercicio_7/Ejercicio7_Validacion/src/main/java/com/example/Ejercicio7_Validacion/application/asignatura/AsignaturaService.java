package com.example.Ejercicio7_Validacion.application.asignatura;

import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AsignaturaService {
    AsignaturaSimpleOutputDTO addAsignatura(AsignaturaInputDTO asignatura) throws Exception;
    AsignaturaFullOutputDTO getAsignaturaById(int id) throws Exception;
    void deleteAsignaturaById(int id) throws Exception;
    List<AsignaturaFullOutputDTO> getAllAsignatura() throws Exception;
    AsignaturaSimpleOutputDTO updateAsignatura(int id, AsignaturaInputDTO asignatura) throws Exception;
    AsignaturaFullOutputDTO addEstudiantes(int idAsignatura, int idEstudiante) throws Exception;
    Set<AsignaturaSimpleOutputDTO> getAsignaturaByEstudianteId(int id) throws Exception;
}
