package com.quickfix.app.controller;

import com.quickfix.app.dto.VendorRegisterRequest;
import com.quickfix.app.dto.VendorResponseDto;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.service.VendorMatchingService;
import com.quickfix.app.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorMatchingService vendorMatchingService;
    private final VendorService vendorService;

    public VendorController(VendorMatchingService vendorMatchingService, VendorService vendorService) {
        this.vendorMatchingService = vendorMatchingService;
        this.vendorService = vendorService;
    }

    @GetMapping("/nearby")
    public List<VendorResponseDto> getNearbyVendors(
            @RequestParam String service,
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort) {

        return vendorMatchingService.findNearbyVendors(
                service, lat, lon, page, size, sort
        );
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerVendor(
            @RequestBody VendorRegisterRequest request
    ) {
        vendorService.registerVendor(request);
        return ResponseEntity.ok("Vendor registered successfully");
    }

    @PutMapping("/availability")
    public ResponseEntity<String> updateAvailability(
            @RequestParam boolean available
    ) {
        vendorService.updateAvailability(available);
        return ResponseEntity.ok("Availability updated");
    }



}
