package com.quickfix.app.config;

import com.quickfix.app.entity.ServiceEntity;
import com.quickfix.app.repositoty.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceInitializer implements CommandLineRunner {

    private final ServiceRepository serviceRepository;

    public ServiceInitializer(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void run(String... args) {

        List<String> defaultServices = List.of(
                "PLUMBER",
                "ELECTRICIAN",
                "CARPENTER",
                "AC_REPAIR",
                "BARBER",
                "HOUSE_CLEANING",
                "CAR_MECHANIC",
                "BIKE_MECHANIC"
        );

        for (String serviceName : defaultServices) {
            if (!serviceRepository.existsByName(serviceName)) {
                serviceRepository.save(new ServiceEntity(serviceName));
            }
        }
    }
}
