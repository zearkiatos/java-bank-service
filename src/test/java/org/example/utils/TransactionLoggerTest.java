package org.example.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.utils.FileUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class TransactionLoggerTest {
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
    public void testLogTransaction() {
        final String LOG_FILE = "transactions.log";
        TransactionLogger logger = new TransactionLogger(LOG_FILE);
        String transactionDetails = "Deposit: $100";
        
        logger.logTransaction(transactionDetails);
        FileUtils.readFile(LOG_FILE);

        assertTrue(outContent.toString().contains(transactionDetails), "Transaction should be logged correctly.");

        FileUtils.removeFile(LOG_FILE);
    }
}
