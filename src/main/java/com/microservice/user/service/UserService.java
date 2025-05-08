package com.microservice.user.service;

import com.microservice.user.RoleEnum;
import com.microservice.user.exception.HttpException;
import com.microservice.user.mapper.UserEntityMapper;
import com.microservice.user.model.HttpResponseCommonDto;
import com.microservice.user.model.NewUserRequestDto;
import com.microservice.user.model.UserResponse;
import com.microservice.user.repository.crud.UserCrud;
import com.microservice.user.repository.entity.RoleEntity;
import com.microservice.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    

    private final UserCrud userCrud;

    private final RoleService roleService;

    private final UserEntityMapper userEntityMapper;

    private final PasswordService passwordService;

    public HttpResponseCommonDto saveNormalUser(NewUserRequestDto newUserDto){
        try{
            RoleEntity roleEntity = roleService.getRoleById(RoleEnum.USER.getRoleCode());
            UserEntity user = userEntityMapper.toUserEntity(newUserDto, roleEntity);
            userCrud.save(user);
            HttpResponseCommonDto httpResponseCommonDto = new HttpResponseCommonDto();
            httpResponseCommonDto.message("The user was saved successfully");
            httpResponseCommonDto.statusCode(String.valueOf(HttpStatus.CREATED));
            return httpResponseCommonDto;
        }catch(Exception exception){
            throw new HttpException("Error trying save user.", HttpStatus.BAD_REQUEST);
        }
    }


    public UserResponse getUserByUsernamePassword(String username, String password){
        Optional<UserEntity> userFound = userCrud.getByUsername(username);

        if(userFound.isEmpty() || !passwordService.validatePassword(password,userFound.get().getPassword())){
            throw new HttpException("Credentials incorrect",HttpStatus.NOT_FOUND);
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(userFound.get().getUsername());
        userResponse.setEmail(userFound.get().getEmail());
        userResponse.setName(userFound.get().getFullName());
        return userResponse;
    }



}
