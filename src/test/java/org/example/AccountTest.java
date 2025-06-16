package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.utils.errorHandle.InsufficientFundsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
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
    public void testDeposit() {
        String expectedBalance = "Current balance: 100";
        Account account = new Account("123456789", 0);
        account.deposit(100);

        account.showBalance();

        assertTrue(outContent.toString().contains(expectedBalance));
    }

    @Test
    public void testWithdraw() {
        String expectedBalance = "Current balance: 50";
        Account account = new Account("123456789", 0);
        account.deposit(100);
        try {
            account.withdraw(50);
        } catch (InsufficientFundsException e) {
            // This should not happen
        }

        account.showBalance();

        assertTrue(outContent.toString().contains(expectedBalance));
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Account account = new Account("123456789", 0);
        account.deposit(50);
        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            assertTrue(e.getMessage().contains("Insufficient funds for this transaction."));
        }
    }

    @Test
    public void testShowBalance() {
        String expectedBalance = "Current balance: 0.0";
        Account account = new Account("123456789", 0);

        account.showBalance();

        assertTrue(outContent.toString().contains(expectedBalance));
    }

    @Test
    public void testGetAccountNumber() {
        Account account = new Account("123456789", 0);
        String accountNumber = "123456789";

        account.setAccountNumber(accountNumber);
        
        assertTrue(account.getAccountNumber().equals(accountNumber));
    }

    @Test 
    public void testGetBalance() {
        Account account = new Account("123456789", 1000);
        double expectedBalance = 1000.0;

        assertEquals(account.getBalance(), expectedBalance);
    }

    @Test
    public void testSetBalance() {
        Account account = new Account("123456789", 0);
        double newBalance = 500.0;

        account.setBalance(newBalance);

        assertEquals(account.getBalance(), newBalance);
    }
}
