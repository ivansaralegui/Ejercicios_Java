package com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO;

import com.example.Ejercicio7_Validacion.classes.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class EstudianteInputDTO {
    int idEstudiante;
    int idPersona;
    int numHoursWeek;
    String comments;
    int idProfesor;
    String branch;
    List<Integer> asignaturas;
}
