package com.service.servicebasedsystem.Repository;


import com.service.servicebasedsystem.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username); // Find client by username
}