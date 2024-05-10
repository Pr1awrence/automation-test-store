package core;

import org.testng.annotations.*;

/**
 * <p> The {@code Hooks} class sets up and tears down all test pages.
 */
public class Hooks {
    protected ConfigReader reader;

    public Hooks() {
        this.reader = new ConfigReader();
    }

    @BeforeClass
    public void setup() {
        var driver = WebDriverInstance.getDriverInstance();
        driver.get(reader.getMainPageUrl());
    }

    @AfterClass
    public void tearDown() {
        WebDriverInstance.cleanupLocalDriver();
    }
}
