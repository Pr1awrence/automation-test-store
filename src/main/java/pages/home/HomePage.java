package pages.home;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* Page link: https://www.automationtesting.co.uk/ */
public class HomePage extends BasePage {
    public WebDriver driver;

    By toggle = By.cssSelector(".toggle");
    By inactiveSidebar = By.cssSelector("#sidebar.inactive");
    By homeLink = By.linkText("HOMEPAGE");
    By accordionLink = By.linkText("ACCORDION");
    By browserTabLink = By.linkText("BROWSER TABS");
    By buttonsLink = By.linkText("BUTTONS");
    By calcLink = By.linkText("CALCULATOR (JS)");
    By contactUsLink = By.linkText("CONTACT US FORM TEST");
    By datePickerLink = By.linkText("DATE PICKER");
    By dropdownLink = By.linkText("DROPDOWN CHECKBOX & RADIO");
    By fileUpload = By.linkText("FILE UPLOAD");
    By hiddenElementsLink = By.linkText("HIDDEN ELEMENTS");
    By iFrameLink = By.linkText("IFRAME");
    By loaderLink = By.linkText("LOADER");
    By loginPortalLink = By.linkText("LOGIN PORTAL TEST");
    By mouseLink = By.linkText("MOUSE MOVEMENT");
    By popupLink = By.linkText("POP UPS & ALERTS");
    By predictiveLink = By.linkText("PREDICTIVE SEARCH");
    By tablesLink = By.linkText("TABLES");
    By testStoreLink = By.linkText("TEST STORE");
    By aboutMeLink = By.linkText("ABOUT ME");
    By cookie = By.cssSelector(".close-cookie-warning > span");

    public HomePage() {
        this.driver = getDriver();
    }

    public void closeCookiesPopup() {
        driver.findElement(cookie).click();
    }

    public void goToTestStore() {
        WebElement testStoreLink = driver.findElement(this.testStoreLink);
        boolean isSidebarInactive = !driver.findElements(this.inactiveSidebar).isEmpty();
        if (isSidebarInactive) {
            driver.findElement(toggle).click();
        }
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", testStoreLink);
        testStoreLink.click();
    }
}
