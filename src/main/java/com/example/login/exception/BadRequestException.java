package com.example.login.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BadRequestException extends RuntimeException{
    private String messeage;

    public BadRequestException(String message, String messeage) {
        super();
    }
}
