package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
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
    @Size(min = 6, max = 10, message = "El nombre debe contener entre 6 y 10 caracteres")
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

    public Persona(PersonaInputDTO personaInputDTO) {
        this.setIdPersona(personaInputDTO.getIdPersona());
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

    public PersonaOutputDTO parsePersonaOutputDTO() {
        PersonaOutputDTO poDTO = new PersonaOutputDTO();
        poDTO.setIdPersona(this.getIdPersona());
        poDTO.setUsuario(this.getUsuario());
        poDTO.setName(this.getName());
        poDTO.setSurname(this.getSurname());
        poDTO.setCompanyEmail(this.getCompanyEmail());
        poDTO.setPersonalEmail(this.getPersonalEmail());
        poDTO.setCity(this.getCity());
        poDTO.setActive(this.getActive());
        poDTO.setCreatedDate(this.getCreatedDate());
        poDTO.setImagenURL(this.getImagenUrl());
        poDTO.setTerminationDate(this.getTerminationDate());
        return poDTO;
    }

}
