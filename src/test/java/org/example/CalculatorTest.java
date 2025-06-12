package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void testAdd() {
        double expected = 5;
        Calculator calculator = new Calculator();

        double result = calculator.add(2, 3);

        assertEquals(expected, result);
    }

    @Test
    void testSubtract() {
        double expected = 1;
        Calculator calculator = new Calculator();

        double result = calculator.subtract(3, 2);

        assertEquals(expected, result);
    }

    @Test
    void testMultiply() {
        double expected = 6;
        Calculator calculator = new Calculator();

        double result = calculator.multiply(2, 3);

        assertEquals(expected, result);
    }

    @Test
    void testDivide() {
        double expected = 2;
        Calculator calculator = new Calculator();

        double result = calculator.divide(6, 3);

        assertEquals(expected, result);
    }

    @Test
    void testDivideByZero() {
        Calculator calculator = new Calculator();
        try {
            calculator.divide(6, 0);
        } catch (ArithmeticException e) {
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }
}
