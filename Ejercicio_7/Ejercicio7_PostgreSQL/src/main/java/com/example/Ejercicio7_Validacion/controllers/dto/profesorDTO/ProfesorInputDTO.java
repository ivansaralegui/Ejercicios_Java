package com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorInputDTO {
    int idProfesor;
    int idPersona;
    String comments;
    String branch;
}
