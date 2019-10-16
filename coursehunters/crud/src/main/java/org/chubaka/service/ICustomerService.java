package org.chubaka.service;

import org.chubaka.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(int id);
}
