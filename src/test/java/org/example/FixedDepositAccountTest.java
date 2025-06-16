package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FixedDepositAccountTest {
    @Test
    public void testFixedDepositAccount() {
        // Create a FixedDepositAccount with a specific maturity period and interest rate
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD123456", 10000, 0.07, 12);
        
        // Check initial balance
        assertEquals(10000, fixedDepositAccount.getBalance());
    
        
        fixedDepositAccount.mature();
        fixedDepositAccount.applyInterest();
        
        double expectedBalance = 10007;
        assertEquals(expectedBalance, fixedDepositAccount.getBalance());
    }

}
