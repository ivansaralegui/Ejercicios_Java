package com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorInputDTO {
    int idProfesor;
    int idPersona;
    String comments;
    String branch;

    public ProfesorInputDTO(int idPersona) {
        this.idPersona = idPersona;
        this.comments = "Comentario";
        this.branch = "Branch";
    }
}
