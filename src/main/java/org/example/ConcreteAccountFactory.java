package org.example;
/**
 * Factory method design pattern example for creating different types of accounts.
 * ConcreteAccountFactory.java
 * This class implements the AccountFactory to create specific types of accounts.
 */
public class ConcreteAccountFactory extends AccountFactory {
    public Account createAccount(String accountType, String accountNumber, double initialBalance, double interestRate) {
        return createAccount(accountType, accountNumber, initialBalance, interestRate, 0.0);
    }

    @Override
    public Account createAccount(String accountType, String accountNumber, double initialBalance, double interestRate, double overdraftLimit) {
        switch (accountType) {
            case "Savings":
                return new SavingsAccount(accountNumber, initialBalance, interestRate);
            case "Checking":
                return new CheckingAccount(accountNumber, initialBalance, overdraftLimit);
            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }
}
