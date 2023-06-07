package com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO;

import com.example.Ejercicio7_Validacion.classes.Asignatura;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AsignaturaSimpleOutputDTO {
    int idAsignatura;
    String nombreAsignatura;
    String comments;
    Date initialDate;
    Date finishDate;


    public AsignaturaSimpleOutputDTO(Asignatura asignatura)
    {
        idAsignatura=asignatura.getIdAsignatura();
        nombreAsignatura=asignatura.getAsignaturaNombre();
        comments=asignatura.getComments();
        initialDate=asignatura.getInitialDate();
        finishDate=asignatura.getFinishDate();
    }

}
