package com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class EstudianteFullOutputDTO extends EstudianteSimpleOutputDTO
{
    PersonaOutputDTO persona;
    ProfesorOutputDTO profesor;
    List<AsignaturaSimpleOutputDTO> asignaturas;

    public EstudianteFullOutputDTO(Estudiante estudiante)
    {
        super(estudiante);
        persona= new PersonaOutputDTO(estudiante.getPersona());
        profesor=new ProfesorOutputDTO(estudiante.getProfesor());
        asignaturas=estudiante.getAsignaturas().stream()
                .map(AsignaturaSimpleOutputDTO::new).collect(Collectors.toList());
    }
}
