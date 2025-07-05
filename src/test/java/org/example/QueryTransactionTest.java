package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class QueryTransactionTest { 

    @Test
    public void testShouldAddATransaction() {
        double amount = 100.0;
        TransactionType type = TransactionType.DEPOSIT;
        BankTransaction transaction = new BankTransaction(type, amount);
        QueryTransaction queryTransaction = new QueryTransaction();

        queryTransaction.add(transaction, type);

        assertEquals(1, queryTransaction.getDepositTransactions().size());
        assertEquals(type, queryTransaction.getDepositTransactions().get(0).getType());
        assertEquals(amount, queryTransaction.getDepositTransactions().get(0).getAmount());
    }

    @Test
    public void testShouldThrowExceptionWhenAddingNullTransaction() {
        QueryTransaction queryTransaction = new QueryTransaction();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            queryTransaction.add(null, TransactionType.DEPOSIT);
        });
        assertEquals("Transaction cannot be null", exception.getMessage());
    }

    @Test
    public void testShouldReturnEmptyListWhenNoDepositTransactions() {
        QueryTransaction queryTransaction = new QueryTransaction();
        
        assertTrue(queryTransaction.getDepositTransactions().isEmpty());
    }

    @Test
    public void testShouldReturnDepositTransactions() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 100.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        BankTransaction withdrawal = new BankTransaction(TransactionType.WITHDRAWAL, 50.0);
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(withdrawal, TransactionType.WITHDRAWAL);
        
        assertEquals(2, queryTransaction.getDepositTransactions().size());
        assertEquals(deposit1, queryTransaction.getDepositTransactions().get(0));
        assertEquals(deposit2, queryTransaction.getDepositTransactions().get(1));
    }

    @Test
    public void testShouldGetTransactionsHighterThanOneThousand() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 1200.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        BankTransaction withdrawal = new BankTransaction(TransactionType.WITHDRAWAL, 50.0);
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(withdrawal, TransactionType.WITHDRAWAL);

        assertEquals(1, queryTransaction.getTransactionsHigherThan(1000).size());
        assertEquals(deposit1, queryTransaction.getTransactionsHigherThan(1000).get(0));
    }

    @Test
    public void testShouldGetAmounts() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 100.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        List<Double> expectedAmounts = Arrays.asList(100.0, 200.0);
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        
        assertEquals(2, queryTransaction.getAmounts().size());
        assertEquals(expectedAmounts, queryTransaction.getAmounts());
    }

    @Test
    public void testShouldSortedTransactionsByAmount() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 300.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 100.0);
        BankTransaction deposit3 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(deposit3, TransactionType.DEPOSIT);

        List<BankTransaction> sortedTransactions = queryTransaction.getSortedTransactionsByAmount();

        assertEquals(deposit2, sortedTransactions.get(0));
        assertEquals(deposit3, sortedTransactions.get(1));
        assertEquals(deposit1, sortedTransactions.get(2));
    }


    @Test
    public void testShouldSortedTransactionsByTimestamp() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 300.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 100.0);
        BankTransaction deposit3 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(deposit3, TransactionType.DEPOSIT);

        List<BankTransaction> sortedTransactions = queryTransaction.getSortedTransactionsByTimestamp();

        assertEquals(deposit1, sortedTransactions.get(0));
        assertEquals(deposit2, sortedTransactions.get(1));
        assertEquals(deposit3, sortedTransactions.get(2));
    }

    @Test
    public void testShouldGetTotalAmount() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 300.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 100.0);
        BankTransaction deposit3 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        double totalAmountExpected = 600.0;
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(deposit3, TransactionType.DEPOSIT);

        Double totalAmount = queryTransaction.getTotalAmount();

        assertEquals(totalAmountExpected, totalAmount);;
    }

    @Test
    public void testShouldGetTransactionsHighterThanOneThousandWithParallels() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 1200.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        BankTransaction withdrawal = new BankTransaction(TransactionType.WITHDRAWAL, 50.0);
        
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(withdrawal, TransactionType.WITHDRAWAL);

        assertEquals(1, queryTransaction.getTransactionsHigherThanWithParallels(1000).size());
        assertEquals(deposit1, queryTransaction.getTransactionsHigherThan(1000).get(0));
    }

    @Test
    public void testShouldGetTransactionSummaryByType() {
        QueryTransaction queryTransaction = new QueryTransaction();
        BankTransaction deposit1 = new BankTransaction(TransactionType.DEPOSIT, 1200.0);
        BankTransaction deposit2 = new BankTransaction(TransactionType.DEPOSIT, 200.0);
        BankTransaction withdrawal = new BankTransaction(TransactionType.WITHDRAWAL, 50.0);
        queryTransaction.add(deposit1, TransactionType.DEPOSIT);
        queryTransaction.add(deposit2, TransactionType.DEPOSIT);
        queryTransaction.add(withdrawal, TransactionType.WITHDRAWAL);
        Map<TransactionType, Double> summaryExpected = new HashMap<>();
        summaryExpected.put(TransactionType.DEPOSIT, 1400.0);
        summaryExpected.put(TransactionType.WITHDRAWAL, 50.0);

        Map<TransactionType, Double> summary = queryTransaction.getTransactionSummaryByType();

        assertEquals(2, summary.size());
        assertEquals(summaryExpected, summary);
    }
}