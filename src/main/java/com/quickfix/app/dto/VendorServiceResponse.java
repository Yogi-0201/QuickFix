package com.quickfix.app.dto;

public class VendorServiceResponse {

    private Long serviceId;
    private String serviceName;
    private Integer serviceRadiusKm;
    private boolean active;

    public VendorServiceResponse() {}

    public VendorServiceResponse(
            Long serviceId,
            String serviceName,
            Integer serviceRadiusKm,
            boolean active
    ) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceRadiusKm = serviceRadiusKm;
        this.active = active;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Integer getServiceRadiusKm() {
        return serviceRadiusKm;
    }

    public boolean isActive() {
        return active;
    }
}
