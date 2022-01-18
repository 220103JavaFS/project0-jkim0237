package com.revature.controllers;

import com.revature.services.EmployeeService;
import io.javalin.Javalin;

public class EmployeeController implements Controller{

    private EmployeeService employeeService = new EmployeeService();

    @Override
    public void addRoutes(Javalin app) {

    }
}
