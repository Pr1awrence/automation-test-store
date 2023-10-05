package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    ConfigReader reader;

    public Hooks() {
        this.reader = new ConfigReader();
    }

    @BeforeMethod
    public void setup() {
        var driver = WebDriverInstance.getDriverInstance();
        driver.get(reader.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverInstance.cleanupLocalDriver();
    }
}
