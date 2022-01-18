package com.revature.models;

public class Customer extends User{

    private boolean savingAccount;
    private boolean checkingAccount;
    private double amountSaving;
    private double amountChecking;

    //constructors
    public Customer() {
    }

    public Customer(String userType, String userName, String password, String firstName, String lastName, String doa,
                    boolean savingAccount, boolean checkingAccount, double amountSaving, double amountChecking) {
        super(userType, userName, password, firstName, lastName, doa);
        this.savingAccount = savingAccount;
        this.checkingAccount = checkingAccount;
        this.amountSaving = amountSaving;
        this.amountChecking = amountChecking;
    }

    //Getters and Setters

    public boolean isSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(boolean savingAccount) {
        this.savingAccount = savingAccount;
    }

    public boolean isCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(boolean checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public double getAmountSaving() {
        return amountSaving;
    }

    public void setAmountSaving(double amountSaving) {
        this.amountSaving = amountSaving;
    }

    public double getAmountChecking() {
        return amountChecking;
    }

    public void setAmountChecking(double amountChecking) {
        this.amountChecking = amountChecking;
    }
}


