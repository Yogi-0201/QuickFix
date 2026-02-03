package com.quickfix.app.controller;

import com.quickfix.app.dto.VendorServiceRequest;
import com.quickfix.app.service.VendorServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor/services")
public class VendorServiceController {

    private final VendorServiceService vendorServiceService;

    public VendorServiceController(VendorServiceService vendorServiceService) {
        this.vendorServiceService = vendorServiceService;
    }

    @PostMapping
    public ResponseEntity<String> addService(
            @RequestBody VendorServiceRequest request,
            Authentication authentication
    ) {

        String vendorEmail = authentication.getName();

        vendorServiceService.addServiceToVendor(vendorEmail, request);

        return ResponseEntity.ok("Service added to vendor");
    }

    @GetMapping
    public ResponseEntity<?> getMyServices(Authentication authentication) {

        String vendorEmail = authentication.getName();

        return ResponseEntity.ok(
                vendorServiceService.getVendorServices(vendorEmail)
        );
    }



}

