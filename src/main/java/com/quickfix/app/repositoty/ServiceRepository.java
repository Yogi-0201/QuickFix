package com.quickfix.app.repositoty;

import com.quickfix.app.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    Optional<ServiceEntity> findByName(String name);
    boolean existsByName(String name);
}
