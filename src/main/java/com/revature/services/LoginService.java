package com.revature.services;

import com.revature.models.UserDTO;
import com.revature.repos.CustomerDAO;
import com.revature.repos.CustomerDAOImpl;


public class LoginService {

    private CustomerDAO customerDAO = new CustomerDAOImpl();
    public boolean login(String username, String password){
        return customerDAO.Login(username, password);
    }
}

