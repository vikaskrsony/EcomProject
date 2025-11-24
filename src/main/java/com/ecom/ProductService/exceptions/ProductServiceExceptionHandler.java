package com.ecom.ProductService.exceptions;

import com.ecom.ProductService.dtos.ExceptionDTO;
import com.ecom.ProductService.dtos.ProductNotFoundExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    @Autowired
    HttpServletResponse httpServletResponse;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException() {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolutionDetails("You need to have valid details");

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(){
        ProductNotFoundExceptionDTO exceptionDTO = new ProductNotFoundExceptionDTO();
        exceptionDTO.setProductId(1);
        exceptionDTO.setMessage("Product Not Found with this id !");

        return new ResponseEntity<ProductNotFoundExceptionDTO>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
