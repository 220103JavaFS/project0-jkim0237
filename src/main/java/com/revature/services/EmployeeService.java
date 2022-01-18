package com.revature.services;


import com.revature.models.Customer;
import com.revature.repos.EmployeeDAO;
import com.revature.repos.EmployeeDAOImpl;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public List<Customer> findAllCustomers(){

        return employeeDAO.findAllCustomers();
    }

    public Customer findByUsername(String username){

        return employeeDAO.findByUsername(username);
    }

}
