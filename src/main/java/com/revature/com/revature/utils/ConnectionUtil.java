package com.revature.com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        //For many frameworks using JDBC it is necessary to "register" the driver
        //package you are using. This is to make the framework aware of it.
        try {
            Class.forName(("org.postgresql.Driver"));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://javafs220103.c3g1k67p5shs.us-east-1.rds.amazonaws.com:5432/pj0";
        String username = "postgres"; //It is possible and preferable to hide this information in environment variables
        String password = "password"; //Those are accessed by System.getenv("var-name");

        return DriverManager.getConnection(url, username, password);
    }
}
