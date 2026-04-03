package com.carbon.app.controller;

import com.carbon.app.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @GetMapping
    public double calculate(@RequestParam double electricity,
                            @RequestParam double fuel) {
        return service.calculateEmission(electricity, fuel);
    }
}
