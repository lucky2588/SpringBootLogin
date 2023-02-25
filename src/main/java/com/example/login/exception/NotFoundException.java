package com.example.login.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private String messeage;

    public NotFoundException(String message, String messeage) {
        super(message);
    }
}
