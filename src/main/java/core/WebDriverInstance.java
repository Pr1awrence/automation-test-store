package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public final class WebDriverInstance {
    public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public static WebDriver getDriverInstance() {
        if (localDriver.get() == null) {
            try {
                localDriver.set(createDriver());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return localDriver.get();
    }

    private static WebDriver createDriver() throws IOException {
        WebDriver driver;

        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(WebDriverInstance.class.getClassLoader().getResource("config.properties").getPath());
        prop.load(data);

        // How to setup parametrized webdriver https://bonigarcia.dev/webdrivermanager/
        if (prop.getProperty("browser").equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (prop.getProperty("browser").equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else {
            driver = WebDriverManager.edgedriver().create();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void cleanupLocalDriver() {
        localDriver.get().quit();
        localDriver.remove();
    }
}
