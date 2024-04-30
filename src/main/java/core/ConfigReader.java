package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>The {@code ConfigReader} class' constructor parses {@code config.properties} file
 * and outputs data via methods ({@link #getMainPageUrl()}, {@link #getHomePageUrl()}, {@link #getClothesPageUrl()},
 * {@link #getAccessoriesPageUrl()}, {@link #getArtPageUrl()} methods).
 */
public class ConfigReader {
    private final Properties prop;

    public ConfigReader() {
        prop = new Properties(); // Class Properties works with file extensions .properties
        try (FileInputStream data = new FileInputStream(getClass().getClassLoader().getResource("config.properties").getPath())) {
            prop.load(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMainPageUrl() {
        return prop.getProperty("main.page.url");
    }

    public String getHomePageUrl() {
        return prop.getProperty("home.page.url");
    }

    public String getClothesPageUrl() {
        return prop.getProperty("clothes.page.url");
    }

    public String getAccessoriesPageUrl() {
        return prop.getProperty("accessories.page.url");
    }
    public String getArtPageUrl() {
        return prop.getProperty("art.page.url");
    }

    public String getPricesDropPageUrl() {
        return prop.getProperty("prices.drop.page.url");
    }
    public String getNewProductsPageUrl() {
        return prop.getProperty("new.products.page.url");
    }
}
