package com.example.userservice.service.feign;

import com.example.userservice.utils.Constant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = Constant.NAME_SERVICE, url = "localhost:8091")
public interface FeignService {
    @GetMapping(path = Constant.SSO, headers = {"Content-Type=application/json", "Accept=application/json"})
    Map<String, Object> endFlow();


    @GetMapping(path = "/employee/user", headers = {"Content-Type=application/json", "Accept=application/json"})
    String endFlow1();

}

