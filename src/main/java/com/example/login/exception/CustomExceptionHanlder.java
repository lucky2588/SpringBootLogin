package com.example.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.BadLocationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHanlder{

    @ExceptionHandler(NotFoundException.class) // gọi đến các class có thể gọi
    public ResponseEntity<Object> NotFoundException(NotFoundException e){ // truyền vào class tự định nghĩa
        ErrorRespone errorRespone = new ErrorRespone(HttpStatus.NOT_FOUND,e.getMesseage());
        return new ResponseEntity<>(errorRespone,HttpStatus.NOT_FOUND);
    }
 // xử lí khi nó gặp Ex Bad_resquest
    @ExceptionHandler(BadRequestException.class) // gọi đến các class có thể gọi
    public ResponseEntity<Object> HandlenBadRequestException(BadRequestException e){ // truyền vào class tự định nghĩa
        ErrorRespone errorRespone = new ErrorRespone(HttpStatus.BAD_REQUEST,e.getMesseage());
        return new ResponseEntity<>(errorRespone,HttpStatus.BAD_REQUEST);
    }
// Xử lí tập trung các Ex chung chung
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> HandleOtherException(Exception e){
        ErrorRespone errorRespone = new ErrorRespone(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<>(errorRespone,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Xử lí bắt các Exception trong Validate ...

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<?> handleValidException(MethodArgumentNotValidException e){
       Map<String,String> listError = new HashMap<>();
       e.getBindingResult().getAllErrors().forEach( (error) -> {
                   String fieldName = ((FieldError) error).getField();
                   String errorMessage = error.getDefaultMessage();
           listError.put(fieldName,errorMessage);
               });
           ErrorRespone errorRespone = new ErrorRespone(HttpStatus.BAD_REQUEST,listError);
           return  new ResponseEntity<>(errorRespone,HttpStatus.BAD_REQUEST);
    }














}