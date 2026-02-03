package com.quickfix.app.dto;

public class VendorResponseDto {

    private Long id;
    private String name;
    //private String phone;
    private String address;
    private Double latitude;
    private Double longitude;

    public VendorResponseDto(Long id, String name, String phone,
                             String address, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        //this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //public String getPhone() {
     //   return phone;
    //}

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}

