package com.project.example.exception;

public class FinancingTypeInvalid extends RuntimeException{
    public FinancingTypeInvalid() { super("Financing Type Invalid.\nChoose external or internal.");}
    public FinancingTypeInvalid(String message) { super(message);}
}
