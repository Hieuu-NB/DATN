package com.example.reviewservice.service;

import com.example.reviewservice.dtos.ResultDto;
import com.example.reviewservice.dtos.UsersDto;

import java.util.Map;

public interface UserService {
    ResultDto register(UsersDto usersDto);
    Map<String, Object> registerByGoogle();

    String testFeign();

}
