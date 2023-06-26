package com.example.Ejercicio7_Validacion.controllers.dto.personaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDTO {
    int idPersona;
    String usuario;
    String password;
    String name;
    String surname;
    String companyEmail;
    String personalEmail;
    String city;
    Boolean active;
    Date createdDate;
    String imagenURL;
    Date terminationDate;

    public PersonaInputDTO(String usuario, String password, String name,
                           String surname, String companyEmail, String personalEmail,
                           String city, Boolean active, Date createdDate,
                           String imagenURL, Date terminationDate) {
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.companyEmail = companyEmail;
        this.personalEmail = personalEmail;
        this.city = city;
        this.active = active;
        this.createdDate = createdDate;
        this.imagenURL = imagenURL;
        this.terminationDate = terminationDate;
    }
}


