package com.vikas.EcomProductService.Controller.ControllerAdvice;

import com.sun.net.httpserver.HttpsServer;
import com.vikas.EcomProductService.DTO.ErrorResponseDTO;
import com.vikas.EcomProductService.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(Exception ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setMessageCode(404);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
