package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    public void testApplyInterest() {
        SavingsAccount savingsAccount = new SavingsAccount("987654321", 1000, 0.05);
        savingsAccount.applyInterest();
        
        // Assuming the applyInterest method deposits the interest into the account
        double expectedBalance = 1000 + (1000 * 0.05); // 1000 + 50
        assertEquals(expectedBalance, savingsAccount.getBalance());
    }

    
}
