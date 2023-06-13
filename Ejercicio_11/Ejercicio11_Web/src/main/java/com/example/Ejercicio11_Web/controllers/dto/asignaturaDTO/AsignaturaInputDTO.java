package com.example.Ejercicio11_Web.controllers.dto.asignaturaDTO;

import com.example.Ejercicio11_Web.classes.Estudiante;
import com.example.Ejercicio11_Web.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDTO {
    int idAsignatura;
    int idEstudiante;
    String asignaturaNombre;
    String comments;
    Date initialDate;
    Date finishDate;
    List<EstudianteSimpleOutputDTO> estudiantes;
}
