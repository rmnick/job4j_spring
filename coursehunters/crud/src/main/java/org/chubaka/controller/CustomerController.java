package org.chubaka.controller;

import org.chubaka.entity.Customer;
import org.chubaka.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    //create or update
    @PostMapping("/saveCustomer")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        service.saveCustomer(customer);
        return "redirect:/customer/list/";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {
        System.out.println(service.getCustomer(id));
        model.addAttribute("customer", service.getCustomer(id));
        return "update-customer";
    }

}
