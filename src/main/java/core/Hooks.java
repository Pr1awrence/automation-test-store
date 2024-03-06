package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * <p> The {@code Hooks} class sets up and tears down all test pages.
 */
public class Hooks {
    protected ConfigReader reader;

    public Hooks() {
        this.reader = new ConfigReader();
    }

    @BeforeMethod
    public void setup() {
        var driver = WebDriverInstance.getDriverInstance();
        driver.get(reader.getMainPageUrl());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverInstance.cleanupLocalDriver();
    }
}
