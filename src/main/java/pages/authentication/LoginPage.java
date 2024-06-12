package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {
    public WebDriver driver;

    By email = By.id("field-email");
    By password = By.id("field-password");
    By singInBtn = By.id("submit-login");
    By authFailedMsg = By.xpath("//li[contains(text(), 'Authentication failed')]");
    By registrationBtn = By.cssSelector(".no-account");

    public LoginPage() {
        this.driver = getDriver();
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void clickSingInBtn() {
        driver.findElement(singInBtn).click();
    }

    public boolean authFailedMsgIsShown() {
        return driver.findElement(authFailedMsg).isDisplayed();
    }

    public void clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
    }
}
