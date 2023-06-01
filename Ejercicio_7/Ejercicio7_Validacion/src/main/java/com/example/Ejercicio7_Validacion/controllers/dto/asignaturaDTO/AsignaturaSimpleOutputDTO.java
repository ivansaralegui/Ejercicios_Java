package com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaSimpleOutputDTO {
    int id_asignatura;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;
}
