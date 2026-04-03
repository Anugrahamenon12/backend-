package com.carbon.app.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculateEmission(double electricity, double fuel) {
        return (electricity * 0.5) + (fuel * 2.3);
    }
}
