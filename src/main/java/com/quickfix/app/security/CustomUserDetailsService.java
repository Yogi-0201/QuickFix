package com.quickfix.app.security;

import com.quickfix.app.entity.User;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.repositoty.UserRepository;
import com.quickfix.app.repositoty.VendorRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;

    public CustomUserDetailsService(
            UserRepository userRepository,
            VendorRepository vendorRepository
    ) {
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    List.of(new SimpleGrantedAuthority(user.getRole().getName()))
            );
        }

        Vendor vendor = vendorRepository.findByEmail(email).orElse(null);
        if (vendor != null) {
            return new org.springframework.security.core.userdetails.User(
                    vendor.getEmail(),
                    vendor.getPassword(),
                    List.of(new SimpleGrantedAuthority(vendor.getRole().getName()))
            );
        }

        throw new UsernameNotFoundException("User not found: " + email);
    }
}
