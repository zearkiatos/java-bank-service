package org.example;

/**
 * Observer pattern interface.
 * Observer interface for the Observer Design Pattern.
 * This interface defines the method that observers must implement to receive updates.
 */
public interface Observer {
    void update(double balance);
}
