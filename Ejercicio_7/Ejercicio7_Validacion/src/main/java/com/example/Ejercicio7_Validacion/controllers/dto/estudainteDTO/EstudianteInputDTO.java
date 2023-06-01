package com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO;

import com.example.Ejercicio7_Validacion.classes.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInputDTO {
    int id_student;
    int id_persona;
    int num_hours_week;
    String comments;
    int id_profesor;
    String branch;
    Set<Asignatura> asignaturas;
}
