package com.project.example.exception;

public class MonthNumberInvalid extends RuntimeException{
    public MonthNumberInvalid() { super("\nNumber of months inserted invalid.\n***\nOnly multiples of 12 accepted.\nFor internal financing: 12 <= Number of Months <= 60\nFor external financing: 12 <= Number of Months <= 48\n***");}
    public MonthNumberInvalid(String message) { super(message);}
}
