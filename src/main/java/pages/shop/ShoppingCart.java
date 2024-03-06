package pages.shop;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* Page link: http://teststore.automationtesting.co.uk/cart?action=show */
public class ShoppingCart extends BasePage {
    public WebDriver driver;

    By havePromoBtn = By.cssSelector(".promo-code-button .collapse-button");
    By promoTextBox = By.cssSelector("input[name='discount_name']");
    By promoAddBtn = By.cssSelector("form[method='post']  span");
    By proceedToCheckoutBtn = By.cssSelector(".cart-detailed-actions .btn-primary");
    By deleteItemOne = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
    By deleteItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
    By totalValue = By.cssSelector(".cart-total .value");

    public ShoppingCart() {
        this.driver = getDriver();
    }

    public void applyPromoCode() {
        driver.findElement(havePromoBtn).click();
        driver.findElement(promoTextBox).sendKeys("20OFF");
        driver.findElement(promoAddBtn).click();
    }

    public void clickProceedCheckoutBtn() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    /* REFACTOR */
    public WebElement getDeleteItemOne() {
        return driver.findElement(deleteItemOne);
    }

    /* REFACTOR */
    public WebElement getDeleteItemTwo() {
        return driver.findElement(deleteItemTwo);
    }

    /* REFACTOR */
    public WebElement getTotalAmount() {
        return driver.findElement(totalValue);
    }
}
