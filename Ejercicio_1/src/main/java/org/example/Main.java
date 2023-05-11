package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    private static final String RUTA = "C:\\Users\\ivan.saralegui\\Desktop\\Carpeta_Ivan_Saralegui\\Curso_Java_9\\Ejercicios_Java\\Ejercicio_1\\src\\main\\resources\\people.csv";

    public static void main(String[] args) throws IOException {
        System.out.println("- Lista de Personas Válidas -");
        leerLista(listarPersonas(RUTA));
        System.out.println("****************");
        System.out.println("Ejercicio A - Listar Por Edad");
        leerLista(filtroEdad(listarPersonas(RUTA)));
        System.out.println("****************");
        System.out.println("Ejercicio B - Listar Por Inicial de Nombre");
        leerLista(filtroNombre(listarPersonas(RUTA)));
        System.out.println("****************");
        System.out.println("Ejercicio C - Listar Por Ciudad (Madrid)");
        leerLista(filtroCiudadMadrid(listarPersonas(RUTA)));
        System.out.println("****************");
        System.out.println("Ejercicio D - Listar Por Ciudad (Barcelona)");
        leerLista(filtroCiudadBarcelona(listarPersonas(RUTA)));

    }

    public static List<Persona> listarPersonas(String direccion) throws IOException {
        List<Persona> personas = new ArrayList<Persona>();
        Persona p;

        BufferedReader br = new BufferedReader(new FileReader(new File(direccion)));
        String linea = br.readLine();
        while (linea != null) {
            String[] campos = (linea.split(":"));
            int comprobar = campos.length;
            if (comprobar == 3) {
                if (campos[0] == null || campos[0].equals("")) {
                    linea = br.readLine();
                    continue;
                } else if (campos[1] == null || campos[1].equals("")) {
                    campos[1] = "*";
                    p = new Persona(campos[0], campos[1], Integer.parseInt(campos[2]));
                    personas.add(p);
                } else if (campos[2] == null || campos[2].equals("")) {
                    campos[2] = "0";
                    p = new Persona(campos[0], campos[1], Integer.parseInt(campos[2]));
                    personas.add(p);
                } else {
                    p = new Persona(campos[0], campos[1], Integer.parseInt(campos[2]));
                    personas.add(p);
                }
            } else {
                if (comprobar == 1) {
                    if (campos[0].matches("[0-9]")) {
                        linea = br.readLine();
                        continue;
                    } else {
                        p = new Persona(campos[0]);
                        personas.add(p);
                    }
                } else {
                    if (campos[1].matches("[0-9]")) {
                        p = new Persona(campos[0], "*", Integer.parseInt(campos[1]));
                        personas.add(p);
                    } else {
                        p = new Persona(campos[0], campos[1], 0);
                        personas.add(p);
                    }
                }
            }
            linea = br.readLine();

        }
        return personas;
    }

    private static void leerLista(List<Persona> lista){
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static List<Persona> filtroEdad(List<Persona> listaPersonas) {

        return listaPersonas.stream().filter((Persona persona) -> persona.getEdad() > 0 && persona.getEdad() < 25).collect(Collectors.toList());
    }

    private static List<Persona> filtroNombre(List<Persona> listaPersonas) {
        List<Persona> nuevaLista = listaPersonas.stream().filter(persona -> persona.getNombre().matches("[aáAÁ].*")).collect(Collectors.toList());
        for (Persona p: nuevaLista) {
            if (p.getCiudad().equals("*")) {
                p.setCiudad("unknown");
            }
        }
        return nuevaLista;
    }

    private static List<Persona> filtroCiudadMadrid(List<Persona> listaPersonas) {
        Optional<Persona> op =  listaPersonas.stream().filter(persona -> persona.getCiudad().equals("Madrid")).findFirst();
        return op.stream().toList();
    }

    private static List<Persona> filtroCiudadBarcelona(List<Persona> listaPersonas) {
        Optional<Persona> op =  listaPersonas.stream().filter(persona -> persona.getCiudad().equals("Barcelona")).findFirst();
        return op.stream().toList();
    }

}