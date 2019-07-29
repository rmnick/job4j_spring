package ru.job4j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/create")
public class CreateController {

    @RequestMapping(method = RequestMethod.GET)
    public String showCreateView() {
        return "create";
    }
}
