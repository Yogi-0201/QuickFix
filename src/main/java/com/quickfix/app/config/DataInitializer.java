package com.quickfix.app.config;

import com.quickfix.app.entity.Role;
import com.quickfix.app.entity.ServiceEntity;
import com.quickfix.app.repositoty.RoleRepository;
import com.quickfix.app.repositoty.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final ServiceRepository serviceRepository;

    public DataInitializer(RoleRepository roleRepository, ServiceRepository serviceRepository) {
        this.roleRepository = roleRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void run(String... args) {

        System.out.println(">>> DataInitializer is running <<<");

        // ✅ INSERT ROLE_USER
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            roleRepository.save(new Role("ROLE_USER"));
            System.out.println("Inserted ROLE: ROLE_USER");
        }

        // ✅ INSERT ROLE_VENDOR
        if (roleRepository.findByName("ROLE_VENDOR").isEmpty()) {
            roleRepository.save(new Role("ROLE_VENDOR"));
            System.out.println("Inserted ROLE: ROLE_VENDOR");
        }

        System.out.println(">>> Initializing Services <<<");

        insertServiceIfNotExists("PLUMBER");
        insertServiceIfNotExists("ELECTRICIAN");
        insertServiceIfNotExists("CARPENTER");
        insertServiceIfNotExists("AC_REPAIR");
        insertServiceIfNotExists("HOUSE_CLEANING");
        insertServiceIfNotExists("BARBER");
        insertServiceIfNotExists("MECHANIC");

    }

    private void insertServiceIfNotExists(String name) {
        if (serviceRepository.findByName(name).isEmpty()) {
            serviceRepository.save(new ServiceEntity(name));
            System.out.println("Inserted Service: " + name);
        }
    }



}
