package com.quickfix.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
public class VendorTestController {

    @PreAuthorize("hasRole('VENDOR')")
    @GetMapping("/test")
    public String vendorTest() {
        return "VENDOR API WORKS";
    }
}

