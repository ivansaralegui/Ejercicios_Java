package com.example.Ejercicio6_ControladoresPersonas;

public class Ciudad {

    String nombre;
    int numeroHabitantes;

    public Ciudad(String n, int num) {
        this.nombre = n;
        this.numeroHabitantes = num;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
}
