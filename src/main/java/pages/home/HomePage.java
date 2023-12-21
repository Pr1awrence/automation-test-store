package pages.home;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/* Page link: http://teststore.automationtesting.co.uk/ */
public class HomePage extends BasePage {
    public WebDriver driver;

    By clothesMenuLink = By.linkText("CLOTHES");
    By accessoriesMenuLink = By.linkText("ACCESSORIES");
    By artMenuLink = By.linkText("ART");
    By storeLogoLink = By.cssSelector(".logo");
    By searchInput = By.cssSelector(".ui-autocomplete-input");
    By pageNotFoundSection = By.cssSelector(".page-not-found");
    By carouselSection = By.cssSelector(".carousel");
    By activeBanner = By.cssSelector(".active");
    By rightCarouselControl = By.cssSelector("[data-slide='next']");
    By popularProductsSection = By.cssSelector(".products");
    By allProductsButton = By.cssSelector(".all-product-link");
    By productsList = By.cssSelector(".product-miniature");
    By saleBanner = By.cssSelector(".banner");
    By customTextSection = By.cssSelector("#custom-text");
    By subscribeButton = By.cssSelector("input[name='submitNewsletter'][value='Subscribe']");
    By subscriptionConsentCheckbox = By.cssSelector("[type='checkbox']");
    By alertSuccessSubscription = By.cssSelector(".alert-success");
    By alertFailedSubscription = By.xpath("//*[contains(text(), 'Invalid email address.')]");
    By alertEmailExistsSubscription = By.xpath("//*[contains(text(), 'This email address is already registered.')]");
    By inputEmailSubscription = By.cssSelector("input[name='email']");
    By footer = By.cssSelector(".footer-container");

    public HomePage() {
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

    public boolean popularProductsSectionIsDisplayed() {
        return driver.findElement(popularProductsSection).isDisplayed();
    }

    public void clickAllProductsButton() {
        driver.findElement(allProductsButton).click();
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

    public boolean saleBannerIsDisplayed() {
        return driver.findElement(saleBanner).isDisplayed();
    }

    public void clickSaleBanner() {
        driver.findElement(saleBanner).click();
    }

    public boolean customTextSectionIsDisplayed() {
        return driver.findElement(customTextSection).isDisplayed();
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribeButton).click();
    }

    public boolean isSubscribeButtonDisabled() {
        return !driver.findElement(subscribeButton).isEnabled();
    }

    public void clickSubscriptionConsentCheckbox() {
        driver.findElement(subscriptionConsentCheckbox).click();
    }

    public void inputEmailSubscriptionSendKeys(String email) {
        driver.findElement(inputEmailSubscription).sendKeys(email);
    }

    public boolean alertSuccessSubscriptionIsDisplayed() {
        return driver.findElement(alertSuccessSubscription).isDisplayed();
    }

    public boolean alertFailedSubscriptionIsDisplayed() {
        return driver.findElement(alertFailedSubscription).isDisplayed();
    }

    public boolean alertEmailExistsSubscriptionIsDisplayed() {
        return driver.findElement(alertEmailExistsSubscription).isDisplayed();
    }

    public boolean footerIsDisplayed() {
        return driver.findElement(footer).isDisplayed();
    }
}
