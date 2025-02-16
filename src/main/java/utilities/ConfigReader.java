package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

    public static Properties loadProperties() {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
        return prop;
    }

    public static String getProperty(String key) {
        if (prop == null) {
            loadProperties();
        }
        return prop.getProperty(key);
    }
}
