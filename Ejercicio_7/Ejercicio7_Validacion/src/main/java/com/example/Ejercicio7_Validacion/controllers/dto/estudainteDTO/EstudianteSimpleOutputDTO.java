package com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstudianteSimpleOutputDTO {
    int idEstudiante;
    int numHoursWeek;
    String comments;
    String branch;

    public EstudianteSimpleOutputDTO(Estudiante estudiante)
    {
        this.idEstudiante=estudiante.getIdEstudiante();
        this.numHoursWeek=estudiante.getNumHoursWeek();
        this.comments=estudiante.getComments();
        this.branch=estudiante.getBranch();
    }
}
