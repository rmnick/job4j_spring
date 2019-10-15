package org.chubaka.controller;

import org.chubaka.dao.CustomerDao;
import org.chubaka.dao.ICustomerDao;
import org.chubaka.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;


    @GetMapping("/list")
    public String showCustomers(Model model) {
        model.addAttribute("customers", service.getCustomers());
        return "customers-list";
    }
}
