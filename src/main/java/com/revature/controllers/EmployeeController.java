package com.revature.controllers;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.services.EmployeeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeController implements Controller {

    private EmployeeService employeeService = new EmployeeService();

    Handler getCustomers = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            ctx.json(employeeService.findAllCustomers());
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    Handler getCustomer = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            String userName = ctx.pathParam("userName");
            Customer customer = employeeService.findCustomerByUsername(userName);
            ctx.json(customer);
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getBankAccounts = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            List<BankAccount> ba =  employeeService.findAllBankAccounts();
            ctx.json(ba);

            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/customer", getCustomers);
        app.get("/customer/{userName}", getCustomer);
        app.get("/bankaccounts", getBankAccounts);
    }
}

