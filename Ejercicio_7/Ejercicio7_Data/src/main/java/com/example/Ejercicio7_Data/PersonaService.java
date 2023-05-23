package com.example.Ejercicio7_Data;

public interface PersonaService {

    PersonaOutputDto addPersona(PersonaOutputDto persona);
    PersonaOutputDto getPersonaById(int id);
    void deletePersonaById(int id);
    Iterable<PersonaOutputDto> getAllPersonas(int numero, int tamanio);
    PersonaOutputDto updatePersona(PersonaInputDto persona);

}
