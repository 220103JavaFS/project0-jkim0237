package com.revature.models;


import java.util.Objects;

public class Customer {

    private int  customerID;
    private String userType;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDate;


    public Customer() {
    }

    public Customer(int customerID, String userType, String userName, String password, String firstName,
                    String lastName, String birthDate) {
        this.customerID = customerID;
        this.userType = userType;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerID() == customer.getCustomerID() && Objects.equals(getUserType(), customer.getUserType()) && Objects.equals(getUserName(), customer.getUserName()) && Objects.equals(getPassword(), customer.getPassword()) && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getBirthDate(), customer.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerID(), getUserType(), getUserName(), getPassword(), getFirstName(), getLastName(), getBirthDate());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}




