package com.example.Ejercicio7_Validacion.repository;

import com.example.Ejercicio7_Validacion.classes.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository  extends JpaRepository<Persona, Integer> {
}
