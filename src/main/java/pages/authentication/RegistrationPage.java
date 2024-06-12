package pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPage extends BasePage {
    public WebDriver driver;

    public RegistrationPage() {
        this.driver = getDriver();
    }
    By radioMr = By.cssSelector("input[id='field-id_gender-1']");
    By radioMrs = By.cssSelector("input[id='field-id_gender-2']");
    By firstNameInput = By.cssSelector("input[id='field-firstname']");
    By lastNameInput = By.cssSelector("input[id='field-lastname']");
    By emailInput = By.cssSelector("input[id='field-email']");
    By passwordInput = By.cssSelector("input[id='field-password']");
    By birthdateInput = By.cssSelector("input[id='field-birthday']");
    By policyCheckbox = By.cssSelector("input[name='psgdpr']");
    By offersCheckbox = By.cssSelector("input[name='optin']");
    By newsletterCheckbox = By.cssSelector("input[name='newsletter']");
    By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
    By passwordRequirementsSuccessIcons = By.cssSelector("i[class='material-icons text-success']");
    By invalidNameText = By.xpath("//li[contains(text(), 'Invalid format.')]");
    By invalidBirthdateText = By.xpath("//li[contains(text(), 'Format should be 05/31/1970.')]");

    public void clickRadioMr() {
        driver.findElement(radioMr).click();
    }

    public void clickRadioMrs() {
        driver.findElement(radioMrs).click();
    }

    public boolean isRadioMrSelected() {
        return driver.findElement(radioMr).isSelected();
    }

    public boolean isRadioMrsSelected() {
        return driver.findElement(radioMrs).isSelected();
    }

    public void enterFirstName(String value) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(value);
    }

    public void enterBirthdate(String value) {
        driver.findElement(birthdateInput).clear();
        driver.findElement(birthdateInput).sendKeys(value);
    }

    public void clickPolicyCheckbox() {
        driver.findElement(policyCheckbox).click();
    }

    public boolean isPolicyCheckboxSelected() {
        return driver.findElement(policyCheckbox).isSelected();
    }

    public void clickOffersCheckbox() {
        driver.findElement(offersCheckbox).click();
    }

    public boolean isOffersCheckboxSelected() {
        return driver.findElement(offersCheckbox).isSelected();
    }

    public void clickNewsletterCheckbox() {
        driver.findElement(newsletterCheckbox).click();
    }

    public boolean isNewsletterCheckboxSelected() {
        return driver.findElement(newsletterCheckbox).isSelected();
    }

    public void clickSaveBtn() {
        driver.findElement(saveBtn).click();
    }

    public boolean isPasswordValid() {
        return driver.findElements(passwordRequirementsSuccessIcons).size() == 2;
    }

    public boolean areFirstAndLastNamesInvalid() {
        return driver.findElements(invalidNameText).size() == 2;
    }

    public boolean isBirthdateInvalid() {
        return driver.findElement(invalidBirthdateText).isDisplayed();
    }

    public String generateUserEmail() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        return "user" + timestamp + "@test.com";
    }

    public void fillDefaultRegistrationData() {
        clickRadioMrs();

        enterFirstName("John");
        enterLastName("Smith");
        enterEmail(generateUserEmail());
        enterPassword("d]n@F7-XszurG8n");
        enterBirthdate("01/01/1990");

        clickPolicyCheckbox();
    }
}
