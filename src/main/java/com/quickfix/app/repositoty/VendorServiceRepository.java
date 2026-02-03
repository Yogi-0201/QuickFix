package com.quickfix.app.repositoty;

import com.quickfix.app.entity.ServiceEntity;
import com.quickfix.app.entity.Vendor;
import com.quickfix.app.entity.VendorService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorServiceRepository extends JpaRepository<VendorService , Long> {

    List<VendorService> findByServiceAndActiveTrue(ServiceEntity service);

    List<VendorService> findByVendorAndActiveTrue(Vendor vendor);

    List<VendorService> findByVendor(Vendor vendor);

    List<VendorService> findByService_IdAndActiveTrue(Long serviceId);


    boolean existsByVendorAndService(Vendor vendor, ServiceEntity service);
}
