package org.example;

/**
 * Behavioral Design Pattern: Strategy
 * Interface for authentication strategies.
 * This interface defines a method for authenticating data.
 */

public interface AuthStrategy {
    boolean authenticate(String data);
}
