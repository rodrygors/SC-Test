package com.project.example.exception;

public class InternalError extends RuntimeException{
    public InternalError() { super("Internal Error.");}
    public InternalError(String message) { super(message);}
}
