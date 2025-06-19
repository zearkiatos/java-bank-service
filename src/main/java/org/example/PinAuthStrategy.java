package org.example;

public class PinAuthStrategy implements AuthStrategy {
    private String pin;

    public PinAuthStrategy(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean authenticate(String data) {
        return this.pin.equals(data);
    }
    
}
