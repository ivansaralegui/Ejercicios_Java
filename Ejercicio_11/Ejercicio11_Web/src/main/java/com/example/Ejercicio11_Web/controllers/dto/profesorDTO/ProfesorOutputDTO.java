package com.example.Ejercicio11_Web.controllers.dto.profesorDTO;

import com.example.Ejercicio11_Web.classes.Persona;
import com.example.Ejercicio11_Web.classes.Profesor;
import com.example.Ejercicio11_Web.controllers.dto.personaDTO.PersonaOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class ProfesorOutputDTO {
    int idProfesor;
    PersonaOutputDTO persona;
    String comments;
    String branch;

    public ProfesorOutputDTO(Profesor profesor)
    {
        this.idProfesor = profesor.getIdProfesor();
        this.persona = new PersonaOutputDTO(profesor.getPersona());
        this.comments = profesor.getComments();
        this.branch = profesor.getBranch();
    }
}
