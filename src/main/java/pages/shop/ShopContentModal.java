package pages.shop;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Page link example: http://teststore.automationtesting.co.uk/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white */
public class ShopContentModal extends BasePage {
    public WebDriver driver;

    By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
    By checkoutBtn = By.partialLinkText("PROCEED TO CHECKOUT");

    public ShopContentModal() {
        this.driver = getDriver();
    }

    public void clickContinueShoppingBtn() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void clickCheckoutBtn() {
        driver.findElement(checkoutBtn).click();
    }
}
