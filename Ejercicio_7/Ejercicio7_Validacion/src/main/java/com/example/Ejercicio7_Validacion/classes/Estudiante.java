package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_student;
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false, unique = true)
    Persona id_persona;
    @NotNull
    int num_hours_week;
    String comments;
    @ManyToOne
    @JoinColumn(name= "id_profesor")
    Profesor id_profesor;
    @ManyToMany(mappedBy = "estudiantes")
    Set<Asignatura> asignatura;
    @NotNull
    String branch;

    public Estudiante (EstudianteInputDTO estudianteInputDTO, Persona persona, Profesor profesor) {
        this.id_persona = persona;
        this.num_hours_week = estudianteInputDTO.getNum_hours_week();
        this.id_profesor = profesor;
        this.branch = estudianteInputDTO.getBranch();
    }

    public EstudianteSimpleOutputDTO parseEstudianteSimpleOutputDTO(Estudiante estudiante) {
        EstudianteSimpleOutputDTO eoDTO = new EstudianteSimpleOutputDTO();
        eoDTO.setId_student(estudiante.getId_student());
        eoDTO.setId_persona(estudiante.getId_persona());
        eoDTO.setNum_hours_week(estudiante.getNum_hours_week());
        eoDTO.setProfesor(estudiante.getId_profesor());
        eoDTO.setBranch(estudiante.getBranch());
        return eoDTO;
    }

    public EstudianteFullOutputDTO parseEstudianteFullOutputDTO(Estudiante estudiante) {
        EstudianteFullOutputDTO eoDTO = new EstudianteFullOutputDTO();
        eoDTO.setId_student(estudiante.getId_student());
        eoDTO.setId_persona(estudiante.getId_persona());
        eoDTO.setNum_hours_week(estudiante.getNum_hours_week());
        eoDTO.setProfesor(estudiante.getId_profesor());
        eoDTO.setBranch(estudiante.getBranch());
//        for (int i = 0; i < estudiante.getAsignatura().size(); i++) {
        eoDTO.setAsignatura(estudiante.getAsignatura());
//        }
        return eoDTO;
    }

}
