package com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO;

import com.example.Ejercicio7_Validacion.classes.Asignatura;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteFullOutputDTO {
    int id_student;
    int num_hours_week;
    String comments;
    Persona id_persona;
    String branch;
    Profesor profesor;
    Set<Asignatura> asignatura;
}
