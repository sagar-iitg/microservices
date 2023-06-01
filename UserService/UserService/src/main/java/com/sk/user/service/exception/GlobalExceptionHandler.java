package com.sk.user.service.exception;


import com.sk.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerNotFoundException(ResourceNotFoundException ex){

            String msg=ex.getMessage();
            ApiResponse response=ApiResponse.builder().message(msg).success(true).httpStatus(HttpStatus.NOT_FOUND).build();


            return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);


    }
}
