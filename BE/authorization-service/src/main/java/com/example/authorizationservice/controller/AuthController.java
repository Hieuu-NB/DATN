package com.example.authorizationservice.controller;

import com.example.authorizationservice.dto.ApiResponse;
import com.example.authorizationservice.dto.AuthResponse;
import com.example.authorizationservice.dto.Users;
import com.example.authorizationservice.service.UserDetailsCustom;
import com.example.authorizationservice.util.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserDetailsCustom userDetailsCustom;

    private final JwtUtils jwtUtils;


    public AuthController(PasswordEncoder passwordEncoder, AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsCustom userDetailsCustom, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsCustom = userDetailsCustom;
//        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody Users users) {
        // boc tài khoản mật kaaruu của đầu vào
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword());

        // xác thực người dùng, cần viết hàm loadUserByUsername
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        UserDetails userDetails = userDetailsCustom.loadUserByUsername(users.getPassword());

        String token = this.jwtUtils.generateAccessToken(userDetails);

        //khi login
        // set thông tin người dùng vào context ( có thể sử dụng sau này )
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(token);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(authResponse);
        apiResponse.setMessage("Success !");
        apiResponse.setStatus(200);


        return apiResponse;
    }

    @GetMapping("/user/{s}")
    public String createNewUser(@PathVariable String s) {
        return this.passwordEncoder.encode(s);
    }


    @GetMapping("/user")
    public String test() {
        return "hieu2002";
    }



}
