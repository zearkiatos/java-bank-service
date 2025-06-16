package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ATMSystemTest {
    @Test
    void testAddAccount() {
        Account account = new Account("1234567890", 1000);
        ATMSystem atmSystem = new ATMSystem();
        atmSystem.addAccount(account);
        
        Account retrievedAccount = atmSystem.getAccount("1234567890");

        assertEquals(account, retrievedAccount);
    }
}
