package com.timesheet.Exception;

public class ExistsException extends RuntimeException{
    public ExistsException(String message) {
        super(message);
    }
}
