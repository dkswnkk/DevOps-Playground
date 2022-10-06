package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

    private final Environment env;
    private final Greeting greeting;
    private final UserService userService;

    @Autowired
    public UserController(Environment env, Greeting greeting, UserService userService) {
        this.env = env;
        this.greeting = greeting;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's Working is User Service";
    }

    @GetMapping("/welcome_v1")
    public String welcome_v1() {
        return env.getProperty("greeting.message");
    }

    @GetMapping("/welcome_v2")
    public String welcome_v2() {
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public String createUser(@RequestBody RequestUser requestUser) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(requestUser, userDto);
        userService.createUser(userDto);
        return "Created user method is called.";
    }
}
