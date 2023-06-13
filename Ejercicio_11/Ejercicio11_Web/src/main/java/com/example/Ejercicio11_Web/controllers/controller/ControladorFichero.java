package com.example.Ejercicio11_Web.controllers.controller;

import com.example.Ejercicio11_Web.application.fichero.FicheroService;
import com.example.Ejercicio11_Web.classes.Fichero;
import com.example.Ejercicio11_Web.repository.FicheroRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("api/ficheros")
public class ControladorFichero {
    @Autowired
    private FicheroService fs;

    @PostMapping
    public Fichero guardarFichero(@RequestParam("file") MultipartFile file,
                                  @RequestParam("categoria") String categoria) throws IOException {
            return fs.guardarFichero(file, categoria);
    }

    @PostMapping("upload/{tipo}")
    private Fichero addFicheroTipo(@RequestParam("file") MultipartFile file,
                                   @RequestParam("categoria") String categoria, @PathVariable String tipo) throws IOException {
        return fs.addFicheroTipo(file, categoria, tipo);
    }

    @GetMapping("/{id}")
    public void obtenerFicheroPorId(@PathVariable("id") Long id) throws IOException {
        fs.obtenerFicheroPorId(id);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public void obtenerFicheroPorNombre(@PathVariable("nombre") String nombre) throws IOException {
        fs.obtenerFicheroPorNombre(nombre);
    }

    @GetMapping("setpath")
    public void obtenerFicheroCarpetaEspedicifica(@RequestParam("path") String path) throws IOException {
       fs.obtenerFicheroCarpetaEspedicifica(path);
    }

}
