package com.service.servicebasedsystem.Services;


import com.service.servicebasedsystem.Model.*;
import com.service.servicebasedsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check if the user is a client
        Client client = clientRepository.findByUsername(username).orElse(null);
        if (client != null) {
            return client;
        }

        // Check if the user is a company
        Company company = companyRepository.findByName(username).orElse(null);
        if (company != null) {
            return company;
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}