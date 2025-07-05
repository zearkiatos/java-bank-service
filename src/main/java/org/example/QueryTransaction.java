package org.example;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

public class QueryTransaction {
    private List<BankTransaction> transactions = new ArrayList<BankTransaction>();

     public void add(BankTransaction transaction, TransactionType type) {
         if (transaction != null) {
             transactions.add(transaction);
         } else {
             throw new IllegalArgumentException("Transaction cannot be null");
         }
     }

     public List<BankTransaction> getDepositTransactions() {
         return transactions.stream()
                 .filter(t -> t.getType() == TransactionType.DEPOSIT)
                 .collect(Collectors.toList());
     }

     public List<BankTransaction> getTransactionsHigherThan(double amount) {
            return transactions.stream()
                    .filter(t -> t.getAmount() > amount)
                    .collect(Collectors.toList());
     }

     public List<Double> getAmounts() {
        return transactions.stream()
                .map(BankTransaction::getAmount)
                .collect(Collectors.toList());
     }

     public List<BankTransaction> getSortedTransactionsByAmount() {
         return transactions.stream()
            .sorted(Comparator.comparing(BankTransaction::getAmount))
            .collect(Collectors.toList());
     }

     public List<BankTransaction> getSortedTransactionsByTimestamp() {
        return transactions.stream()
            .sorted(Comparator.comparing(BankTransaction::getTimestamp))
            .collect(Collectors.toList());
     }

     public Double getTotalAmount() {
        return transactions.stream()
            .map(BankTransaction::getAmount)
            .reduce(0.0, Double::sum);
     }

    public List<BankTransaction> getTransactionsHigherThanWithParallels(double amount) {
            return transactions.parallelStream()
                    .filter(t -> t.getAmount() > amount)
                    .collect(Collectors.toList());
     }

     public Map<TransactionType, Double> getTransactionSummaryByType() {
         return transactions.stream()
                 .collect(Collectors.groupingBy(BankTransaction::getType, 
                 Collectors.summingDouble(BankTransaction::getAmount)));
     }
}