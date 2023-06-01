package com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    int id_profesor;
    int id_persona;
    String comments;
    String branch;
}
