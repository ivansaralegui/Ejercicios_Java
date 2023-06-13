package com.example.Ejercicio11_Web.application.fichero;

import com.example.Ejercicio11_Web.classes.Fichero;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FicheroService {

    Fichero guardarFichero(@RequestParam("file") MultipartFile file, @RequestParam("categoria") String categoria) throws IOException;

    Fichero addFicheroTipo(@RequestParam("file") MultipartFile file, @RequestParam("categoria") String categoria, @PathVariable String tipo) throws IOException;

    void obtenerFicheroPorId(@PathVariable("id") Long id) throws IOException;

    void obtenerFicheroPorNombre(@PathVariable("nombre") String nombre) throws IOException;

    void obtenerFicheroCarpetaEspedicifica(@RequestParam("path") String path) throws IOException;



}
