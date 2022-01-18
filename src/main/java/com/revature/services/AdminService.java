package com.revature.services;

import com.revature.models.Customer;
import com.revature.repos.AdminDAO;
import com.revature.repos.AdminDAOImpl;

import java.util.List;

public class AdminService {

    private AdminDAO adminDAO = new AdminDAOImpl();

    public List<Customer> findAllCustomers(){

        return adminDAO.findAllCustomers();
    }
    public Customer findByUsername(String username){

        return adminDAO.findByUsername(username);
    }
    public boolean addCustomer(Customer customer){

        return adminDAO.addCustomer(customer);
    }

}
