package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigReader() {
    }

    private static void loadProperties() {

        String filePath =
                System.getProperty("user.dir")
                + "/src/main/resources/config/config.properties";

        try (FileInputStream fis = new FileInputStream(filePath)) {

            properties.load(fis);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties", e);
        }
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null) {

            throw new RuntimeException(
                    "Property not found: " + key);
        }

        return value.trim();
    }
}