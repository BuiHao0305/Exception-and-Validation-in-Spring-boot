package com.springpro.jpa.Exception;

import com.springpro.jpa.dto.ApiReponse;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GolbalExceptionHandler {

    // khi có exception xảy ra class này chịu trách nhiệm Handler message đó
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiReponse> handleRuntimeException(RuntimeException exception) {
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(1001);
        apiReponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }
    

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidationException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }

}
