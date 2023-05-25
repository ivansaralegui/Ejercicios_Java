package com.example.Ejercicio7_Validacion.application;

import com.example.Ejercicio7_Validacion.classes.persona.Persona;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository repository;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO persona) throws Exception {
        Optional<PersonaInputDTO> personaOptional = Optional.ofNullable(persona);
        if (personaOptional.isPresent()) {
            if (persona.getUsuario().length() > 10 || persona.getUsuario().length() < 6) {
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres o inferior a 6 caracteres");
            }
            if (persona.getPassword() == null) {
                throw new Exception("Longitud de password no puede ser inferior a 8 caracteres");
            }
            if (persona.getCompany_email() == null) {
                throw new Exception("El email de la empresa no puede contener el nombre de usuario");
            }
            if (persona.getPersonal_email() == null) {
                throw new Exception("El email personal no puede contener el nombre de usuario");
            }
            if (persona.getPersonal_email().contains(persona.getCompany_email())) {
                throw new Exception("El email personal no puede contener el email de la empresa");
            }
            if (persona.getCity() == null) {
                throw new Exception("Longitud de ciudad no puede ser inferior a 3 caracteres");
            }
            if (persona.getActive() == null) {
                throw new Exception("El campo active no puede ser nulo");
            }
            if (persona.getCreated_date() == null) {
                throw new Exception("El campo created_date no puede ser nulo");
            }
            // Crea un Objeto Persona para manejar el repositorio y el return
            Persona p = new Persona(persona);
            repository.save(p);
            return p.parsePersonaOutputDTO(p);
        } else {
            throw new Exception("Usuario no puede ser nulo");
        }
    }

    @Override
    public PersonaOutputDTO getPersonaById(int id) throws Exception {
        Optional<Persona> personaOptional = repository.findById(id);
        if (personaOptional.isPresent()) {
            Persona p = personaOptional.get();
            return p.parsePersonaOutputDTO(p);
        } else {
            throw new Exception("No se ha encontrado el usuario con esa ID");
        }
    }

    @Override
    public PersonaOutputDTO getPersonaByName(String nombre) throws Exception {
        Persona persona = null;
        for (Persona p: repository.findAll()) {
            if (p.getName().equals(nombre)) {
                persona = p;
            }
        }
        if (persona == null) {
            throw new Exception("No se ha encontrado el usuario con ese nombre");
        } else {
            return persona.parsePersonaOutputDTO(persona);
        }
    }

    @Override
    public void deletePersonaById(int id) throws Exception {
        Optional<Persona> personaOptional = repository.findById(id);
        if (personaOptional.isPresent()) {
            Persona p = personaOptional.get();
            repository.delete(p);
        } else {
            throw new Exception("No se ha encontrado el usuario con esa ID");
        }
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas() {
        List<PersonaOutputDTO> lstpoDTO = new ArrayList<PersonaOutputDTO>();
        for (Persona p: repository.findAll()) {
            lstpoDTO.add((p.parsePersonaOutputDTO(p)));
        }
        return lstpoDTO;
    }

    @Override
    public PersonaOutputDTO updatePersona(int id, PersonaInputDTO persona) throws Exception{
        Optional<Persona> personaOptional = repository.findById(id);
        if (personaOptional.isPresent()) {
            Persona p = new Persona(persona);
            p.setId(id);
            repository.save(p);
            return p.parsePersonaOutputDTO(p);
        } else {
            throw new Exception("No se ha encontrado usuario con ese ID");
        }
    }
}

