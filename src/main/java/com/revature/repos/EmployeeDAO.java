package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

import java.util.List;

public interface EmployeeDAO {

    List<Customer> findAllCustomers();
    Customer findCustomerByUsername(String username);
    List<BankAccount> findAllBankAccounts();
    boolean employeeLogin(String username, String password);
}
