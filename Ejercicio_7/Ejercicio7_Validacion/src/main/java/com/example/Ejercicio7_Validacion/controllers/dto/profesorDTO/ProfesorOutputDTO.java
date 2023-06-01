package com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO;

import com.example.Ejercicio7_Validacion.classes.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDTO {
    int id_profesor;
    Persona id_persona;
    String comments;
    String branch;
}
