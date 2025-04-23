package com.microservice.user.mapper;

import com.microservice.user.dto.input.NewUserDto;
import com.microservice.user.repository.entity.RoleEntity;
import com.microservice.user.repository.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserEntityMapper {

    public UserEntity toUserEntity(NewUserDto newUserDto, RoleEntity roleEntity){

        return UserEntity.builder()
                .fullName(newUserDto.getFullName())
                .username(newUserDto.getUserName())
                .email(newUserDto.getEmail())
                .phone(newUserDto.getPhone())
                .password(newUserDto.getPassword())
                .approved(Boolean.FALSE)
                .tsInsert(new Date())
                .role(roleEntity)
                .build();
    }


}
