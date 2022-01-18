package com.revature.com.revature.models;

public class Employee extends Users {

    private int hiredDate;

    //constructors

    public Employee() {
    }

    public Employee(String userType, String userName, String firstName, String lastName, int doa, int hiredDate) {
        super(userType, userName, firstName, lastName, doa);
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
