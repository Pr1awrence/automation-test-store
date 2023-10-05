package pages.shop;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/* Page link: http://teststore.automationtesting.co.uk/ */
public class ShopHomePage extends BasePage {
    public WebDriver driver;

    By popularProducts = By.cssSelector(".product-miniature");

    public ShopHomePage() {
        this.driver = getDriver();
    }

    private List<WebElement> getPopularProducts() {
        return driver.findElements(popularProducts);
    }

    public void clickFirstProduct() {
        getPopularProducts().get(0).click();
    }

    public void clickSecondProduct() {
        getPopularProducts().get(1).click();
    }
}
