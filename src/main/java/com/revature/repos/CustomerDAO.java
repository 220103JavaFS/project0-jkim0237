package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.UserDTO;


public interface CustomerDAO {



    public boolean addCustomer(Customer customer);
    public boolean depositSaving(BankAccount bankAccount);

    public boolean Login(String username, String password);



}
