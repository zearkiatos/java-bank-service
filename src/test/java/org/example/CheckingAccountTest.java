package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.utils.errorHandle.InsufficientFundsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
        @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testWithdrawWithOverdraft() throws InsufficientFundsException {
        CheckingAccount checkingAccount = new CheckingAccount("123456789", 500, 200);
        checkingAccount.withdraw(600);
        checkingAccount.showBalance();
        String expectedBalance = "Current balance: 100.0";

        assertTrue(outContent.toString().contains(expectedBalance));

    }

    @Test
    public void testWithdrawExceedingOverdraft() {
        CheckingAccount checkingAccount = new CheckingAccount("123456789", 500, 200);
        try {
            checkingAccount.withdraw(800); // Should throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            // Expected exception
        }
    }

    @Test
    public void testGetOverdraftLimit() {
        CheckingAccount checkingAccount = new CheckingAccount("123456789", 500, 200);
        double expectedOverdraftLimit = 200;
        
        double overdraftLimit = checkingAccount.getOverdraftLimit();
        
        assertEquals(overdraftLimit, expectedOverdraftLimit);
    }

    @Test
    public void testSetOverdraftLimit() {
        CheckingAccount checkingAccount = new CheckingAccount("123456789", 500, 200);
        double newOverdraftLimit = 300;
        
        checkingAccount.setOverdraftLimit(newOverdraftLimit);
        
        assertEquals(checkingAccount.getOverdraftLimit(), newOverdraftLimit);
    }
}
