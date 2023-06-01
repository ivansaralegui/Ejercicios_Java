package com.example.Ejercicio7_Validacion.repository;

import com.example.Ejercicio7_Validacion.classes.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
