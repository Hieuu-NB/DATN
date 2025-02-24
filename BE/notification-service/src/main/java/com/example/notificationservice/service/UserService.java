package com.example.learningservice.service;

import com.example.learningservice.dtos.ResultDto;
import com.example.learningservice.dtos.UsersDto;

import java.util.Map;

public interface UserService {
    ResultDto register(UsersDto usersDto);
    Map<String, Object> registerByGoogle();

    String testFeign();

}
