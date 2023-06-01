package com.example.Ejercicio7_Validacion.application.profesor;

import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesor) throws Exception;
    ProfesorOutputDTO getProfesorById(int id) throws Exception;
    void deleteProfesorById(int id) throws Exception;
    List<ProfesorOutputDTO> getAllProfesores() throws Exception;
    ProfesorOutputDTO updateProfesor(int id,ProfesorInputDTO profesor) throws Exception;
}
