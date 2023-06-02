package com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO;

import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
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
