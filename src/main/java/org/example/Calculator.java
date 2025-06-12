package org.example;

import java.util.Scanner;

public class Calculator {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.print("Type the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Type the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Choice an operation (+, -, *, /): ");
        String operator = scanner.next();

        double result;
        switch (operator) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException("Not valid operation.");
        }
        
        System.out.println("El resultado es: " + result);
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.start();
    }

}
