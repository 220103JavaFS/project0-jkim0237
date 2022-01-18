package com.revature.controllers;

import com.revature.services.AdminService;
import io.javalin.Javalin;

public class AdminController implements Controller{

    private AdminService adminService = new AdminService();


    @Override
    public void addRoutes(Javalin app) {

    }
}
