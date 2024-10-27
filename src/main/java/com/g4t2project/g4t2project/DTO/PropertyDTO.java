package com.g4t2project.g4t2project.DTO;

public class PropertyDTO {
    private int propertyId;
    private int numberOfRooms;
    private String address;
    private double latitude;
    private double longitude;
    private String postalCode;

    // Constructors
    public PropertyDTO(int propertyId, int numberOfRooms, String address, double latitude, double longitude, String postalCode) {
        this.propertyId = propertyId;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
}
