package org.chubaka.dao;


import org.chubaka.entity.Customer;

import java.util.List;

public interface ICustomerDao {

    List<Customer> getCustomers();
}
