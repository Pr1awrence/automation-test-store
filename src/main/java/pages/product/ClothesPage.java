package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClothesPage extends ProductListPage {
    public WebDriver driver;

    By leftMenuMenCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Men']");
    By leftMenuWomenCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Women']");

    public ClothesPage() {
        this.driver = getDriver();
    }

    public void clickLeftMenuClothesMenCategory() {
        driver.findElement(leftMenuMenCategory).click();
    }

    public void clickLeftMenuClothesWomenCategory() {
        driver.findElement(leftMenuWomenCategory).click();
    }
}
