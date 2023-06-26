package com.example.Ejercicio7_Validacion;

import com.example.Ejercicio7_Validacion.application.asignatura.AsignaturaService;
import com.example.Ejercicio7_Validacion.application.estudiante.EstudianteService;
import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.profesor.ProfesorService;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.asignaturaDTO.AsignaturaSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteFullOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.estudainteDTO.EstudianteSimpleOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.profesorDTO.ProfesorOutputDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class EstudianteTest {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorService profesorService;

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

        Iterable<EstudianteFullOutputDTO> listEst = estudianteService.getAllEstudiantes();

        listEst.forEach(est -> {
            try {
                estudianteService.deleteEstudianteById(est.getIdEstudiante());
            } catch (EntityNotFoundException e) {

            }
        });
}

EstudianteFullOutputDTO addEstudiantePrueba() throws Exception {
    PersonaInputDTO personaInputDTO = new PersonaInputDTO("IvanSC", "contrasenia", "Ivan", "Saralegui",
            "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
            "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

    personaService.addPersona(personaInputDTO);

    PersonaInputDTO personaInputDTO2 = new PersonaInputDTO("LucasSC", "contrasenia", "Lucas", "Saralegui",
            "lucassc.company@gmail.com", "lucassc.personal@gmail.com", "Najera", true, new Date(2023 - 05 - 02),
            "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

    personaService.addPersona(personaInputDTO2);

    ProfesorInputDTO profesorInputDTO = new ProfesorInputDTO(personaService.getAllPersonas().stream().toList().get(0).getIdPersona());

    profesorService.addProfesor(profesorInputDTO);

    EstudianteInputDTO estudianteInputDTO = new EstudianteInputDTO(personaService.getAllPersonas().stream().toList().get(1).getIdPersona(), 20, "Comentario",
            profesorService.getAllProfesores().stream().toList().get(0).getIdProfesor(), "Branch");

    return estudianteService.addEstudiante(estudianteInputDTO);
}

    @Test
    void addEstudianteTest() throws Exception {
        PersonaInputDTO personaInputDTO = new PersonaInputDTO("IvanSC", "contrasenia", "Ivan", "Saralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        PersonaInputDTO personaInputDTO2 = new PersonaInputDTO("LucasSC", "contrasenia", "Lucas", "Saralegui",
                "lucassc.company@gmail.com", "lucassc.personal@gmail.com", "Najera", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        personaService.addPersona(personaInputDTO);
        personaService.addPersona(personaInputDTO2);

        ProfesorInputDTO profesorInputDTO = new ProfesorInputDTO(personaService.getAllPersonas().stream().toList().get(0).getIdPersona());

        profesorService.addProfesor(profesorInputDTO);

        EstudianteInputDTO estudianteInputDTO = new EstudianteInputDTO(personaService.getAllPersonas().stream().toList().get(1).getIdPersona(), 20, "Comentario",
                profesorService.getAllProfesores().stream().toList().get(0).getIdProfesor(), "Branch");

        EstudianteFullOutputDTO result = estudianteService.addEstudiante(estudianteInputDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getPersona().getIdPersona(), estudianteInputDTO.getIdPersona());
    }

    @Test
    void getEstudianteSimpleByIdTest() throws Exception {
        addEstudiantePrueba();

        int id = estudianteService.getAllEstudiantes().stream().toList().get(0).getIdEstudiante();

        EstudianteSimpleOutputDTO result = estudianteService.getEstudianteSimpleById(id);
        Assertions.assertNotNull(result);
    }

    @Test
    void getEstudianteFullByIdTest() throws Exception {
        addEstudiantePrueba();

        int id = estudianteService.getAllEstudiantes().stream().toList().get(0).getIdEstudiante();

        EstudianteFullOutputDTO result = estudianteService.getEstudianteFullById(id);
        Assertions.assertNotNull(result);
    }

    @Test
    void updateEstudianteTest() throws Exception {
        addEstudiantePrueba();

        int idProfesor = estudianteService.getAllEstudiantes().stream().toList().get(0).getProfesor().getIdProfesor();
        int idPersona = estudianteService.getAllEstudiantes().stream().toList().get(0).getPersona().getIdPersona();
        int idEstudiante = estudianteService.getAllEstudiantes().stream().toList().get(0).getIdEstudiante();

        EstudianteInputDTO estudianteInputDTO = new EstudianteInputDTO(idPersona, 40, "newComentario",
                idProfesor, "newBranch");

        EstudianteSimpleOutputDTO result = estudianteService.updateEstudiante(idEstudiante, estudianteInputDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getIdEstudiante(), idEstudiante);
        Assertions.assertEquals(result.getBranch(), estudianteInputDTO.getBranch());
        Assertions.assertEquals(result.getComments(), estudianteInputDTO.getComments());
        Assertions.assertEquals(result.getNumHoursWeek(), estudianteInputDTO.getNumHoursWeek());
    }

    @Test
    void deleteEstudianteByIdTest() throws Exception {
        addEstudiantePrueba();

        int id = estudianteService.getAllEstudiantes().stream().toList().get(0).getIdEstudiante();

        estudianteService.deleteEstudianteById(id);
    }

}
