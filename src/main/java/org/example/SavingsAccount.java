package org.example;

import org.example.utils.errorHandle.InsufficientFundsException;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance); 
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    public void deposit(double amount) {
        this.setBalance(amount + this.getBalance());
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.getBalance()) {
            throw new InsufficientFundsException();
        }
        this.setBalance(this.getBalance() - amount);
    }
}