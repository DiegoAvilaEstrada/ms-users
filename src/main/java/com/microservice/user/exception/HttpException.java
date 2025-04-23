package com.microservice.user.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class HttpException extends RuntimeException{

    private HttpStatus httpStatus;

    private Object dataException;

    public HttpException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpException(String message, HttpStatus httpStatus, Object dataException) {
        super(message);
        this.httpStatus = httpStatus;
        this.dataException = dataException;
    }

}
