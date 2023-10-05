package pages.order;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/* Page link: http://teststore.automationtesting.co.uk/order */
public class OrderFormDelivery extends BasePage {
    public WebDriver driver;

    By firstNameField = By.cssSelector("input[name='firstname']");
    By lastNameField = By.cssSelector("input[name='lastname']");
    By companyNameField = By.cssSelector("input[name='company']");
    By addressField = By.cssSelector("input[name='address1']");
    By addressComplementField = By.cssSelector("input[name='address2']");
    By cityField = By.cssSelector("input[name='city']");
    By stateDropdown = By.cssSelector("select[name='id_state']");
    By postcodeField = By.cssSelector("input[name='postcode']");
    By countryDropdown = By.cssSelector("select[name='id_country']");
    By phoneField = By.cssSelector("input[name='phone']");
    By invoiceSameAddressCheckbox = By.cssSelector("input#use_same_address");
    By continueBtn = By.cssSelector("button[name='confirm-addresses']");

    public OrderFormDelivery() {
        this.driver = getDriver();
    }

    public void enterAddress() {
        driver.findElement(addressField).sendKeys("123 Main Street");
    }

    public void enterCity() {
        driver.findElement(cityField).sendKeys("Houston");
    }

    public void chooseStateTexas() {
        Select state = new Select(driver.findElement(stateDropdown));
        state.selectByVisibleText("Texas");
    }

    public void enterPostalCode() {
        driver.findElement(postcodeField).sendKeys("77021");
    }

    public void clickContinueBtn() {
        driver.findElement(continueBtn).click();
    }
}
