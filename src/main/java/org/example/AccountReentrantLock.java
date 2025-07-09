package org.example;
import org.example.exceptions.InsufficientFundsException;
import java.util.concurrent.locks.ReentrantLock;

public class AccountATMReentrantLock {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposit done: " + amount + ", Current balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        lock.lock();
        try {
            if(balance >= amount) {
                balance -= amount;
                System.out.println("Withdraw done: " + amount + ", Current balance: " + balance);
            } else {
                throw new InsufficientFundsException("Not enough funds");
            }
        } finally {
            lock.unlock();
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
