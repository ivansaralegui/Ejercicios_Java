package com.example.Ejercicio11_Web.repository;


import com.example.Ejercicio11_Web.classes.Estudiante;
import com.example.Ejercicio11_Web.classes.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    Optional<Estudiante> findByPersona(Persona p);
}
