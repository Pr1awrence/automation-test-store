package pages.order;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Page link: http://teststore.automationtesting.co.uk/order */
public class OrderFormShippingMethod extends BasePage {
    public WebDriver driver;

    By deliveryMsgTextBox = By.cssSelector("textarea#delivery_message");
    By continueBtn = By.cssSelector("[name='confirmDeliveryOption']");

    public OrderFormShippingMethod() {
        this.driver = getDriver();
    }

    public void enterDeliveryMessage() {
        driver.findElement(deliveryMsgTextBox).sendKeys("If I am not in, please leave my delivery on my porch.");
    }

    public void clickContinueBtn() {
        driver.findElement(continueBtn).click();
    }
}
