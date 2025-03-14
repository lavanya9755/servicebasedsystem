package com.service.servicebasedsystem.Services;

import com.service.servicebasedsystem.Model.Company;
import com.service.servicebasedsystem.Repository.CompanyRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company registerCompany(Company company) {
        return companyRepository.save(company);
    }

    public Optional<Company> loginCompany(String name, String password) {
        return companyRepository.findByName(name);
    }
}