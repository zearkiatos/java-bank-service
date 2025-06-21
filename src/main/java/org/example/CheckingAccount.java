package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.utils.errorHandle.InsufficientFundsException;

public class CheckingAccount extends Account {
    private double overdraftLimit;
    private List<Observer> observers = new ArrayList<>();
    private double balance;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.getBalance() + overdraftLimit) {
            throw new InsufficientFundsException();
        }
        this.setBalance(this.getBalance() + overdraftLimit - amount);
        this.notifyObservers();
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public void deposit(double amount) {
        this.setBalance(amount + this.getBalance());
        this.notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }
}
