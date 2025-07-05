package org.example;

import java.lang.System;

public class BankTransaction {
    private TransactionType transactionType;
    private double amount;
    private long timestamp;

    public BankTransaction(TransactionType transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    public TransactionType getType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }
}