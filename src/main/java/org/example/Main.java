package org.example;
import java.util.ArrayList;

import org.example.Status;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public String pin = "1234";
    public static void main(String[] args) {
        String accountNumber = "123456789";
        double balance = 1500.75;
        int pin = 1234;
        ArrayList<String> transactionHistory = new ArrayList<>();

        int[] transactionAmounts = {200, -100, 50};

        balance += transactionAmounts[0];
        if (balance > 0 && pin == 1234) {
            System.out.println("Access successful");
        }


        balance++;
        String status = (balance < 0) ? Status.DEBT.name(): Status.CREDIT.name();
        System.out.println("Account Status: " + status);

        deposit(500.0, balance, transactionHistory);
        withdraw(100.0, balance, transactionHistory);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
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

    public static void deposit(Double amount,  double balance, ArrayList<String> transactionHistory) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public static boolean withdraw(double amount, double balance, ArrayList<String> transactionHistory) {
             if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Not enough funds");
            return false;
        }
    }
}