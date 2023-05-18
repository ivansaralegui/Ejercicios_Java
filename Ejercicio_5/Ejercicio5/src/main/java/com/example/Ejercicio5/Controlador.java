package com.example.Ejercicio5;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.filter.ThresholdFilter;

@RestController
public class Controlador {

    Clase1 c1;

    Clase2 c2;

    Clase3 c3;

    LeerValores lv;

    public Controlador(Clase1 c1, Clase2 c2, Clase3 c3, LeerValores lv) throws Exception{
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.lv = lv;

    }

    @GetMapping("/")
    public String mostrar() {
        return lv.mostrarValores();
    }


}
