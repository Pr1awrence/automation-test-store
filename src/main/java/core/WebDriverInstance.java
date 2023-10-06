package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

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
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");

            driver = WebDriverManager.chromedriver().capabilities(options).create();
        } else if (prop.getProperty("browser").equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");

            driver = WebDriverManager.firefoxdriver().capabilities(options).create();
        } else {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");

            driver = WebDriverManager.edgedriver().capabilities(options).create();
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
