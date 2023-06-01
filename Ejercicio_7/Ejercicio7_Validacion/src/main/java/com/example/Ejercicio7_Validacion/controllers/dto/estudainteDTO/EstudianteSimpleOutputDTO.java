package com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO;

import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteSimpleOutputDTO {
    int id_student;
    int num_hours_week;
    String comments;
    Persona id_persona;
    String branch;
    Profesor profesor;
}
