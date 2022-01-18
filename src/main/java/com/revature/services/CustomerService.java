package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImpl;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean addCustomer(Customer customer){
        return customerDAO.addCustomer(customer);
    }
}
