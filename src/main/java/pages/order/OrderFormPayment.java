package pages.order;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Page link: http://teststore.automationtesting.co.uk/order */
public class OrderFormPayment extends BasePage {
    public WebDriver driver;

    By payByCheck = By.xpath("//span[.='Pay by Check']");
    By payByWire = By.xpath("//span[.='Pay by bank wire']");
    By termsAndConditions = By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
    By orderBtn = By.xpath("//div[@id='payment-confirmation']//button[@type='submit']");

    public OrderFormPayment() {
        this.driver = getDriver();
    }

    public void clickPayByCheck() {
        driver.findElement(payByCheck).click();
    }

    public void acceptTermsAndConditions() {
        driver.findElement(termsAndConditions).click();
    }

    public void clickOrder() {
        driver.findElement(orderBtn).click();
    }
}
