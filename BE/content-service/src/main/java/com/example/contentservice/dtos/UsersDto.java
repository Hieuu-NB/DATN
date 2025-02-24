package com.example.reviewservice.dtos;

import com.example.reviewservice.enums.UserRole;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {

    private UUID id;
    private String username;
    private String email;
    private String passwordHash;
    private UserRole role;
    private String phone;
    private String avatarUrl;
    private Date createdAt;
}
