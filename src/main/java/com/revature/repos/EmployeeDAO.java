package com.revature.repos;

import com.revature.models.Customer;

import java.util.List;

public interface EmployeeDAO {

    public List<Customer> findAllCustomers();
    public Customer findByUsername(String username);
}
