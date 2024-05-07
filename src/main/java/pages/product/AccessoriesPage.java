package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccessoriesPage extends ProductListPage {
    public WebDriver driver;

    By leftMenuStationeryCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Stationery']");
    By leftMenuHomeAccessoriesCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Home Accessories']");

    public AccessoriesPage() {
        this.driver = getDriver();
    }

    public void clickLeftMenuStationeryCategory() {
        driver.findElement(leftMenuStationeryCategory).click();
    }

    public void clickLeftMenuHomeAccessoriesCategory() {
        driver.findElement(leftMenuHomeAccessoriesCategory).click();
    }
}
