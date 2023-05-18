package com.example.Ejercicio6_ControladoresPersonas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controlador")
public class Controlador3 {
    private Persona bean1;
    private Persona bean2;
    private Persona bean3;

    @Autowired
    public Controlador3(@Qualifier("bean1") Persona bean1,
                       @Qualifier("bean2") Persona bean2,
                       @Qualifier("bean3") Persona bean3) {
        this.bean1 = bean1;
        this.bean2 = bean2;
        this.bean3 = bean3;
    }

    @GetMapping("/bean/{bean}")
    @ResponseBody
    public Persona getBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return bean1;
            case "bean2":
                return bean2;
            case "bean3":
                return bean3;
            default:
                throw new IllegalArgumentException("Bean no encontrado");
        }
    }
}
