package org.example;

public class EmailNotifier implements Observer {
     @Override
    public void update(double balance) {
        System.out.println("Email: Your balance is: " + balance);
    }
}
