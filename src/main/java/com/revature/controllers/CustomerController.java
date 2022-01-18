package com.revature.controllers;

import com.revature.services.CustomerService;
import io.javalin.Javalin;

public class CustomerController implements Controller{

    private CustomerService customerService = new CustomerService();


    @Override
    public void addRoutes(Javalin app) {

    }
}
