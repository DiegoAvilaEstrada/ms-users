package com.microservice.user.controller;

import com.microservice.user.api.UserApi;
import com.microservice.user.exception.HttpException;
import com.microservice.user.model.HttpResponseCommonDto;
import com.microservice.user.model.NewUserRequestDto;
import com.microservice.user.model.UserResponse;
import com.microservice.user.service.UserService;
import com.microservice.user.utils.TokenValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {

    private final TokenValidation tokenValidation;

    private final UserService userService;

    @Override
    public ResponseEntity<HttpResponseCommonDto> createUser(String xAuthorization, NewUserRequestDto newUserRequestDto) {

        if(!tokenValidation.validateAuthorizationToken(xAuthorization)){
            throw new HttpException("The token is not validate", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(userService.saveNormalUser(newUserRequestDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponse> getUser(String xAuthorization, String user, String password) {
        return new ResponseEntity<>(userService.getUserByUsernamePassword(user,password), HttpStatus.OK);
    }
}
