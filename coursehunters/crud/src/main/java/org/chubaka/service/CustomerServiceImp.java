package org.chubaka.service;

import org.chubaka.dao.ICustomerDao;
import org.chubaka.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImp implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public Customer deleteCustomer(int id) {
        return customerDao.deleteCustomer(id);
    }
}
