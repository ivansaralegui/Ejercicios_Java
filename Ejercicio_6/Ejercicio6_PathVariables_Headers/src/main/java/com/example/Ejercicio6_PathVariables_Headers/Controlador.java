package com.example.Ejercicio6_PathVariables_Headers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/controlador")
public class Controlador {

    @PostMapping("/greeting")
    @ResponseBody
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting(greeting.getId(), greeting.getName());
    }

    @GetMapping({"/user/{id}", "/user"})
    @ResponseBody
    public Greeting getGreeting(@PathVariable(value = "id") Optional<Long> id){
        return id.isPresent()? new Greeting(id.get(), "Nombre Por Defecto"): new Greeting(0, "No encontrado");
    }

    @PutMapping("/greeting/put")
    @ResponseBody
    public HashMap<Long, Long> putGreeting(@RequestParam("var1") Long var1, @RequestParam("var2") Long var2) {
        return new HashMap<Long, Long>(){{
            put(var1, var2);
        }};
    }

}

