package com.example.Ejercicio7_Validacion.application.persona;

import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @PersistenceContext
    private EntityManager entityManager;

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
            if (personaInputDTO.getPersonalEmail().contains(personaInputDTO.getCompanyEmail())) {
                throw new Exception("El email personal no puede contener el email de la empresa");
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
            return p.parsePersonaOutputDTO();
        } else {
            throw new Exception("Usuario no puede ser nulo");
        }
    }

    @Override
    public PersonaOutputDTO getPersonaById(int id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERROR EN GETPERSONABYID: No se ha encontrado la persona con esa ID"));

        return persona.parsePersonaOutputDTO();
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
        personaRepository.findAll().forEach(p -> lstpoDTO.add((p.parsePersonaOutputDTO())));
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
        return persona.parsePersonaOutputDTO();

    }

    public List<PersonaOutputDTO> getPersonasQuery(HashMap<String, Object> data, String ordenar, int pagina) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        data.forEach((k, v) -> {
            switch (k) {
                case "usuario":
                    predicates.add(cb.like(root.get(k), "%" + (String) v + "%"));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(k), "%" + (String) v + "%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(k), "%" + (String) v + "%"));
                    break;
                case "fechaCondition":
                    String fecha = (String) data.get("fechaCondition");

                    switch (fecha) {
                        case ">":
                            predicates.add(cb.greaterThan(root.get(k), (Date) v));
                            break;
                        case "<":
                            predicates.add(cb.lessThan(root.get(k), (Date) v));
                            break;
                        case "=":
                            predicates.add(cb.equal(root.get(k), (Date) v));
                            break;
                    }
                    break;
            }
        });
        if (ordenar != null) {
            if (ordenar.equals("user")) {
                query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.desc(root.get("user")));
            }
            if (ordenar.equals("name")) {
                query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.desc(root.get("name")));
            }
        } else {
            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        }

        List<PersonaOutputDTO> listaQuery =  entityManager.createQuery(query).getResultList().stream().map(Persona::parsePersonaOutputDTO).toList();

        int fromIndex = (pagina * 10) - 10;
        int toIndex = fromIndex + 10;
        if (listaQuery.size() >= toIndex) {
            return listaQuery.subList(fromIndex, toIndex);
        } else {
            return listaQuery.subList(fromIndex, listaQuery.size());
        }
    }

}

