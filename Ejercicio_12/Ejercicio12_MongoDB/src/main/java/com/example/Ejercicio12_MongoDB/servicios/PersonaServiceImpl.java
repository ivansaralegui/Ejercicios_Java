package com.example.Ejercicio12_MongoDB.servicios;

import com.example.Ejercicio12_MongoDB.clases.Persona;
import com.example.Ejercicio12_MongoDB.controladores.MongoDBConfig;
import com.example.Ejercicio12_MongoDB.dto.PersonaInputDTO;
import com.example.Ejercicio12_MongoDB.dto.PersonaOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        Persona persona = new Persona(personaInputDTO);
        mongoDBConfig.mongoTemplate().insert(persona);
        return persona.parsePersonaOutputDTO();
    }

    @Override
    public PersonaOutputDTO getPersonaByName(String nombre) throws Exception {
        Persona persona = mongoDBConfig.mongoTemplate().findAll(Persona.class).stream().filter(p -> p.getName().equals(nombre)).toList().get(0);
        return persona.parsePersonaOutputDTO();
    }

    @Override
    public List<PersonaOutputDTO> getAllPersonas(int page) throws Exception {
        List<PersonaOutputDTO> lista = new ArrayList<>();
        mongoDBConfig.mongoTemplate().findAll(Persona.class).forEach(p -> lista.add(p.parsePersonaOutputDTO()));

        int fromIndex = (page * 3) - 3;
        int toIndex = fromIndex + 3;

        if (lista.size() >= toIndex) {
            return lista.subList(fromIndex, toIndex);
        } else {
            return lista.subList(fromIndex, lista.size());
        }
    }

    @Override
    public PersonaOutputDTO updatePersona(String id, PersonaInputDTO personaInputDTO) throws Exception {
        Persona persona = mongoDBConfig.mongoTemplate().findById(id, Persona.class);
        persona.setUsuario(personaInputDTO.getUsuario());
        persona.setName(personaInputDTO.getName());
        persona.setSurname(personaInputDTO.getSurname());
        persona.setCompanyEmail(personaInputDTO.getCompanyEmail());
        persona.setPersonalEmail(personaInputDTO.getPersonalEmail());
        persona.setCity(personaInputDTO.getCity());
        persona.setActive(personaInputDTO.getActive());
        persona.setCreatedDate(personaInputDTO.getCreatedDate());
        persona.setImagenUrl(personaInputDTO.getImagenURL());
        persona.setTerminationDate(personaInputDTO.getTerminationDate());
        mongoDBConfig.mongoTemplate().save(persona);
        return persona.parsePersonaOutputDTO();
    }

    @Override
    public void deletePersonaById(String id) throws Exception {
        Persona persona = mongoDBConfig.mongoTemplate().findById(id, Persona.class);
        mongoDBConfig.mongoTemplate().remove(persona);
    }

}
