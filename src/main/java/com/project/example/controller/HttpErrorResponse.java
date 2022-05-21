package com.project.example.controller;


import java.time.LocalDateTime;

public class HttpErrorResponse {
    private int status;
    private String Error;

    public HttpErrorResponse(int status, String error, LocalDateTime timestamp) {
        this.status = status;
        Error = error;
        this.timestamp = timestamp;
    }

    private LocalDateTime timestamp;
}
