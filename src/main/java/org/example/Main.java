package org.example;
import org.example.Status;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public String pin = "1234";
    public static void main(String[] args) {
        String accountNumber = "123456789";
        double balance = 1500.75;
        int pin = 1234;

        int[] transactionAmounts = {200, -100, 50};

        balance += transactionAmounts[0];
        if (balance > 0 && pin == 1234) {
            System.out.println("Access successful");
        }


        balance++;
        String status = (balance < 0) ? Status.DEBT.name(): Status.CREDIT.name();
        System.out.println("Account Status: " + status);
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
}