package org.example.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private String logFile;

    public TransactionLogger(String logFile) {
        this.logFile = logFile;
    }

    public void logTransaction(String transaction) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))) {
            bw.write(transaction);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error logging transaction: " + e.getMessage());
        }
    }

    public List<String> readTransactions() {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading transactions: " + e.getMessage());
        }
        return transactions;
    }
}
