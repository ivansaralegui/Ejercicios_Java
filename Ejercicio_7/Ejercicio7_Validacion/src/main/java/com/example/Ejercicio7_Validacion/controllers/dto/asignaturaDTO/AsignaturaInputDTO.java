package com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDTO {
    int id_asignatura;
    int id_student;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;
    Set<Estudiante> estudiantes;
}
