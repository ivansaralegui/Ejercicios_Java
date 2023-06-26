package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAsignatura;
    @ManyToMany
    List<Estudiante> estudiantes;
    String asignaturaNombre;
    String comments;
    @NotNull
    Date initialDate;
    Date finishDate;

    public Asignatura (AsignaturaInputDTO asignaturaInputDTO) {
        this.idAsignatura = asignaturaInputDTO.getIdAsignatura();
        this.asignaturaNombre = asignaturaInputDTO.getAsignaturaNombre();
        this.comments = asignaturaInputDTO.getComments();
        this.initialDate = asignaturaInputDTO.getInitialDate();
        this.finishDate = asignaturaInputDTO.getFinishDate();
    }

    public AsignaturaSimpleOutputDTO parseAsignaturaSimpleOutputDTO(Asignatura asignatura) {
        AsignaturaSimpleOutputDTO aoDTO = new AsignaturaSimpleOutputDTO();
        aoDTO.setIdAsignatura(asignatura.getIdAsignatura());
        aoDTO.setNombreAsignatura(asignatura.getAsignaturaNombre());
        aoDTO.setComments(asignatura.getComments());
        aoDTO.setInitialDate(asignatura.getInitialDate());
        aoDTO.setFinishDate(asignatura.getFinishDate());
        return aoDTO;
    }

    public AsignaturaFullOutputDTO parseAsignaturaFullOutputDTO(Asignatura asignatura) {
        AsignaturaFullOutputDTO aoDTO = new AsignaturaFullOutputDTO();
        aoDTO.setIdAsignatura(asignatura.getIdAsignatura());
        aoDTO.setNombreAsignatura(asignatura.getAsignaturaNombre());
        aoDTO.setComments(asignatura.getComments());
//        aoDTO.setEstudiantes( asignatura.getEstudiantes().
//                stream().map(EstudianteSimpleOutputDTO::new).collect(Collectors.toList()));
        aoDTO.setInitialDate(asignatura.getInitialDate());
        aoDTO.setFinishDate(asignatura.getFinishDate());
        return aoDTO;
    }
}
