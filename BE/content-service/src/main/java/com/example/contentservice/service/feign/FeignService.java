package com.example.reviewservice.service.feign;

import com.example.reviewservice.config.feignConfig.OAuth2FeignRequestInterceptor;
import com.example.reviewservice.utils.Constant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = Constant.NAME_SERVICE, url = "localhost:4321", configuration = OAuth2FeignRequestInterceptor.class)
public interface FeignService {
    @GetMapping(path = Constant.SSO, headers = {"Content-Type=application/json", "Accept=application/json"})
    Map<String, Object> endFlow();


    @GetMapping(path = "/employee/user", headers = {"Content-Type=application/json", "Accept=application/json"})
    String endFlow1();

    @GetMapping(path = "/abc", headers = {"Content-Type=application/json", "Accept=application/json"})
    String endFlow2();

}

