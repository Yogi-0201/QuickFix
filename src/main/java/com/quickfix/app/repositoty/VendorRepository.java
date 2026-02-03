package com.quickfix.app.repositoty;

import com.quickfix.app.entity.User;
import com.quickfix.app.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
