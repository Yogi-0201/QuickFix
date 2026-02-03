package com.quickfix.app.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "vendor123";
        String encoded = encoder.encode(rawPassword);
        System.out.println(encoded);
    }
}
