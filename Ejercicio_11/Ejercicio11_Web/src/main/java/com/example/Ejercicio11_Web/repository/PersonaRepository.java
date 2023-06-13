package com.example.Ejercicio11_Web.repository;

import com.example.Ejercicio11_Web.classes.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository  extends JpaRepository<Persona, Integer> {
}
