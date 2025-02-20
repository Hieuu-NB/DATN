package com.example.userservice.service;

import com.example.userservice.dtos.ResultDto;
import com.example.userservice.dtos.UsersDto;

import java.util.Map;

public interface UserService {
    ResultDto register(UsersDto usersDto);
    Map<String, Object> registerByGoogle();

    String testFeign();

}
