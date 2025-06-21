package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern implementation for transactions.
 * CompositeTransaction is a class that implements the Transaction interface.
 * It allows for the composition of multiple transactions into a single transaction.
 */

public class CompositeTransaction implements Transaction {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void execute() {
        for (Transaction t : transactions) {
            t.execute();
        }
    }
}
