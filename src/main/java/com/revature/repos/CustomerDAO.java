package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.UserDTO;


public interface CustomerDAO {



    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean depositSaving(BankAccount bankAccount);

    boolean Login(String username, String password);



}
