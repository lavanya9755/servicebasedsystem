package com.service.servicebasedsystem.Model;


import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Ad ad;
    private String status; // PENDING, APPROVED, REJECTED
    // Getters and Setters
}
