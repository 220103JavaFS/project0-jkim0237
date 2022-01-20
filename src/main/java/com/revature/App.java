package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.CustomerController;
import com.revature.controllers.EmployeeController;
import io.javalin.Javalin;

public class App {

    private static Javalin app;

    public static void main(String[] args) {

        app = Javalin.create();
        configure(new EmployeeController(), new CustomerController());
        app.start();
    }

    private static void configure(Controller... controllers) {
        for(Controller c: controllers) {
            c.addRoutes(app);
        }


    }


}
