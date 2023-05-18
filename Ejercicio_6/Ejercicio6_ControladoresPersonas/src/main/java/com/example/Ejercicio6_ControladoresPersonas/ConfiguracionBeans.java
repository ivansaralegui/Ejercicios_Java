package com.example.Ejercicio6_ControladoresPersonas;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionBeans {
    @Bean
    @Qualifier("bean1")
    public Persona bean1() {
        return new Persona("Bean1", "Saco", 1);
    }

    @Bean
    @Qualifier("bean2")
    public Persona bean2() {
        return new Persona("Bean2", "Saco", 2);
    }

    @Bean
    @Qualifier("bean3")
    public Persona bean3() {
        return new Persona("Bean3", "Saco", 3);
    }
}