package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>The {@code ConfigReader} class' constructor parses {@code config.properties} file
 * and outputs data via methods (the {@link #getUrl()} method).
 */
public class ConfigReader {
    private String url;
    private final Properties prop;

    public ConfigReader() {
        prop = new Properties(); // Class Properties works with file extensions .properties
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
