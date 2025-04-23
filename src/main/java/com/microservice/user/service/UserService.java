package com.microservice.user.service;

import com.microservice.user.RoleEnum;
import com.microservice.user.dto.input.NewUserDto;
import com.microservice.user.exception.HttpException;
import com.microservice.user.mapper.UserEntityMapper;
import com.microservice.user.repository.crud.UserCrud;
import com.microservice.user.repository.entity.RoleEntity;
import com.microservice.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    

    private final UserCrud userCrud;

    private final RoleService roleService;

    private final UserEntityMapper userEntityMapper;

    public void saveNormalUser(NewUserDto newUserDto){
        try{
            RoleEntity roleEntity = roleService.getRoleById(RoleEnum.USER.getRoleCode());
            UserEntity user = userEntityMapper.toUserEntity(newUserDto, roleEntity);
            userCrud.save(user);
        }catch(Exception exception){
            throw new HttpException("Error trying save user.", HttpStatus.BAD_REQUEST);
        }
    }

    



}
