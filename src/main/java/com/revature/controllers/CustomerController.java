package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.models.UserDTO;
import com.revature.services.CustomerService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class CustomerController implements Controller{

    private CustomerService customerService = new CustomerService();

    private Handler customerLogin = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);

        if(customerService.login(user.username, user.password)){
            ctx.req.getSession();
            ctx.status(200);
        }else {
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }
    };

    private Handler logout = (ctx) -> {
        if(ctx.req.getSession(false) != null){
            ctx.req.getSession().invalidate();
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler newCustomer = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            Customer customer = ctx.bodyAsClass(Customer.class);
            if(customerService.addCustomer(customer)){
                ctx.status(201);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }

    };

    Handler updateCustomer = (ctx) -> {
        if(ctx.req.getSession(false)!=null){
            Customer customer = ctx.bodyAsClass(Customer.class);
            if(customerService.updateCustomer(customer)){
                ctx.status(202);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }

    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/customerlogin", this.customerLogin);
        app.post("/logout", this.logout);
        app.post("/newcustomer",newCustomer);
        app.put("/updatecustomer",updateCustomer);

    }
}
