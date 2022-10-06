package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user-service")
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
        return String.format("It's Working is User Service on Port: %s",
                env.getProperty("local.server.port"));
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
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(requestUser, userDto);
        userService.createUser(userDto);
        ResponseUser responseUser = new ResponseUser();
        BeanUtils.copyProperties(userDto, responseUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        List<UserEntity> userList = userService.getUserByAll();
        List<ResponseUser> result = new ArrayList<>();
        userList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseUser.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ModelMapper().map(userDto, ResponseUser.class));
    }
}
