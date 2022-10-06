package com.example.userservice.controller;

import com.example.userservice.vo.Greeting;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    private final Environment env;
    private final Greeting greeting;

    @Autowired
    public UserController(Environment env, Greeting greeting) {
        this.env = env;
        this.greeting = greeting;
    }

    @GetMapping("/health_check")
    private String status() {
        return "It's Working is User Service";
    }

    @GetMapping("/welcome_v1")
    private String welcome_v1() {
        return env.getProperty("greeting.message");
    }

    @GetMapping("/welcome_v2")
    private String welcome_v2(){
        return greeting.getMessage();
    }

}
