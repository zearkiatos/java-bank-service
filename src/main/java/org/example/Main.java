package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.example.Status;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public String pin = "1234";
    public static void main(String[] args) {
        String accountNumber = "123456789";
        double balance = 1500.75;
        int pin = 1234;
        HashMap<String, Double> transactionHistory = new HashMap<String, Double>();

        int[] transactionAmounts = {200, -100, 50};

        balance += transactionAmounts[0];
        if (balance > 0 && pin == 1234) {
            System.out.println("Access successful");
        }


        balance++;
        String status = (balance < 0) ? Status.DEBT.name(): Status.CREDIT.name();
        System.out.println("Account Status: " + status);

        deposit(500.00, balance, transactionHistory);
        withdrew(100.00, balance, transactionHistory);
        for (Map.Entry<String, Double> entry : transactionHistory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public boolean autenticateUser(String pin) {
        int attempts = 0;
        while (attempts < 3) {
            if (this.pin.equals(pin)) {
                return true;
            } else {
                attempts++;
                System.out.println("PIN incorrecto. Intento " + attempts + " de 3.");
            }
        }
        return false;
    }

    public static String getTransactionId() {
        Random random = new Random();
        long transactionNumber = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        return String.valueOf(transactionNumber);
    }

    public static void deposit(double amount,  double balance, HashMap<String, Double> transactionHistory) {
        balance += amount;
        String transactionId = getTransactionId();
        transactionHistory.put("deposit-"+transactionId, balance);
    }

    public static boolean withdrew(double amount, double balance, HashMap<String, Double> transactionHistory) {
             if (balance >= amount) {
            balance -= amount;
            String transactionId = getTransactionId();
            transactionHistory.put("withdrew-"+transactionId, balance);
            return true;
        } else {
            System.out.println("Not enough funds");
            return false;
        }
    }
}