package org.example;

public abstract class AccountFactory {
    public abstract Account createAccount(String accountType,  String accountNumber, double initialBalance, double interestRate, double overdraftLimit);
}

