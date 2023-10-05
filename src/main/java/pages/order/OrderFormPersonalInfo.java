package pages.order;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Page link: http://teststore.automationtesting.co.uk/order */
public class OrderFormPersonalInfo extends BasePage {
    public WebDriver driver;

    By genderMr = By.cssSelector("label:nth-of-type(1) > .custom-radio > input[name='id_gender']");
    By genderMrs = By.cssSelector("label:nth-of-type(2) > .custom-radio > input[name='id_gender']");
    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By emailField = By.cssSelector("form#customer-form > section input[name='email']");
    By passwordField = By.cssSelector("form#customer-form > section input[name='password']");
    By birthDateField = By.cssSelector("input[name='birthday']");
    By receiveOffersCheckbox = By.cssSelector("div:nth-of-type(7)  span > label > span");
    By newsletterCheckbox = By.cssSelector("div:nth-of-type(8)  span > label > span");
    By termsConditionsCheckbox = By.cssSelector("input[name='psgdpr']");
    By continueBtn = By.cssSelector("form#customer-form  button[name='continue']");

    public OrderFormPersonalInfo() {
        this.driver = getDriver();
    }

    public void chooseGenderMr() {
        driver.findElement(genderMr).click();
    }

    public void chooseGenderMrs() {
        driver.findElement(genderMrs).click();
    }

    public void enterFirstName() {
        driver.findElement(firstNameField).sendKeys("John");
    }

    public void enterLastName() {
        driver.findElement(lastNameField).sendKeys("Smith");
    }

    public void enterEmail() {
        driver.findElement(emailField).sendKeys("johnsmith@test.com");
    }

    public void agreeTermsAndConditions() {
        driver.findElement(termsConditionsCheckbox).click();
    }

    public void clickContinueBtn() {
        driver.findElement(continueBtn).click();
    }
}
