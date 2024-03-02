package core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * <p>The {@code BasePage} class provides info for all the child pages
 * (the {@link #getDriver()} and {@link #getCurrentUrl()} methods).
 * <p>The class also contains reusable methods for children (the {@link #driverNavigateBack()} method).
 */
public class BasePage {
    public WebDriver getDriver() {
        return WebDriverInstance.getDriverInstance();
    }

    @Deprecated(since = "Allure listener has already implemented and creates an attachment when a test fails")
    public void takeSnapShot() throws IOException {
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        Path destination = Paths.get("screenshots\\" + timestamp() + ".png");
        Files.createDirectories(destination.getParent());

        /*
        * Same solution, more convenient
        * var directory = Files.createDirectories(Path.of("screenshots"));
        * var destination = directory.resolve(timestamp() + ".png");
        * */

        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void driverNavigateBack() {
        getDriver().navigate().back();
    }

    private String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
