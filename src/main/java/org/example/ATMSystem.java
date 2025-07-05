package org.example;

import java.util.ArrayList;
import java.util.List;

public class ATMSystem {
    private List<Account> accounts;
    private List<Transaction> transaction;

    public ATMSystem() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

