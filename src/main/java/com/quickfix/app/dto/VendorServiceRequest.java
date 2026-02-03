package com.quickfix.app.dto;

public class VendorServiceRequest {

    private Long serviceId;
    private Integer serviceRadiusKm;
    private boolean active;

    public VendorServiceRequest() {}

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceRadiusKm() {
        return serviceRadiusKm;
    }

    public void setServiceRadiusKm(Integer serviceRadiusKm) {
        this.serviceRadiusKm = serviceRadiusKm;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

