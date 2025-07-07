package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

public class OptionalNullValueTest {
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
    public void testShouldHandleOptionalNullValue() {
        Optional<String> optionalName = Optional.empty();
        String expectedOutput = "No user found";
        
        OptionalNullValue.process(optionalName);
        
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testShouldLogWithTheString() {
        Optional<String> optionalName = Optional.of("Pedro Capriles");
        String expectedOutput = "User: Pedro Capriles";
        
        OptionalNullValue.process(optionalName);
        
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testShouldReturnADefaultValueWhenOptionalIsEmpty() {
        Optional<String> optionalName = Optional.empty();
        String userName = optionalName.orElse("Default User");
        String expectedOutput = "User: Default User";

        OptionalNullValue.process(userName);
        
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testShouldReturnAnonymousValueWhenOptionalIsEmpty() {
        Optional<String> optionalName = Optional.empty();
        String userName = optionalName.orElseGet(() -> "Anonymous");
        String expectedOutput = "User: Anonymous";

        OptionalNullValue.process(userName);
        
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testShouldReturnUsernameLength() {
        Optional<String> optionalName = Optional.of("username");
        Integer expectedUsernameLength = 8;

        Optional<Integer> usernameLength = optionalName.map(String::length);
        
        assertEquals(expectedUsernameLength, usernameLength.get());
    }

    @Test
    public void testShouldReturnFlatLength() {
        Optional<String> optionalName = Optional.of("username");
        Integer expectedUsernameLength = 8;

        Optional<Integer> usernameLength = optionalName.flatMap(name -> Optional.of(name.length()));
        
        assertEquals(expectedUsernameLength, usernameLength.get());
    }

}