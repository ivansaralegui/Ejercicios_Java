package com.example.Ejercicio6_ControladoresPersonas;

public class Persona {

    String nombre;
    String ciudad;
    int edad;

    public Persona(String n, String c, int e) {
        this.nombre = n;
        this.ciudad = c;
        this.edad = e;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
