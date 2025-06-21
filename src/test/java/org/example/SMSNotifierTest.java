package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SMSNotifierTest {
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
    public void testUpdate() {
        String expectedOutput = "SMS: Your balance is: 100.0";
        SMSNotifier smsNotifier = new SMSNotifier();
        
        smsNotifier.update(100.0);

        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
