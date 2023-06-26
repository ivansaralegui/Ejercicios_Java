package com.example.Ejercicio7_Validacion;

import com.example.Ejercicio7_Validacion.application.asignatura.AsignaturaService;
import com.example.Ejercicio7_Validacion.application.asignatura.AsignaturaServiceImpl;
import com.example.Ejercicio7_Validacion.application.estudiante.EstudianteService;
import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.profesor.ProfesorService;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
public class AsignaturaTest {

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    AsignaturaService asignaturaService;

    @Autowired
    EstudianteService estudianteService;

    @AfterEach
    void reiniciarTodo() {
        Iterable<ProfesorOutputDTO> listProf = profesorService.getAllProfesores();

        listProf.forEach(pro -> {
            try {
                profesorService.deleteProfesorById(pro.getIdProfesor());
            } catch (EntityNotFoundException e) {

            }
        });

        Iterable<PersonaOutputDTO> list = personaService.getAllPersonas();

        list.forEach(per -> {
            try {
                personaService.deletePersonaById(per.getIdPersona());
            } catch (EntityNotFoundException e) {

            }
        });

        Iterable<AsignaturaFullOutputDTO> listAsig = asignaturaService.getAllAsignatura();

        listAsig.forEach(asig -> {
            try {
                asignaturaService.deleteAsignaturaById(asig.getIdAsignatura());
            } catch (EntityNotFoundException e) {

            }
        });
    }

    AsignaturaFullOutputDTO addAsignaturaPrueba() {
        AsignaturaInputDTO asignaturaInputDTO = new AsignaturaInputDTO();

        return asignaturaService.addAsignatura(asignaturaInputDTO);
    }

    @Test
    void addAsignaturaTest() {
        AsignaturaInputDTO asignaturaInputDTO = new AsignaturaInputDTO();

        AsignaturaFullOutputDTO result = asignaturaService.addAsignatura(asignaturaInputDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getIdAsignatura(), asignaturaService.getAllAsignatura().get(0).getIdAsignatura());
    }

    @Test
    void getAsignaturaByIdTest() {
        addAsignaturaPrueba();

        AsignaturaFullOutputDTO result = asignaturaService.getAsignaturaById(asignaturaService.getAllAsignatura().stream().toList().get(0).getIdAsignatura());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getIdAsignatura(), asignaturaService.getAllAsignatura().stream().toList().get(0).getIdAsignatura());

    }

    @Test
    void updateAsignatura() {
        addAsignaturaPrueba();

        int id = asignaturaService.getAllAsignatura().stream().toList().get(0).getIdAsignatura();

        AsignaturaInputDTO asignaturaInputDTO = new AsignaturaInputDTO(id, "newAsignatura", "newComentario",
                new Date(2023-5-21), new Date(2023-6-2), asignaturaService.getAllAsignatura().stream().toList().get(0).getEstudiantes());

        AsignaturaSimpleOutputDTO result = asignaturaService.updateAsignatura(id, asignaturaInputDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getIdAsignatura(), asignaturaInputDTO.getIdAsignatura());
        Assertions.assertEquals(result.getNombreAsignatura(), asignaturaInputDTO.getAsignaturaNombre());

    }

    @Test
    void deleteAsignaturaByIdTest() {
        addAsignaturaPrueba();

        int id = asignaturaService.getAllAsignatura().stream().toList().get(0).getIdAsignatura();

        asignaturaService.deleteAsignaturaById(id);
    }

}
