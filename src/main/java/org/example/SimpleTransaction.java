package org.example;

public class SimpleTransaction implements Transaction {
    private String description;

    public SimpleTransaction(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.println("Executing: " + description);
    }
}
