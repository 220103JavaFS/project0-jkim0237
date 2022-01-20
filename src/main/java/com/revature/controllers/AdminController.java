package com.revature.controllers;

import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.services.AdminService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AdminController implements Controller{

    private AdminService adminService = new AdminService();

    Handler getEmployees = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            ctx.json(adminService.findAllEmployees());
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

//    Handler deleteCustomer = (ctx) -> {
//        if(ctx.req.getSession(false)!=null){
//            Customer customer = ctx.bodyAsClass(Customer.class);
//            if(adminService.deleteCustomer(customer)){
//                ctx.status(202);
//            }else {
//                ctx.status(400);
//            }
//        }else {
//            ctx.status(401);
//        }
//
//    };



    @Override
    public void addRoutes(Javalin app) {
        app.get("/employees", getEmployees);
    }
}
