package com.example.Ejercicio12_MongoDB.servicios;

import com.example.Ejercicio12_MongoDB.dto.PersonaInputDTO;
import com.example.Ejercicio12_MongoDB.dto.PersonaOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {

    PersonaOutputDTO addPersona(PersonaInputDTO persona) throws Exception;
    void deletePersonaById(String id) throws Exception;
    List<PersonaOutputDTO> getAllPersonas(int page) throws Exception;
    PersonaOutputDTO updatePersona(String id,PersonaInputDTO persona) throws Exception;
    PersonaOutputDTO getPersonaByName(String nombre) throws Exception;

}
