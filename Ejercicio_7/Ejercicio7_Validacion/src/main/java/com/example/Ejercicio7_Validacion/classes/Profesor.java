package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
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
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_profesor;
    @OneToOne
    @JoinColumn(name="id_persona", nullable = false, unique = true)
    Persona id_persona;
    @OneToMany(mappedBy = "id_profesor", cascade = CascadeType.ALL)
    Set<Estudiante> estudiantes;
    String comments;
    @NotNull
    String branch;

    public Profesor (ProfesorInputDTO profesorInputDTO, Persona persona) {

        this.id_persona = persona;
        this.comments = profesorInputDTO.getComments();
        this.branch = profesorInputDTO.getBranch();
    }

    public ProfesorOutputDTO parseProfesorOutputDTO(Profesor profesor) {
        ProfesorOutputDTO poDTO = new ProfesorOutputDTO();
        poDTO.setId_profesor(profesor.getId_profesor());
        poDTO.setId_persona(profesor.getId_persona());
        poDTO.setComments(profesor.getComments());
        poDTO.setBranch(profesor.getBranch());
        return poDTO;
    }

}
