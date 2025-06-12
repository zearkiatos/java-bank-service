package org.example;

import java.util.Scanner;

public class ATM {
    private Calculator calculator = new Calculator();
    
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

         while (!exit) {
            System.out.println("Welcome to JavaBank 🏧.");
            System.out.println("Choice an operation:");
            System.out.println("1. Make a transaction");
            System.out.println("2. Using the calculator");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: 
                    // lógica de transacción
                    break;
                case 2:
                    calculator.start();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }

}
