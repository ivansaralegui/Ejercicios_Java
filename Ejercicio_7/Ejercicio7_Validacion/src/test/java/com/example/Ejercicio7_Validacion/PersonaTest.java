package com.example.Ejercicio7_Validacion;

import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.persona.PersonaServiceImpl;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.controllers.controller.ControladorPersona;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaOutputDTO;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PersonaTest {

    @Autowired
    PersonaService personaService;

    @AfterEach
    void reiniciarTodo() {
        Iterable<PersonaOutputDTO> list = personaService.getAllPersonas();

        list.forEach(per -> {
            try {
                personaService.deletePersonaById(per.getIdPersona());
            } catch (EntityNotFoundException e) {

            }
        });
    }


    PersonaOutputDTO addPersonaPrueba() throws Exception {
        PersonaInputDTO personaInputDTO = new PersonaInputDTO( "IvanSC", "contrasenia", "Ivan", "Saralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

      return  personaService.addPersona(personaInputDTO);
    }


    // TEST DE ADDPERSONA FUNCIONAL
    @Test
    void addPersonaTest() throws Exception {

        PersonaInputDTO personaInputDTO = new PersonaInputDTO("IvanSC", "contrasenia", "Ivan", "Saralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        PersonaOutputDTO result = personaService.addPersona(personaInputDTO);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(personaInputDTO.getIdPersona(), result.getIdPersona());
    }

    // TEST DE ADDPERSONA CON ERROR
    @Test
    void addPersonaTestError() {
        PersonaInputDTO personaInputDTO = new PersonaInputDTO("", "contrasenia", "Ivan", "Saralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        Assertions.assertThrows(Exception.class, () -> personaService.addPersona(personaInputDTO));
    }

    @Test
    void getPersonaByIdTest() throws Exception {
        addPersonaPrueba();

        int id = personaService.getAllPersonas().stream().toList().get(0).getIdPersona();

        PersonaOutputDTO result = personaService.getPersonaById(id);
        Assertions.assertNotNull(result);

    }

    @Test
    void getPersonaByNameTest() throws Exception {
        String name = "Ivan";

        addPersonaPrueba();
        PersonaOutputDTO result = personaService.getPersonaByName(name);
        Assertions.assertNotNull(result);
    }

    @Test
    void updatePersonaTest() throws Exception {
        addPersonaPrueba();
        int id = personaService.getAllPersonas().stream().toList().get(0).getIdPersona();

        PersonaInputDTO personaInputDTO = new PersonaInputDTO(id, "newIvanSC", "contrasenia", "newIvan", "newSaralegui",
                "ivansc.company@gmail.com", "ivansc.personal@gmail.com", "Logrono", true, new Date(2023 - 05 - 02),
                "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023 - 05 - 21));

        PersonaOutputDTO result = personaService.updatePersona(id, personaInputDTO);

        Assertions.assertEquals(result.getIdPersona(), personaInputDTO.getIdPersona());
        Assertions.assertEquals(result.getUsuario(), personaInputDTO.getUsuario());
        Assertions.assertEquals(result.getName(), personaInputDTO.getName());
        Assertions.assertEquals(result.getCity(), personaInputDTO.getCity());
        Assertions.assertEquals(result.getActive(), personaInputDTO.getActive());
    }

    @Test
    void deletePersonaByIdTest() throws Exception {
        addPersonaPrueba();
        int id = personaService.getAllPersonas().stream().toList().get(0).getIdPersona();

        personaService.deletePersonaById(id);
    }


}
