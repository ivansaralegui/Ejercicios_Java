package com.example.Ejercicio7_Validacion.application.persona;

import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    PersonaOutputDTO addPersona(PersonaInputDTO persona) throws Exception;
    PersonaOutputDTO getPersonaById(int id) throws Exception;
    void deletePersonaById(int id) throws Exception;
    List<PersonaOutputDTO> getAllPersonas() throws Exception;
    PersonaOutputDTO updatePersona(int id,PersonaInputDTO persona) throws Exception;
    PersonaOutputDTO getPersonaByName(String nombre) throws Exception;
}
