package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.utils.errorHandle.InsufficientFundsException;

public class SavingsAccount extends Account {
    private double interestRate;
    private List<Observer> observers = new ArrayList<>();
    private double balance;

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
        this.notifyObservers();
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.getBalance()) {
            throw new InsufficientFundsException();
        }
        this.setBalance(this.getBalance() - amount);
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