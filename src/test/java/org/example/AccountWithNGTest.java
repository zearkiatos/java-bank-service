package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.example.SavingsAccount;
import org.example.utils.errorHandle.InsufficientFundsException;

public class AccountWithNGTest {

    @DataProvider(name = "withdrawData")
    public Object[][] createData() {
        return new Object[][] {
            {500.00, 100.00, 400.00},
            {300.00, 50.00, 250.00}
        };
    }

    @Test(dataProvider = "withdrawData")
    public void testWithdraw(double initialBalance, double amount, double expectedBalance) throws InsufficientFundsException {
        Account account = new SavingsAccount("12345", initialBalance, 0);
        
        account.withdraw(amount);
        
        Assert.assertEquals(account.getBalance(), expectedBalance);
    }
}
