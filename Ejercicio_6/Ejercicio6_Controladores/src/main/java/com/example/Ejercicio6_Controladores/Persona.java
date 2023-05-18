package com.example.Ejercicio6_Controladores;

public class Persona {

    String nombre;
    int edad;
    String ciudad;

    public Persona(String n, int e, String c) {
        this.nombre = n;
        this.edad = e;
        this.ciudad = c;
    }

    // GETTER

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    // SETTER

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
