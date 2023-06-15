package com.example.Ejercicio12_MongoDB.clases;

import com.example.Ejercicio12_MongoDB.dto.PersonaInputDTO;
import com.example.Ejercicio12_MongoDB.dto.PersonaOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "persona")
public class Persona {
    @Id
    String _id;
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

    public PersonaOutputDTO parsePersonaOutputDTO() {
        PersonaOutputDTO poDTO = new PersonaOutputDTO();
        poDTO.set_id(this.get_id());
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
