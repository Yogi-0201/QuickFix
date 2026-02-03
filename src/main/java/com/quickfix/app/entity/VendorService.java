package com.quickfix.app.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "vendor_services",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"vendor_id", "service_id"})
        }
)
public class VendorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;

    public ServiceEntity getService() {
        return service;
    }

    @Setter
    @Column(nullable = false)
    private Integer serviceRadiusKm = 5;

    @Setter
    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // JPA requires no-arg constructor
    public VendorService() {
    }

    // Controlled constructor
    public VendorService(Vendor vendor, ServiceEntity service) {
        this.vendor = vendor;
        this.service = this.service;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters (NO setters for id, vendor, service, createdAt)
    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public ServiceEntity getServiceEntity() {
        return service;
    }

    public Integer getServiceRadiusKm() {
        return serviceRadiusKm;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "VendorService{" +
                "id=" + id +
                ", serviceRadiusKm=" + serviceRadiusKm +
                ", active=" + active +
                ", createdAt=" + createdAt +
                '}';
    }



}
