package com.revature.models;

import java.sql.Date;
import java.util.Objects;

public class Employee extends User {

    private int hiredDate;

    //constructors

    public Employee() {
    }

    public Employee(String userType, String userName, String password, String firstName, String lastName, String doa, int hiredDate) {
        super(userType, userName, password, firstName, lastName, doa);
        this.hiredDate = hiredDate;
    }

//Getters and Setters


    public int getHiredDate() {

        return hiredDate;
    }

    public void setHiredDate(int hiredDate) {

        this.hiredDate = hiredDate;
    }
}

