package listeners;

import core.WebDriverInstance;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.addAttachment;

/**
 * <p>The {@code AllureListener} class intercepts the control of the dropped test
 * to take a screenshot before the program throws an error (the {@link #beforeTestStop(TestResult result)} method).
 */
/*
 * There is no guarantee that TestNG onTestFailure will be executed before closing the Allure context.
 * So need to use AllureLifeCycle Listener instead of TestNG Listener
 * https://github.com/testng-team/testng/issues/2791
 * */
public class AllureListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        WebDriver driver = WebDriverInstance.getDriverInstance();

        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            if (driver != null)
                addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
