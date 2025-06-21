package org.example;

public class SMSNotifier implements Observer {
    @Override
    public void update(double balance) {
        System.out.println("SMS: Your balance is: " + balance);
    }
}
