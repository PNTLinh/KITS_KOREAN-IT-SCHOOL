package com.topcit.aims.aims.controller;

import com.topcit.aims.aims.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // API login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email,
                                        @RequestParam String password) {
        boolean success = authService.login(email, password);
        if (success) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
