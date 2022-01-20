package com.revature.models;

import java.util.Objects;

public class BankAccount{

    private String userName;
    private Boolean openSavingAccount;
    private Boolean openCheckingAccount;
    private Float savingAmount;
    private Float checkingAmount;

    public BankAccount() {
    }

    public BankAccount(String userName, Boolean openSavingAccount, Boolean openCheckingAccount, Float savingAmount, Float checkingAmount) {
        this.userName = userName;
        this.openSavingAccount = openSavingAccount;
        this.openCheckingAccount = openCheckingAccount;
        this.savingAmount = savingAmount;
        this.checkingAmount = checkingAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getOpenSavingAccount() {
        return openSavingAccount;
    }

    public void setOpenSavingAccount(Boolean openSavingAccount) {
        this.openSavingAccount = openSavingAccount;
    }

    public Boolean getOpenCheckingAccount() {
        return openCheckingAccount;
    }

    public void setOpenCheckingAccount(Boolean openCheckingAccount) {
        this.openCheckingAccount = openCheckingAccount;
    }

    public Float getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(Float savingAmount) {
        this.savingAmount = savingAmount;
    }

    public Float getCheckingAmount() {
        return checkingAmount;
    }

    public void setCheckingAmount(Float checkingAmount) {
        this.checkingAmount = checkingAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getOpenSavingAccount(), that.getOpenSavingAccount()) && Objects.equals(getOpenCheckingAccount(), that.getOpenCheckingAccount()) && Objects.equals(getSavingAmount(), that.getSavingAmount()) && Objects.equals(getCheckingAmount(), that.getCheckingAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getOpenSavingAccount(), getOpenCheckingAccount(), getSavingAmount(), getCheckingAmount());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "userName='" + userName + '\'' +
                ", openSavingAccount=" + openSavingAccount +
                ", openCheckingAccount=" + openCheckingAccount +
                ", savingAmount=" + savingAmount +
                ", checkingAmount=" + checkingAmount +
                '}';
    }
}

