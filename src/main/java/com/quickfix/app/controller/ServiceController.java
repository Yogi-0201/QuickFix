package com.quickfix.app.controller;

import com.quickfix.app.entity.ServiceEntity;
import com.quickfix.app.repositoty.ServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // 🌍 PUBLIC API
    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }
}

