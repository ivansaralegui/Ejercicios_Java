package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionBean {

    public ConfiguracionBean() {
        System.out.println("Iniciando ConfiguracionBeans");
    }

    @Bean
    Componente3 getComponente3() {
        return new Componente3();
    }

    @Bean
    @Qualifier("comp1Bean")
    Componente1 getComponente1() {
        var c = new Componente1();
        c.nombre = "Nombre DE BEAN";
        return c;
    }



}
