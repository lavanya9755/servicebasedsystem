package com.service.servicebasedsystem.Services;


import com.service.servicebasedsystem.Model.Client;
import com.service.servicebasedsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new client
    public Client registerClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword())); // Hash password
        return clientRepository.save(client);
    }

    // Login a client
    public Client loginClient(String username, String password) {
        Optional<Client> clientOpt = clientRepository.findByUsername(username);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            if (passwordEncoder.matches(password, client.getPassword())) { // Check if password matches
                return client;
            }
        }
        return null; // Return null if login fails
    }
}