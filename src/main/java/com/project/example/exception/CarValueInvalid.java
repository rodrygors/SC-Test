package com.project.example.exception;

public class CarValueInvalid extends RuntimeException{
    public CarValueInvalid() { super("Car Value Invalid.");}
    public CarValueInvalid(String message) { super(message);}
}
