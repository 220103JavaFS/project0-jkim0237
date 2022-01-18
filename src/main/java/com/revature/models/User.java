package com.revature.models;

import java.util.Objects;

public class User {

    private String userType;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String doa;

    //Constructors

    public User() {
        super();
    }

    public User(String userType, String userName, String password, String firstName, String lastName, String doa) {
        this.userType = userType;
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    //equals, hashCode, toString methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserType(), user.getUserType()) && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getDoa(), user.getDoa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserType(), getUserName(), getPassword(), getFirstName(), getLastName(), getDoa());
    }

    @Override
    public String toString() {
        return "User{" +
                "userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doa='" + doa + '\'' +
                '}';
    }
}
