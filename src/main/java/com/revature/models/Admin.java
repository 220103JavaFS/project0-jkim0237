package com.revature.models;

public class Admin extends User {

    private int hiredDate;

    //constructors

    public Admin() {
    }

    public Admin(String userType, String userName, String firstName, String lastName, String doa, int hiredDate) {
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
