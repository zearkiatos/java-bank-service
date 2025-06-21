package org.example;

import org.example.utils.errorHandle.InsufficientFundsException;

public abstract class Account {
    private String accountNumber;
    private double balance;

    public abstract void deposit(double amount);

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public void showBalance() {
        System.out.println("Current balance: " + this.balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}

