package com.example.reviewservice.service;

import com.example.reviewservice.dtos.ResultDto;
import com.example.reviewservice.dtos.UsersDto;
import com.example.reviewservice.entitys.Users;
import com.example.reviewservice.repository.UserRepository;
import com.example.reviewservice.service.feign.FeignService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final FeignService feignService;

    @Override
    public ResultDto register(UsersDto usersDto) {
        try {
//            OAuth2AuthenticationToken oAuth2AuthenticationToken = new OAuth2AuthenticationToken();
//            feignService.endFlow();

            Users users = mapper.map(usersDto, Users.class);
            userRepository.save(users);

        } catch (Exception e) {
            return ResultDto.builder().code(400).message(e.getMessage()).build();
        }
        return ResultDto.builder().code(200).message("thanh cong").build();
    }


    @Override
    public Map<String, Object> registerByGoogle() {
            return feignService.endFlow();
    }

    @Override
    public String testFeign() {
        return feignService.endFlow1();
    }
}
