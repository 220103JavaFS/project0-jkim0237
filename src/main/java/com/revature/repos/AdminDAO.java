package com.revature.repos;

import com.revature.models.Customer;

import java.util.List;

public interface AdminDAO {

    public List<Customer> findAllCustomers();
    public Customer findByUsername(String username);
    public boolean addCustomer(Customer customer);
//    public boolean deleteCustomer(Customer customer);
}
