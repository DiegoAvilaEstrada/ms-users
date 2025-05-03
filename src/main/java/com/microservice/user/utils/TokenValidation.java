package com.microservice.user.utils;

import com.microservice.user.config.properties.TokenProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenValidation {

    private final TokenProperties tokenProperties;

    public Boolean validateAuthorizationToken(String token){
        return tokenProperties.getToken().equals(token);
    }
}
