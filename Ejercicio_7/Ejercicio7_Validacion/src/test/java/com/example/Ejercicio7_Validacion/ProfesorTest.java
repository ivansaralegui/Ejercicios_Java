package com.example.Ejercicio7_Validacion;

import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.profesor.ProfesorService;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.classes.Profesor;
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

import java.util.Date;

@SpringBootTest
public class ProfesorTest {

    @Autowired
    ProfesorService profesorService;

    @Autowired
    PersonaService personaService;

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
    }

    ProfesorOutputDTO addProfesorPrueba() throws Exception {
        PersonaInputDTO personaInputDTO = new PersonaInputDTO("IvanSC", "contrasenia", "Ivan", "Saralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        personaService.addPersona(personaInputDTO);

        ProfesorInputDTO profesorInputDTO = new ProfesorInputDTO(personaService.getAllPersonas().stream().toList().get(0).getIdPersona());

        return profesorService.addProfesor(profesorInputDTO);
    }

    @Test
    void addProfesorTest() throws Exception {
        PersonaInputDTO personaInputDTO = new PersonaInputDTO("IvanSC", "contrasenia", "Ivan", "Saralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        personaService.addPersona(personaInputDTO);

        ProfesorInputDTO profesorInputDTO = new ProfesorInputDTO(personaService.getAllPersonas().stream().toList().get(0).getIdPersona());

        ProfesorOutputDTO result = profesorService.addProfesor(profesorInputDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(profesorInputDTO.getIdPersona(), result.getPersona().getIdPersona());
    }

    @Test
    void getProfesorByIdTest() throws Exception {
        addProfesorPrueba();

        int id = profesorService.getAllProfesores().stream().toList().get(0).getIdProfesor();

        ProfesorOutputDTO result = profesorService.getProfesorById(id);
        Assertions.assertNotNull(result);
    }

    @Test
    void updateProfesorTest() throws Exception {
        addProfesorPrueba();

        int idProfesor = profesorService.getAllProfesores().stream().toList().get(0).getIdProfesor();
        int idPersona = profesorService.getAllProfesores().stream().toList().get(0).getPersona().getIdPersona();

        ProfesorInputDTO profesorInputDTO = new ProfesorInputDTO(idProfesor, idPersona, "newComment", "newBranch");

        ProfesorOutputDTO result = profesorService.updateProfesor(idProfesor, profesorInputDTO);

        Assertions.assertEquals(result.getIdProfesor(), profesorInputDTO.getIdProfesor());
        Assertions.assertEquals(result.getPersona().getIdPersona(), profesorInputDTO.getIdPersona());
        Assertions.assertEquals(result.getComments(), profesorInputDTO.getComments());
        Assertions.assertEquals(result.getBranch(), profesorInputDTO.getBranch());
    }

    @Test
    void deleteProfesorById() throws Exception {
        addProfesorPrueba();

        int id = profesorService.getAllProfesores().stream().toList().get(0).getIdProfesor();

        profesorService.deleteProfesorById(id);
    }

}
