package com.quickfix.app.service;

import com.quickfix.app.dto.VendorServiceRequest;
import com.quickfix.app.dto.VendorServiceResponse;
import com.quickfix.app.entity.ServiceEntity;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.entity.VendorService;
import com.quickfix.app.repositoty.ServiceRepository;
import com.quickfix.app.repositoty.VendorRepository;
import com.quickfix.app.repositoty.VendorServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceService {

    private final VendorRepository vendorRepository;
    private final ServiceRepository serviceRepository;
    private final VendorServiceRepository vendorServiceRepository;

    public VendorServiceService(
            VendorRepository vendorRepository,
            ServiceRepository serviceRepository,
            VendorServiceRepository vendorServiceRepository
    ) {
        this.vendorRepository = vendorRepository;
        this.serviceRepository = serviceRepository;
        this.vendorServiceRepository = vendorServiceRepository;
    }

    public List<VendorServiceResponse> getVendorServices(String vendorEmail) {

        Vendor vendor = vendorRepository.findByEmail(vendorEmail)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        return vendorServiceRepository.findByVendor(vendor)
                .stream()
                .map(vs -> new VendorServiceResponse(
                        vs.getService().getId(),
                        vs.getService().getName(),
                        vs.getServiceRadiusKm(),
                        vs.isActive()
                ))
                .collect(Collectors.toList());
    }

    public void addServiceToVendor(
            String vendorEmail,
            VendorServiceRequest request
    ) {

        Vendor vendor = vendorRepository.findByEmail(vendorEmail)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        if (vendorServiceRepository.existsByVendorAndService(vendor, service)) {
            throw new RuntimeException("Service already added by vendor");
        }

        VendorService vendorService = new VendorService();
        vendorService.setVendor(vendor);
        vendorService.setService(service);
        vendorService.setServiceRadiusKm(request.getServiceRadiusKm());
        vendorService.setActive(request.isActive());

        vendorServiceRepository.save(vendorService);
    }
}
