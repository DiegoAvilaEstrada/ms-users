package com.microservice.user.mapper;


import com.microservice.user.model.NewUserRequestDto;
import com.microservice.user.repository.entity.RoleEntity;
import com.microservice.user.repository.entity.UserEntity;
import com.microservice.user.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class UserEntityMapper {

    private final PasswordService passwordService;

    public UserEntity toUserEntity(NewUserRequestDto newUserDto, RoleEntity roleEntity){

        return UserEntity.builder()
                .fullName(newUserDto.getFullName())
                .username(newUserDto.getUserName())
                .email(newUserDto.getEmail())
                .phone(newUserDto.getPhone())
                .password(passwordService.hashPassword(newUserDto.getPassword()))
                .approved(Boolean.FALSE)
                .tsInsert(LocalDateTime.now())
                .role(roleEntity)
                .build();
    }


}
