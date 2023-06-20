package com.example.Ejercicio7_Validacion;

import com.example.Ejercicio7_Validacion.application.persona.PersonaService;
import com.example.Ejercicio7_Validacion.application.persona.PersonaServiceImpl;
import com.example.Ejercicio7_Validacion.classes.Persona;
import com.example.Ejercicio7_Validacion.controllers.dto.personaDTO.PersonaInputDTO;
import com.example.Ejercicio7_Validacion.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class PersonaTest {

        @Mock
        private PersonaRepository personaRepositoryMock;

        @InjectMocks
        private PersonaService personaService;

        @Test
        public void addPersonaTest() throws Exception {
                System.out.println("Test de ADDPERSONA");

                PersonaInputDTO personaInputDTO = new PersonaInputDTO(1, "IvanSC", "contrasenia", "Ivan", "Saralegui",
                        "ivansc.company@gmail.com","ivansc.personal@gmail.com", "Logrono", true, new Date(2023-05-02),
                        "https://i.ytimg.com/vi/KlosnRc26G8/maxresdefault.jpg", new Date(2023-05-21));
                Persona persona = new Persona(personaInputDTO);
                when(personaRepositoryMock.save(any())).thenReturn(persona);
                assertEquals(persona.parsePersonaOutputDTO(), personaService.addPersona(personaInputDTO));
        }

}
