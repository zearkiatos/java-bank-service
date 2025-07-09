package org.example;
import java.lang.Runnable;
import java.lang.Thread;

public class ATMRunnable implements Runnable {
    private String transactionType;
    private double amount;

    public ATM(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        if(transactionType.equals("deposit")) {
            System.out.println("Execute deposit of: " + amount);
        } else if(transactionType.equals("withdrawal")) {
            System.out.println("Execute withdraw of: " + amount);
        }
    }

    public static void main(String[] args) {
        Thread user1 = new Thread(new ATM("deposit", 100.0));
        Thread user2 = new Thread(new ATM("withdrawal", 50.0));

        user1.start();
        user2.start();
    }
}
