package com.example.reviewservice.controller;

import com.example.reviewservice.dtos.UsersDto;
import com.example.reviewservice.service.UserService;
import com.example.reviewservice.service.feign.FeignService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userServicel;
    private final FeignService feignService;
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
        return "result 1111";
    }


    @GetMapping(value = "/edit-kong")
    public String test1(){
        return "edit-kong";
    }

    @GetMapping(value = "/edit-kong1")
    public String test2() throws Exception {
        String x;
        try{
            x = feignService.endFlow2();
        }catch (Exception e){
            System.out.println("Message : "+e.getMessage());
            throw new Exception(e.getMessage());
        }
        return x;
    }


    @GetMapping(value = "/testFeign")
    public String testFeign(){
        return feignService.endFlow2();
    }

    @GetMapping("/debug")
    public ResponseEntity<?> debug(HttpServletRequest request) {
        return ResponseEntity.ok(request.getHeader("Authorization"));
    }
}
