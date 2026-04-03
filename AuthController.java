package com.carbon.app.controller;

import com.carbon.app.model.User;
import com.carbon.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password) {
        return authService.signup(username, email, password);
    }

    @PostMapping("/login")
    public Object login(@RequestParam String username,
                        @RequestParam String password) {
        return authService.login(username, password);
    }
}
