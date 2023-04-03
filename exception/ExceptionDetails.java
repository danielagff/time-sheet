package com.timesheet.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {

    private String message;

    private String title;

    private int status;

    private LocalDateTime timeStamp;
}