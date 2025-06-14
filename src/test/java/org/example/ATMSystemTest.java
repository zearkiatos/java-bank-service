package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ATMSystemTest {
    @Test
    void testAddAccount() {
        Account account = new Account();
        account.setAccountNumber("1234567890");
        ATMSystem atmSystem = new ATMSystem();
        atmSystem.addAccount(account);
        
        Account retrievedAccount = atmSystem.getAccount("1234567890");

        assertEquals(account, retrievedAccount);
    }
}
