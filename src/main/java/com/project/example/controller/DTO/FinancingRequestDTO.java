package com.project.example.controller.DTO;

public class FinancingRequestDTO {
    private String finType;
    private int monthNum;
    private double carValue;

    public String getFinType() {
        return finType;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public double getCarValue() {
        return carValue;
    }
}
