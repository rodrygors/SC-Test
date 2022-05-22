package com.project.example.controller;

import com.project.example.controller.DTO.FinancingRequestDTO;
import com.project.example.controller.DTO.SaveCalcInfoDTO;
import com.project.example.service.FinancingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancingController {
    private final FinancingService financingService;


    public FinancingController(FinancingService financingService) {
        this.financingService = financingService;
    }

    @CrossOrigin(origins = "http://localhost:3030")
    @PostMapping(value = "/calculate")
    public double calcMonthlyFee(@RequestBody FinancingRequestDTO financingParameters) {
        return financingService.calculate(financingParameters.getFinType(), financingParameters.getMonthNum(), financingParameters.getCarValue());
    }

    @CrossOrigin(origins = "http://localhost:3030")
    @PostMapping(value = "/save")
    public String saveInfo(@RequestBody SaveCalcInfoDTO info) {
        return financingService.saveInfo(info.getName(), info.getContact(), Float.parseFloat(info.getFinancingValue()));
    }
}
