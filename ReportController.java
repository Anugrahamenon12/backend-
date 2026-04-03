package com.carbon.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @GetMapping
    public String getReport() {
        return "Carbon emission report generated";
    }
}
