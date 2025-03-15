// ClientController.java
package com.service.servicebasedsystem.Controller;

import com.service.servicebasedsystem.Model.Client;
import com.service.servicebasedsystem.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client) {
        clientService.registerClient(client);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login.html page
    }
//     @GetMapping("/login")
// public String loginClient(@RequestParam String username, @RequestParam String password) {
//     Client client = clientService.loginClient(username, password);
//     if (client != null) {
//         return "redirect:/client/dashboard";
//     }
//     return "redirect:/login";
// }

}