package com.example.Ejercicio7_Validacion.application.asignatura;

import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AsignaturaService {
    AsignaturaSimpleOutputDTO addAsignatura(AsignaturaInputDTO asignatura);
    AsignaturaFullOutputDTO getAsignaturaById(int id);
    void deleteAsignaturaById(int id);
    List<AsignaturaFullOutputDTO> getAllAsignatura();
    AsignaturaSimpleOutputDTO updateAsignatura(int id, AsignaturaInputDTO asignatura);
    AsignaturaFullOutputDTO addEstudiantes(int idAsignatura, int idEstudiante);
    List<AsignaturaSimpleOutputDTO> getAsignaturaByEstudianteId(int id);
}
