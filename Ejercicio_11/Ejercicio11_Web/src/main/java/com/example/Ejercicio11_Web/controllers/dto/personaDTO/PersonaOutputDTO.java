package com.example.Ejercicio11_Web.controllers.dto.personaDTO;

import com.example.Ejercicio11_Web.classes.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@NoArgsConstructor
public class PersonaOutputDTO {
    int idPersona;
    String usuario;
    String name;
    String surname;
    String companyEmail;
    String personalEmail;
    String city;
    Boolean active;
    Date createdDate;
    String imagenURL;
    Date terminationDate;

    public PersonaOutputDTO(Persona persona)
    {
        this.idPersona = persona.getIdPersona();
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.companyEmail = persona.getCompanyEmail();
        this.personalEmail = persona.getPersonalEmail();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.createdDate = persona.getCreatedDate();
        this.imagenURL = persona.getImagenUrl();
        this.terminationDate = persona.getTerminationDate();
    }

}
