package com.example.Ejercicio11_Web.controllers.dto.estudainteDTO;

import com.example.Ejercicio11_Web.classes.Estudiante;
import com.example.Ejercicio11_Web.classes.Persona;
import com.example.Ejercicio11_Web.classes.Profesor;
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
        idEstudiante=estudiante.getIdEstudiante();
        numHoursWeek=estudiante.getNumHoursWeek();
        comments=estudiante.getComments();
        branch=estudiante.getBranch();
    }
}
