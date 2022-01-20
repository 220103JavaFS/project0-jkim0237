package com.revature.repos;

import com.revature.models.Customer;
import com.revature.models.Employee;

import java.util.List;

public interface AdminDAO {

    List<Customer> findAllCustomers();
    Customer findByUsername(String username);
    boolean addCustomer(Customer customer);
    List<Employee> findAllEmployees();
//    boolean deleteCustomer(Customer customer);
}
