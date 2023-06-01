package com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaFullOutputDTO {
    int id_asignatura;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;
    Set<Estudiante> estudiantes;
}
