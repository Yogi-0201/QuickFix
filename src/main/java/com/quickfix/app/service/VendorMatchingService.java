package com.quickfix.app.service;


import com.quickfix.app.dto.VendorResponseDto;
import com.quickfix.app.entity.ServiceEntity;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.entity.VendorService;
import com.quickfix.app.repositoty.ServiceRepository;
import com.quickfix.app.repositoty.VendorServiceRepository;
import com.quickfix.app.util.DistanceCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class VendorMatchingService {

    private final ServiceRepository serviceRepository;
    private final VendorServiceRepository vendorServiceRepository;

    public VendorMatchingService(ServiceRepository serviceRepository,
                                 VendorServiceRepository vendorServiceRepository) {
        this.serviceRepository = serviceRepository;
        this.vendorServiceRepository = vendorServiceRepository;
    }

    public List<VendorResponseDto> findNearbyVendors(
            String serviceName,
            double userLat,
            double userLon,
            int page,
            int size,
            String sortBy) {

        ServiceEntity service = serviceRepository.findByName(serviceName)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        List<VendorService> vendorServices =
                vendorServiceRepository.findByServiceAndActiveTrue(service);

        List<VendorResponseDto> results = new ArrayList<>();

        for (VendorService vs : vendorServices) {

            Vendor vendor = vs.getVendor();

            if (!vendor.isAvailable()) continue;
            if (vendor.getLatitude() == null || vendor.getLongitude() == null) continue;

            double distance = DistanceCalculator.calculateDistance(
                    userLat, userLon,
                    vendor.getLatitude(), vendor.getLongitude()
            );

            if (distance <= vs.getServiceRadiusKm()) {
                results.add(new VendorResponseDto(
                        vendor.getId(),
                        vendor.getName(),
                        vendor.getPhone(),
                        vendor.getAddress(),
                        vendor.getLatitude(),
                        vendor.getLongitude()
                ));
            }
        }

        // 🔹 Sorting
        if ("name".equalsIgnoreCase(sortBy)) {
            results.sort(Comparator.comparing(VendorResponseDto::getName));
        }

        // 🔹 Pagination
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, results.size());

        if (fromIndex >= results.size()) {
            return List.of();
        }

        return results.subList(fromIndex, toIndex);
    }




}
