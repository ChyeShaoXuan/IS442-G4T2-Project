package com.g4t2project.g4t2project.entity;
import jakarta.persistence.*;
import java.util.ArrayList;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    private String name;
    private String phoneNumber;
    private String email;

    @ManyToOne // Establishing Many-to-One relationship
    @JoinColumn(name = "workerId") // Foreign key in Client table
    private Worker preferredWorker;
    
    @OneToMany(mappedBy = "client")
    private ArrayList<Property> properties = new ArrayList<Property>();

    protected Client() {}

    public Client(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Worker getPreferredWorker() {
        return preferredWorker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPreferredWorker(Worker preferredWorker) {
        this.preferredWorker = preferredWorker;
    }
    
    
}
