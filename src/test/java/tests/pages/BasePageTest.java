package tests.pages;

import core.Hooks;
import core.WebDriverInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageTest extends Hooks {
    protected String mainPageUrl = reader.getMainPageUrl();
    protected String homePageUrl = reader.getHomePageUrl();
    protected String clothesPageUrl = reader.getClothesPageUrl();
    protected String menClothesPageUrl = reader.getMenClothesPageUrl();
    protected String womenClothesPageUrl = reader.getWomenClothesPageUrl();
    protected String accessoriesPageUrl = reader.getAccessoriesPageUrl();
    protected String stationeryPageUrl = reader.getStationeryPageUrl();
    protected String homeAccessoriesPageUrl = reader.getHomeAccessoriesPageUrl();
    protected String artPageUrl = reader.getArtPageUrl();
    protected String pricesDropPageUrl = reader.getPricesDropPageUrl();
    protected String newProductsPageUrl = reader.getNewProductsPageUrl();
    protected String userEmail = reader.getUserEmail();
    protected String userPassword = reader.getUserPassword();
    protected String loginPageUrl = reader.getLoginPageUrl();
    protected String registrationPageUrl = reader.getRegistrationPageUrl();

    protected void waitUntilUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriverInstance(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(url));
    }

    protected void waitUntilInvisibilityOfAnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriverInstance(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
