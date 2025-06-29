package org.example;
import java.util.logging.Logger;

public class SimpleTransaction implements Transaction {
    private String description;
    private static final Logger logger = Logger.getLogger(ATM.class.getName());

    public SimpleTransaction(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        logger.info("Executing: " + description);
    }
}
