package com.example.Ejercicio11_Web.application.fichero;

import com.example.Ejercicio11_Web.classes.Fichero;
import com.example.Ejercicio11_Web.repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FicheroServiceImpl implements FicheroService{

    @Autowired
    private FicheroRepository ficheroRepository;

    private String RUTA = "c:/tmp/";

    @Override
    public Fichero guardarFichero(MultipartFile file, String categoria) throws IOException {
        Fichero fichero = new Fichero();
        fichero.setNombre(file.getOriginalFilename());
        fichero.setFechaSubida(new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
        fichero.setCategoria(categoria);
        ficheroRepository.save(fichero);

        // Guardar el fichero en disco
        // Puedes utilizar la ruta especificada en el parámetro 'path' o una ruta por defecto
        String path = RUTA + file.getOriginalFilename();
        file.transferTo(new File(path));

        return fichero;
    }

    @Override
    public Fichero addFicheroTipo(MultipartFile file, String categoria, String tipo) throws IOException {
        Fichero fichero = new Fichero();
        String extensionArchivo = file.getOriginalFilename().toString();
        int index = extensionArchivo.lastIndexOf(".");
        if (index <= 0) {
            throw new IOException("Faltan datos");
        }
        String extension = extensionArchivo.substring(index + 1);
        if (extension.equals(tipo)) {
            fichero.setNombre(file.getOriginalFilename());
            fichero.setFechaSubida(new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
            fichero.setCategoria(categoria);
            ficheroRepository.save(fichero);
        } else {
            throw new IOException("El tipo del fichero no es el correcto");
        }
        // Guardar el fichero en disco
        // Puedes utilizar la ruta especificada en el parámetro 'path' o una ruta por defecto
        String path = RUTA + file.getOriginalFilename();
        file.transferTo(new File(path));

        return fichero;
    }

    @Override
    public void obtenerFicheroPorId(Long id) throws IOException {
        Fichero fichero = ficheroRepository.findById(id).orElse(null);
        String pathFichero = RUTA + fichero.getNombre();
        File file = new File(pathFichero);
        String pathDestino = RUTA + "Descargas/" + fichero.getNombre();
        File destino = new File(pathDestino);
        Files.copy(file.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public void obtenerFicheroPorNombre(String nombre) throws IOException {
        for(Fichero fichero: ficheroRepository.findAll()) {
            if (fichero.getNombre().equals(nombre)) {
                String pathFichero = RUTA + fichero.getNombre();
                File file = new File(pathFichero);
                String pathDestino = RUTA + "Descargas/" + fichero.getNombre();
                File destino = new File(pathDestino);
                Files.copy(file.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    @Override
    public void obtenerFicheroCarpetaEspedicifica(String path) throws IOException {
        RUTA = path;
    }
}
