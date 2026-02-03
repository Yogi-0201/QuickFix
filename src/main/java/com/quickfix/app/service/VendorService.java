package com.quickfix.app.service;

import com.quickfix.app.dto.VendorRegisterRequest;
import com.quickfix.app.entity.Role;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.repositoty.RoleRepository;
import com.quickfix.app.repositoty.VendorRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public VendorService(
            VendorRepository vendorRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.vendorRepository = vendorRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerVendor(VendorRegisterRequest request) {

        // 1️⃣ Check email uniqueness
        if (vendorRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Vendor email already registered");
        }

        // 2️⃣ Fetch ROLE_VENDOR
        Role vendorRole = roleRepository
                .findByName("ROLE_VENDOR")
                .orElseThrow(() -> new RuntimeException("ROLE_VENDOR not found"));

        // 3️⃣ Create Vendor entity
        Vendor vendor = new Vendor();
        vendor.setName(request.getName());
        vendor.setEmail(request.getEmail());
        vendor.setPhone(request.getPhone());
        vendor.setAddress(request.getAddress());

        // 🔐 Encrypt password
        vendor.setPassword(passwordEncoder.encode(request.getPassword()));

        // Vendor initially inactive (recommended)
        vendor.setAvailable(false);

        // Assign role
        vendor.assignRole(vendorRole);

        // 4️⃣ Save
        vendorRepository.save(vendor);
    }

    public void updateAvailability(boolean available) {

        // Get logged-in vendor email from JWT
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Vendor vendor = vendorRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        vendor.setAvailable(available);
        vendorRepository.save(vendor);
    }


}
