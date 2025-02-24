package com.example.learningservice.service;

import com.example.learningservice.dtos.ResultDto;
import com.example.learningservice.dtos.UsersDto;
import com.example.learningservice.entitys.Users;
import com.example.learningservice.repository.UserRepository;
import com.example.learningservice.service.feign.FeignService;
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
