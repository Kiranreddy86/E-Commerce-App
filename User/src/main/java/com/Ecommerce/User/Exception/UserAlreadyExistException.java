package com.Ecommerce.User.Exception;

import org.springframework.stereotype.Component;

@Component
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
