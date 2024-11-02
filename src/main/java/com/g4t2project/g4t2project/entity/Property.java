package com.g4t2project.g4t2project.entity;
import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonManagedReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "packageId")
    @JsonBackReference
    private CleaningPackage pkg;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CleaningTask> cleaningTasks = new ArrayList<CleaningTask>();

    private int numberOfRooms;
    private String address;
    private double latitude;
    private double longitude;
    // private String postalCode;

    protected Property() {}

    public Property(Client client, CleaningPackage pkg, String address, double latitude, double longitude) {
        this.client = client;
        this.pkg = pkg;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        // this.postalCode = postalCode;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCleaningTasks(List<CleaningTask> cleaningTasks) {
        this.cleaningTasks = cleaningTasks;
    }

    public Client getClient() {
        return client;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public List<CleaningTask> getCleaningTasks() {
        return cleaningTasks;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void addCleaningTask(CleaningTask cleaningTask) {
        cleaningTasks.add(cleaningTask);
    }

    public void removeCleaningTask(CleaningTask cleaningTask) {
        cleaningTasks.remove(cleaningTask);
    }

    // public String getPostalCode() {
    //     return postalCode;
    // }

    // public void setPostalCode(String postalCode) {
    //     this.postalCode = postalCode;
    // }

    public CleaningPackage getPkg() {
        return pkg;
    }

    public void setPkg(CleaningPackage pkg) {
        this.pkg = pkg;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    

}

