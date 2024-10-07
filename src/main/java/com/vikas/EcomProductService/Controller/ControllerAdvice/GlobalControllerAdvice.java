package com.vikas.EcomProductService.Controller.ControllerAdvice;

import com.sun.net.httpserver.HttpsServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(Exception ex){
        String exceptionResponse =
                "error" + ex.getMessage() + ", code :  " + HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.ok(exceptionResponse);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(Exception ex){
        String exceptionResponse =
                "ye wala error hai bhai :-> " + ex.getMessage() + ", code :  " + HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.ok(exceptionResponse);
    }
}
