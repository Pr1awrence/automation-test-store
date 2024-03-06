package listeners;

import pages.BasePage;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Deprecated(since = "Don't need it anymore, use Allure instead")
public class TestFailureScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            BasePage basePage = new BasePage();
            basePage.takeSnapShot();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
