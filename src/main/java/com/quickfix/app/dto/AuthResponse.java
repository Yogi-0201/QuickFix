package com.quickfix.app.dto;

public class AuthResponse {

    private String token;
    private String email;

    public AuthResponse(String token) {
        this.token = token;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }
}