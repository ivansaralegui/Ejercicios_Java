package com.example.Ejercicio7_Validacion.classes;

import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idProfesor;
    @OneToOne
    @JoinColumn(name="id_persona", nullable = false, unique = true)
    Persona persona;
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    List<Estudiante> estudiantes;
    String comments;
    @NotNull
    String branch;

    public Profesor (ProfesorInputDTO profesorInputDTO, Persona persona) {
        this.persona = persona;
        this.comments = profesorInputDTO.getComments();
        this.branch = profesorInputDTO.getBranch();
    }

    public ProfesorOutputDTO parseProfesorOutputDTO(Profesor profesor) {
        ProfesorOutputDTO poDTO = new ProfesorOutputDTO();
        poDTO.setIdProfesor(profesor.getIdProfesor());
        poDTO.setPersona( new PersonaOutputDTO(profesor.getPersona()));
        poDTO.setComments(profesor.getComments());
        poDTO.setBranch(profesor.getBranch());
        return poDTO;
    }

}
