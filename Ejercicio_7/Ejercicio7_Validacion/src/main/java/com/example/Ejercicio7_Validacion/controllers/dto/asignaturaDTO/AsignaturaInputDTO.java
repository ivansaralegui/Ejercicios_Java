package com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class AsignaturaInputDTO {
    int idAsignatura;
    String asignaturaNombre;
    String comments;
    Date initialDate;
    Date finishDate;
    List<EstudianteSimpleOutputDTO> estudiantes;

    public AsignaturaInputDTO() {
        this.asignaturaNombre = "Asignatura";
        this.comments = "Comentario";
        this.initialDate = new Date(2023-2-2);
        this.finishDate = new Date(2023-2-20);
        this.estudiantes = new ArrayList<>();
    }
}
