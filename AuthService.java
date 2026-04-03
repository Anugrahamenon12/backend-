package com.carbon.app.service;

import com.carbon.app.model.User;
import com.carbon.app.repository.UserRepository;
import com.carbon.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String signup(String username, String email, String password) {
        Optional<User> existing = userRepository.findByUsername(username);

        if (existing.isPresent()) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // (In real apps → hash this)

        userRepository.save(user);
        return "User created successfully!";
    }

    public Object login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(password)) {
            return "Invalid username or password";
        }

        String token = JwtUtil.generateToken(username);

        return new AuthResponse(token, username);
    }

    // Inner response class
    static class AuthResponse {
        public String access_token;
        public String username;

        public AuthResponse(String token, String username) {
            this.access_token = token;
            this.username = username;
        }
    }
}
