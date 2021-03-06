package com.revature;

import com.revature.controllers.AdminController;
import com.revature.controllers.Controller;
import com.revature.controllers.CustomerController;
import com.revature.controllers.EmployeeController;
import io.javalin.Javalin;

public class App {

    private static Javalin app;

    public static void main(String[] args) {

        app = Javalin.create();
        configure(new EmployeeController(), new CustomerController(), new AdminController());
        app.start();
    }

    private static void configure(Controller... controllers) {
        for(Controller c: controllers) {
            c.addRoutes(app);
        }


    }


}
