package org.example;

import java.util.Properties;

/**
 * Creational Pattern: Singleton
 * ConfigManager is a singleton class that manages configuration properties.
 * It provides a thread-safe way to access configuration settings throughout the application.
 */

public class ConfigManager {
    private static ConfigManager instance;
    private Properties configProperties;

    private ConfigManager() {
        configProperties = new Properties();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return configProperties.getProperty(key);
    }
}

