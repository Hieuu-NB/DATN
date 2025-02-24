package com.example.notificationservice.service;

import com.example.notificationservice.dtos.ResultDto;
import com.example.notificationservice.dtos.UsersDto;

import java.util.Map;

public interface UserService {
    ResultDto register(UsersDto usersDto);
    Map<String, Object> registerByGoogle();

    String testFeign();

}
