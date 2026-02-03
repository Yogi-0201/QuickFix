package com.quickfix.app.controller;

import com.quickfix.app.dto.AuthResponse;
import com.quickfix.app.dto.LoginRequest;
import com.quickfix.app.dto.RegisterRequest;
import com.quickfix.app.security.jwt.JwtUtil;
import com.quickfix.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins =  "http://localhost:5173")
public class AuthController {

    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        userService.registerUser(request);

        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(authentication.getName());

        return ResponseEntity.ok(new AuthResponse(token));
    }


}
