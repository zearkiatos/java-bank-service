package org.example;

import java.util.Optional;

public class OptionalNullValue {
    public static void process(Optional<String> optionalName) {
        if (optionalName.isPresent()) {
            System.out.println("User: " + optionalName.get());
        } else {
            System.out.println("No user found");
        }
    }

    public static void process(String optionalName) {
        if (!optionalName.isEmpty()) {
            System.out.println("User: " + optionalName);
        } else {
            System.out.println("No user found");
        }
    }
}