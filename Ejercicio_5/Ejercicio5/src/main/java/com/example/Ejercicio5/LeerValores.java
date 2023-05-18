package com.example.Ejercicio5;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
public class LeerValores {

    @Value("${greeting}")
    private String greet;
    @Value("${my.number}")
    private String num;

    @Value("${new.property: new.property no tiene valor}")
    private String pro;

    @Bean
    public String mostrarValores() {
        System.out.println("El valor de greeting es: " + greet);
        System.out.println("El valor de my.number es: " + num);
        System.out.println("El valor de my.property es: " + pro);

        return "El valor de greeting es: " + greet + "\n" +
                "El valor de my.number es: " + num + "\n" +
                "El valor de my.property es: " + pro;
    }

}
