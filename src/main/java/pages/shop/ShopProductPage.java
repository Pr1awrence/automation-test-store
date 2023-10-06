package pages.shop;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/* Page link example: http://teststore.automationtesting.co.uk/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white */
public class ShopProductPage extends BasePage {
    public WebDriver driver;

    By sizeOption = By.cssSelector("[data-product-attribute='1']");
    By quantityIncrease = By.cssSelector(".touchspin-up");
    By quantityDecrease = By.cssSelector(".touchspin-down");
    By addToCartBtn = By.cssSelector(".add-to-cart.btn.btn-primary");
    By homepageLink = By.xpath("//a[@href='http://teststore.automationtesting.co.uk/']");

    public ShopProductPage() {
        this.driver = getDriver();
    }

    public void chooseMediumSize() {
        Select option = new Select(driver.findElement(sizeOption));
        option.selectByVisibleText("M");
    }

    public void clickQuantityIncrease() {
        driver.findElement(quantityIncrease).click();
    }

    public void clickQuantityDecrease() {
        driver.findElement(quantityDecrease);
    }

    public void clickAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickHomepageLink() {
        driver.findElement(homepageLink).click();
    }
}
