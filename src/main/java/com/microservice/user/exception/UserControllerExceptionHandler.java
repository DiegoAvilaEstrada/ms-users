package com.microservice.user.exception;


import com.microservice.user.controller.UserController;
import com.microservice.user.dto.output.ResponseHttpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerExceptionHandler {


    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<ResponseHttpDto> handleException(HttpException httpException){
        return ResponseEntity.status(httpException.getHttpStatus()).body(new ResponseHttpDto(httpException.getHttpStatus().value(),httpException.getMessage()));
    }

//    @ExceptionHandler(value = HttpException.class)
//    public ResponseEntity<ResponseHttpDto> handleExceptionWithData(HttpException httpException){
//        return ResponseEntity.status(httpException.getHttpStatus()).body(new ResponseHttpDto(httpException.getHttpStatus().value(),httpException.getMessage(), httpException.getDataException()));
//    }

}
