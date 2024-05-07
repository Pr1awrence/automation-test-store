package pages.main;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    public WebDriver driver;

    By clothesMenuLink = By.linkText("CLOTHES");
    By accessoriesMenuLink = By.linkText("ACCESSORIES");
    By artMenuLink = By.linkText("ART");
    By storeLogoLink = By.cssSelector(".logo");
    By searchInput = By.cssSelector(".ui-autocomplete-input");
    By pageNotFoundSection = By.cssSelector(".page-not-found");
    By carouselSection = By.cssSelector(".carousel");
    By activeBanner = By.cssSelector(".carousel-item.active");
    By rightCarouselControl = By.cssSelector("[data-slide='next']");
    By saleBanner = By.cssSelector(".banner");
    By customTextSection = By.cssSelector("#custom-text");
    By popularProductsSection = By.xpath("//h2[contains(text(), 'Popular Products')]/following-sibling::div[@class='products row']");
    By onSaleProductsSection = By.xpath("//h2[contains(text(), 'On sale')]/following-sibling::div[@class='products']");
    By allNewProductsSection = By.xpath("//h2[contains(text(), 'New products')]/following-sibling::div[@class='products']");
    By allProductsButton = By.xpath("//a[contains(@class, 'all-product-link') and contains(text(),'All products')]");
    By onSaleProductsButton = By.xpath("//a[contains(@class, 'all-product-link') and contains(text(),'All sale products')]");
    By allNewProductsButton = By.xpath("//a[contains(@class, 'all-product-link') and contains(text(),'All new products')]");
    By productsList = By.cssSelector(".product-miniature");
    By footer = By.cssSelector(".footer-container");

    public MainPage() {
        this.driver = getDriver();
    }

    /* TODO: создай интернал метод click(element) и туда засунь работу с драйвером */
    public void clickClothesMenuLink() {
        driver.findElement(clothesMenuLink).click();
    }

    public void clickAccessoriesMenuLink() {
        driver.findElement(accessoriesMenuLink).click();
    }

    public void clickArtMenuLink() {
        driver.findElement(artMenuLink).click();
    }

    public void clickStoreLogoLink() {
        driver.findElement(storeLogoLink).click();
    }

    public boolean pageNotFoundSectionIsDisplayed() {
        return driver.findElement(pageNotFoundSection).isDisplayed();
    }

    public boolean carouselSectionIsDisplayed() {
        return driver.findElement(carouselSection).isDisplayed();
    }

    public void searchInputSendKeys(String value) {
        driver.findElement(searchInput).sendKeys(value);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public void clickOnActiveBanner() {
        driver.findElement(activeBanner).click();
    }

    public void clickRightCarouselControl() {
        driver.findElement(rightCarouselControl).click();
    }

    public boolean saleBannerIsDisplayed() {
        return driver.findElement(saleBanner).isDisplayed();
    }

    public void clickSaleBanner() {
        driver.findElement(saleBanner).click();
    }

    public boolean customTextSectionIsDisplayed() {
        return driver.findElement(customTextSection).isDisplayed();
    }


    public boolean popularProductsSectionIsDisplayed() {
        return driver.findElement(popularProductsSection).isDisplayed();
    }

    public boolean onSaleProductsSectionIsDisplayed() {
        return driver.findElement(onSaleProductsSection).isDisplayed();
    }

    public boolean allNewProductsSectionIsDisplayed() {
        return driver.findElement(allNewProductsSection).isDisplayed();
    }

    public void clickAllProductsButton() {
        driver.findElement(allProductsButton).click();
    }

    public void clickOnSaleProductsButton() {
        driver.findElement(onSaleProductsButton).click();
    }

    public void clickAllNewProductsButton() {
        driver.findElement(allNewProductsButton).click();
    }

    public List<WebElement> getProductsList() {
        return driver.findElements(productsList);
    }

    public void clickFirstProduct() {
        getProductsList().get(0).click();
    }

    public void clickSecondProduct() {
        getProductsList().get(1).click();
    }

    public boolean footerIsDisplayed() {
        return driver.findElement(footer).isDisplayed();
    }
}
