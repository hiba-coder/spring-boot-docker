package com.example.spring_docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot !";
    }
}