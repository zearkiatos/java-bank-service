package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.Account;

public class ATMSystem {
    private List<Account> accounts;

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

