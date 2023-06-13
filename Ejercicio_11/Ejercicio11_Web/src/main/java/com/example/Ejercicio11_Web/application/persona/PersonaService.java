package com.example.Ejercicio11_Web.application.persona;

import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    PersonaOutputDTO addPersona(PersonaInputDTO persona) throws Exception;
    PersonaOutputDTO getPersonaById(int id);
    void deletePersonaById(int id);
    List<PersonaOutputDTO> getAllPersonas();
    PersonaOutputDTO updatePersona(int id,PersonaInputDTO persona);
    PersonaOutputDTO getPersonaByName(String nombre);
}
