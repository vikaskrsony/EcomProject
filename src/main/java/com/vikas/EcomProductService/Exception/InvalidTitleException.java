package com.vikas.EcomProductService.Exception;

public class InvalidTitleException extends RuntimeException {
    public InvalidTitleException() {
    }

    public InvalidTitleException(String message) {
        super(message);
    }


}
