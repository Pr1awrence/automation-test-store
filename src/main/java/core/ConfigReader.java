package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private String url;
    private final Properties prop;

    public ConfigReader() {
        prop = new Properties();
        try (FileInputStream data = new FileInputStream(getClass().getClassLoader().getResource("config.properties").getPath())) {
            prop.load(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl() {
        url = prop.getProperty("url");
        return url;
    }
}
