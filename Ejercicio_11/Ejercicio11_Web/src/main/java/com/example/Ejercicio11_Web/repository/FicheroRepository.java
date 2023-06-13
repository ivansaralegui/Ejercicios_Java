package com.example.Ejercicio11_Web.repository;

import com.example.Ejercicio11_Web.classes.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheroRepository extends JpaRepository<Fichero, Long> {
    Fichero findByNombre(String nombre);
}