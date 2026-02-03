package com.quickfix.app.service;

import com.quickfix.app.dto.RegisterRequest;
import com.quickfix.app.entity.Role;
import com.quickfix.app.entity.User;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.repositoty.RoleRepository;
import com.quickfix.app.repositoty.UserRepository;
import com.quickfix.app.repositoty.VendorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final VendorRepository vendorRepository;

    public UserService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder, VendorRepository vendorRepository
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.vendorRepository = vendorRepository;
    }

    public void registerUser(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.assignRole(userRole);

        userRepository.save(user);
    }

    public String getVendorPhone(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        if (!vendor.isAvailable()) {
            throw new RuntimeException("Vendor not available");
        }

        return vendor.getPhone();
    }

}
