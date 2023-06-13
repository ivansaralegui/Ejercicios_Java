package com.example.Ejercicio11_Web.repository;


import com.example.Ejercicio11_Web.classes.Persona;
import com.example.Ejercicio11_Web.classes.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    Optional<Profesor> findByPersona(Persona p);
}
