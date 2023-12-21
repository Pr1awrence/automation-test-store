package listeners;

import core.BasePage;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestFailureScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO: do I really need this if there is Allure configured ?
        try {
            BasePage basePage = new BasePage();
            basePage.takeSnapShot();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
