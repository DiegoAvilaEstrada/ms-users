package com.microservice.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends RuntimeException{

    private Object data;

    public UserException(String message, Object data) {
        super(message);
        this.data = data;
    }
}
