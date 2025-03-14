package com.service.servicebasedsystem.Controller;

import com.service.servicebasedsystem.Model.Company;
import com.service.servicebasedsystem.Services.CompanyService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/register")
    public String registerCompany(@ModelAttribute Company company) {
        companyService.registerCompany(company);
        return "redirect:/company/login";
    }

    @PostMapping("/login")
    public String loginCompany(@RequestParam String name, @RequestParam String password) {
        Optional<Company> company = companyService.loginCompany(name, password);
        if (company != null) {
            return "redirect:/company/dashboard";
        }
        return "redirect:/company/login";
    }
}