package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * <p>The {@code WebDriverInstance} class is responsible for creating, providing, and cleaning up the {@code WebDriver}.
 * <p> It also manages the {@code localDriver} for safe and reliable operation during parallelization.
 * <p> The class has static methods such as
 * {@link #getDriverInstance()}, {@link #createDriver()}, and {@link #cleanupLocalDriver()}.
 */
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

        // How to set up parametrized webdriver https://bonigarcia.dev/webdrivermanager/
        if (prop.getProperty("browser").equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (prop.getProperty("browser").equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else {
            driver = WebDriverManager.edgedriver().create();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Remove it manually for jenkins -> C:\Windows\System32\config\systemprofile\.cache\selenium
        // https://github.com/bonigarcia/webdrivermanager/issues/1128
        WebDriverManager.chromedriver().clearDriverCache().setup();

        return driver;
    }

    public static void cleanupLocalDriver() {
        localDriver.get().quit();
        localDriver.remove();
    }
}
