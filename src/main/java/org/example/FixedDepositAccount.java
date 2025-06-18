package org.example;

import org.example.utils.errorHandle.InsufficientFundsException;

public class FixedDepositAccount extends Account {
    private double interestRate;
    private int maturityPeriod;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, double initialBalance, double interestRate, int maturityPeriod) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
        this.maturityPeriod = maturityPeriod;
        this.isMatured = false;
    }

    public void applyInterest() {
        if (isMatured) {
            double interest = getBalance() * interestRate / 100;
            deposit(interest);
        } else {
            throw new IllegalStateException("Account is not matured yet.");
        }
    }

    public void mature() {
        isMatured = true;
    }

    public boolean isMatured() {
        return isMatured;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
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
