package org.chubaka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPage {

    @RequestMapping("/")
    public String showDemo() {
        return "demo";
    }
}
