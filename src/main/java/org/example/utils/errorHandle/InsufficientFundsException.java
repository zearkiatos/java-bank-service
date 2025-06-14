package org.example.utils.errorHandle;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds for this transaction.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
    
}
