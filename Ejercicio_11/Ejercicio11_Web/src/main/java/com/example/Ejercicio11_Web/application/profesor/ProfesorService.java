package com.example.Ejercicio11_Web.application.profesor;

import com.example.Ejercicio11_Web.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio11_Web.controllers.dto.profesorDTO.ProfesorOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfesorService {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesor) throws Exception;
    ProfesorOutputDTO getProfesorById(int id);
    void deleteProfesorById(int id);
    List<ProfesorOutputDTO> getAllProfesores();
    ProfesorOutputDTO updateProfesor(int id,ProfesorInputDTO profesor);
}
