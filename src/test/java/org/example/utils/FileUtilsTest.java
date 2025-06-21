package org.example.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileUtilsTest {
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
    public void testReadFile() {
        String expectedOutput = "This is a test file.";
        String filePath = "src/test/resources/testfile.txt"; // Ensure this file exists in your test resources

        FileUtils.readFile(filePath);

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testReadFileNotFound() {
        String filePath = "src/test/resources/nonexistentfile.txt"; // Ensure this file does not exist

        FileUtils.readFile(filePath);

        assertTrue(outContent.toString().contains("Error reading file:"));
    }
}
