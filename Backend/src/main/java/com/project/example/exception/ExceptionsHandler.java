package com.project.example.exception;

import com.project.example.controller.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class ExceptionsHandler {
    @ExceptionHandler({MonthNumberInvalid.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpErrorResponse handleGenericException(MonthNumberInvalid exception) {
        return new HttpErrorResponse(
                400,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({FinancingTypeInvalid.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpErrorResponse handleGenericException(FinancingTypeInvalid exception) {
        return new HttpErrorResponse(
                400,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({InternalError.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpErrorResponse handleGenericException(InternalError exception) {
        return new HttpErrorResponse(
                400,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({CarValueInvalid.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpErrorResponse handleGenericException(CarValueInvalid exception) {
        return new HttpErrorResponse(
                400,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}
