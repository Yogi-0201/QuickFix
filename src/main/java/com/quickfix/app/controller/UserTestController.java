package com.quickfix.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserTestController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public String userTest() {
        return "USER API WORKS";
    }

    @PostMapping("/call/{vendorId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getVendorPhone(
            @PathVariable Long vendorId
    ) {
        UserTestController userService = new UserTestController();
        String phone = String.valueOf(userService.getVendorPhone(vendorId));
        return ResponseEntity.ok(phone);
    }

}


