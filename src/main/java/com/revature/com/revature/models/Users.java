package com.revature.com.revature.models;

import java.util.Objects;

public class Users {

    private String userType;
    private String userName;
    private String firstName;
    private String lastName;
    private int doa;

    //constructors

    public Users() {

        super();
    } //default constructor.

    public Users(String userType, String userName, String firstName, String lastName, int doa) {
        this.userType = userType;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.doa = doa;
    }

    //Getters and Setters

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDoa() {
        return doa;
    }

    public void setDoa(int doa) {
        this.doa = doa;
    }

    //implement equals, hashCode, and toString method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getDoa() == users.getDoa() && Objects.equals(getUserType(), users.getUserType()) && Objects.equals(getUserName(), users.getUserName()) && Objects.equals(getFirstName(), users.getFirstName()) && Objects.equals(getLastName(), users.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserType(), getUserName(), getFirstName(), getLastName(), getDoa());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doa=" + doa +
                '}';
    }
}