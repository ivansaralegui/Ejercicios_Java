package com.example.Ejercicio11_Web.classes;

import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPersona;
    @Size(min=6, max=10, message = "El nombre debe contener entre 6 y 10 caracteres")
    @NotNull
    String usuario;
    @NotNull
    String password;
    @NotNull
    String name;
    String surname;
    @NotNull
    String companyEmail;
    @NotNull
    String personalEmail;
    @NotNull
    String city;
    @NotNull
    Boolean active;
    @NotNull
    Date createdDate;
    String imagenUrl;
    Date terminationDate;

    public Persona (PersonaInputDTO personaInputDTO) {
       this.usuario = personaInputDTO.getUsuario();
       this.password = personaInputDTO.getPassword();
       this.name = personaInputDTO.getName();
       this.surname = personaInputDTO.getSurname();
       this.companyEmail = personaInputDTO.getCompanyEmail();
       this.personalEmail = personaInputDTO.getPersonalEmail();
       this.city = personaInputDTO.getCity();
       this.active = personaInputDTO.getActive();
       this.createdDate = personaInputDTO.getCreatedDate();
       this.imagenUrl = personaInputDTO.getImagenURL();
       this.terminationDate = personaInputDTO.getTerminationDate();
    }

    public PersonaOutputDTO parsePersonaOutputDTO(Persona persona) {
        PersonaOutputDTO poDTO = new PersonaOutputDTO();
        poDTO.setIdPersona(persona.getIdPersona());
        poDTO.setUsuario(persona.getUsuario());
        poDTO.setName(persona.getName());
        poDTO.setSurname(persona.getSurname());
        poDTO.setCompanyEmail(persona.getCompanyEmail());
        poDTO.setPersonalEmail(persona.getPersonalEmail());
        poDTO.setCity(persona.getCity());
        poDTO.setActive(persona.getActive());
        poDTO.setCreatedDate(persona.getCreatedDate());
        poDTO.setImagenURL(persona.getImagenUrl());
        poDTO.setTerminationDate(persona.getTerminationDate());
        return poDTO;
    }

}
