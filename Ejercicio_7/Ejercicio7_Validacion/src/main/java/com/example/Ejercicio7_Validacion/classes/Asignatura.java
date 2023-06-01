package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_asignatura;
    @ManyToMany
    Set<Estudiante> estudiantes;
    String asignatura;
    String comments;
    @NotNull
    Date initial_date;
    Date finish_date;

    public Asignatura (AsignaturaInputDTO asignaturaInputDTO) {
        this.id_asignatura = asignaturaInputDTO.getId_asignatura();
        this.asignatura = asignaturaInputDTO.getAsignatura();
        this.comments = asignaturaInputDTO.getComments();
        this.initial_date = asignaturaInputDTO.getInitial_date();
        this.finish_date = asignaturaInputDTO.getFinish_date();
    }

    public AsignaturaSimpleOutputDTO parseAsignaturaSimpleOutputDTO(Asignatura asignatura) {
        AsignaturaSimpleOutputDTO aoDTO = new AsignaturaSimpleOutputDTO();
        aoDTO.setId_asignatura(asignatura.getId_asignatura());
        aoDTO.setAsignatura(asignatura.getAsignatura());
        aoDTO.setComments(asignatura.getComments());
        aoDTO.setInitial_date(asignatura.getInitial_date());
        aoDTO.setFinish_date(asignatura.getFinish_date());
        return aoDTO;
    }

    public AsignaturaFullOutputDTO parseAsignaturaFullOutputDTO(Asignatura asignatura) {
        AsignaturaFullOutputDTO aoDTO = new AsignaturaFullOutputDTO();
        aoDTO.setId_asignatura(asignatura.getId_asignatura());
        aoDTO.setAsignatura(asignatura.getAsignatura());
        aoDTO.setComments(asignatura.getComments());
        aoDTO.setEstudiantes(asignatura.getEstudiantes());
        aoDTO.setInitial_date(asignatura.getInitial_date());
        aoDTO.setFinish_date(asignatura.getFinish_date());
        return aoDTO;
    }
}
