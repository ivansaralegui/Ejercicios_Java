package com.example.Ejercicio11_Web.application.persona;

import com.example.Ejercicio11_Web.classes.Persona;
import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio11_Web.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        Optional<PersonaInputDTO> personaOptional = Optional.ofNullable(personaInputDTO);
        if (personaOptional.isPresent()) {
            if (personaInputDTO.getUsuario().length() > 10 || personaInputDTO.getUsuario().length() < 6) {
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres o inferior a 6 caracteres");
            }
            if (personaInputDTO.getPassword() == null) {
                throw new Exception("Longitud de password no puede ser inferior a 8 caracteres");
            }
            if (personaInputDTO.getCompanyEmail() == null) {
                throw new Exception("El email de la empresa no puede contener el nombre de usuario");
            }
            if (personaInputDTO.getPersonalEmail() == null) {
                throw new Exception("El email personal no puede contener el nombre de usuario");
            }
            if (personaInputDTO.getCity() == null) {
                throw new Exception("Longitud de ciudad no puede ser inferior a 3 caracteres");
            }
            if (personaInputDTO.getActive() == null) {
                throw new Exception("El campo active no puede ser nulo");
            }
            if (personaInputDTO.getCreatedDate() == null) {
                throw new Exception("El campo created_date no puede ser nulo");
            }

            // Crea un Objeto Persona para manejar el repositorio y el return
            Persona p = new Persona(personaInputDTO);
            personaRepository.save(p);
            return p.parsePersonaOutputDTO(p);
        } else {
            throw new Exception("Usuario no puede ser nulo");
        }
    }

    @Override
    public PersonaOutputDTO getPersonaById(int id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN GETPERSONABYID: No se ha encontrado la persona con esa ID"));

        return persona.parsePersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO getPersonaByName(String nombre){
        Persona persona = personaRepository.findAll().stream().filter(p -> p.getName().equals(nombre)).toList().get(0);

        return new PersonaOutputDTO(persona);
    }

    @Override
    public void deletePersonaById(int id){
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN DELETEPERSONASBYID: No se ha encontrado la persona con esa ID"));

        personaRepository.delete(persona);
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas() {
        List<PersonaOutputDTO> lstpoDTO = new ArrayList<>();
        personaRepository.findAll().forEach(p -> lstpoDTO.add((p.parsePersonaOutputDTO(p))));
        return lstpoDTO;
    }

    @Override
    public PersonaOutputDTO updatePersona(int id, PersonaInputDTO personaInputDTO){
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN UPDATEPERSONA: No se ha encontrado una persona con ese ID"));

        persona.setIdPersona(id);
        persona.setUsuario(personaInputDTO.getUsuario());
        persona.setPassword(personaInputDTO.getPassword());
        persona.setName(personaInputDTO.getName());
        persona.setSurname(personaInputDTO.getSurname());
        persona.setCompanyEmail(personaInputDTO.getCompanyEmail());
        persona.setPersonalEmail(personaInputDTO.getPersonalEmail());
        persona.setCity(personaInputDTO.getCity());
        persona.setActive(personaInputDTO.getActive());
        persona.setCreatedDate(personaInputDTO.getCreatedDate());
        persona.setImagenUrl(personaInputDTO.getImagenURL());
        persona.setTerminationDate(personaInputDTO.getTerminationDate());
        personaRepository.save(persona);
        return persona.parsePersonaOutputDTO(persona);

    }
}

