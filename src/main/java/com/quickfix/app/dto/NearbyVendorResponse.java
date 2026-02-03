package com.quickfix.app.dto;

public class NearbyVendorResponse {

    private Long vendorId;
    private String vendorName;
    private String phone;
    private String address;
    private double distanceKm;

    public NearbyVendorResponse() {}

    public NearbyVendorResponse(
            Long vendorId,
            String vendorName,
            String phone,
            String address,
            double distanceKm
    ) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.phone = phone;
        this.address = address;
        this.distanceKm = distanceKm;
    }

    // getters & setters

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    @Override
    public String toString() {
        return "NearbyVendorResponse{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", distanceKm=" + distanceKm +
                '}';
    }
}

