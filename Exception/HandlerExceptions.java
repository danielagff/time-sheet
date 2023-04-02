package com.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException e){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Not found!")
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(ExistsException e){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Already exists!")
                .message(e.getMessage())
                .status(HttpStatus.FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.FOUND);
    }

}
