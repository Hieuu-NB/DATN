package com.example.userservice.controller;

import com.example.userservice.dtos.UsersDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userServicel;
    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody UsersDto usersDto){
        return ResponseEntity.ok(userServicel.register(usersDto));
    }

    @GetMapping(value = "/a")
    public Map<String, Object> loginByGoogle(){
        System.out.println("hieu 2002");
        Map<String, Object> result = userServicel.registerByGoogle();
        System.out.println(result);
        return result;
    }

    @GetMapping(value = "/show")
    public String show(@RequestBody UsersDto usersDto){
        String x = usersDto.getUsername();
        return "result";
    }

    @GetMapping(value = "/test")
    public String test(){
        return "result 1";
    }


    @GetMapping(value = "/edit-kong")
    public String test1(){
        return "edit-kong";
    }

    @GetMapping(value = "/edit-kong1")
    public String test2(){
        return "edit-kong1";
    }


    @GetMapping(value = "/testFeign")
    public String testFeign(){
        return userServicel.testFeign();
    }
}
