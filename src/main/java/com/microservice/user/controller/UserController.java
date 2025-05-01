package com.microservice.user.controller;




import com.microservice.user.api.UserApi;
import com.microservice.user.model.HttpResponseCommonDto;
import com.microservice.user.model.NewUserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<HttpResponseCommonDto> createUser(NewUserRequestDto newUserRequestDto) {
        return null;
    }
}
