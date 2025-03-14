package com.service.servicebasedsystem.Model;


import jakarta.persistence.*;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private Company company;
    // Getters and Setters
}

