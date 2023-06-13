package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idEstudiante;
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false, unique = true)
    Persona persona;
    int numHoursWeek;
    String comments;
    @ManyToOne
    @JoinColumn(name= "id_profesor")
    Profesor profesor;
    @ManyToMany(mappedBy = "estudiantes")
    List<Asignatura> asignaturas;
    String branch;

    public Estudiante (EstudianteInputDTO estudianteInputDTO, Persona persona, Profesor profesor) {
        this.persona = persona;
        this.numHoursWeek = estudianteInputDTO.getNumHoursWeek();
        this.profesor = profesor;
        this.branch = estudianteInputDTO.getBranch();
        asignaturas=new ArrayList<>();
    }




}
