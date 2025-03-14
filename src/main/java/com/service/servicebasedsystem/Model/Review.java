package com.service.servicebasedsystem.Model;

import jakarta.persistence.*;
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Ad ad;
    private String comment;
    private int rating;
 
}