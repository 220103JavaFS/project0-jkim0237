package com.revature.services;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImpl;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean addCustomer(Customer customer) {

        return customerDAO.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {

        return customerDAO.updateCustomer(customer);
    }

    public boolean login(String username, String password) {

        return customerDAO.Login(username, password);

//    public boolean depositSaving(BankAccount bankAccount){
//        if(bankAccount.getSavingAmount() = )
    }
}
