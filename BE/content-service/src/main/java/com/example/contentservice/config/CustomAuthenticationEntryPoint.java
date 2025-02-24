package com.example.reviewservice.config;

import com.example.reviewservice.dtos.ApiResponse;
import com.example.reviewservice.dtos.ResponseFalseToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final AuthenticationEntryPoint delegate = new BearerTokenAuthenticationEntryPoint();
    private final ObjectMapper mapper;

    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

// Hàm này sử lí exeption ở lớp filter khi sai token, còn nếu sai tk mk thì xử lí ở controller được
//       default nó kh có response body
        // hàm này ghi đè lại để trả ra body thông báo theo í mình( trả ra 1 object )
        this.delegate.commence(request, response, authException);
        response.setContentType("application/json;charset=UTF-8");

        ResponseFalseToken responseFalseToken = new ResponseFalseToken();
        responseFalseToken.setStatus("token het han");

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(responseFalseToken);
        apiResponse.setMessage("False !");
        apiResponse.setStatus(401);

        mapper.writeValue(response.getWriter(), apiResponse);
    }

}
