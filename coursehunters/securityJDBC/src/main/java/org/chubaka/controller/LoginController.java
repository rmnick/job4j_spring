package org.chubaka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login-page";
    }

    @GetMapping("/access-denied")
    public String showDeniedPage() {
        return "deniedPage";
    }
}
