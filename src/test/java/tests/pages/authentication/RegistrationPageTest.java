package tests.pages.authentication;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authentication.LoginPage;
import pages.authentication.RegistrationPage;
import pages.main.MainPage;
import tests.pages.BasePageTest;
import utils.RegistrationDataProvider;

public class RegistrationPageTest extends BasePageTest {
    private final MainPage mainPage = new MainPage();
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void registrationPageSetup() {
        mainPage.clickSignInBtn();
        LoginPage loginPage = new LoginPage();
        loginPage.clickRegistrationBtn();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void socialTitlesTest() {
        registrationPage.clickRadioMr();

        Assert.assertTrue(registrationPage.isRadioMrSelected());

        registrationPage.clickRadioMrs();

        Assert.assertTrue(registrationPage.isRadioMrsSelected());
    }

    @Test(description = "Tech ID: 1. Temporary users are not being deleted now", enabled = false, dataProvider = "validFirstAndLastNamesProvider", dataProviderClass = RegistrationDataProvider.class)
    public void validFirstAndLastNamesTest(String firstName, String lastName) {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.clickSaveBtn();

        String currentUrl = registrationPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, mainPageUrl);
        mainPage.clickSignOutBtn();
    }

    @Test(dataProvider = "invalidFirstAndLastNamesProvider", dataProviderClass = RegistrationDataProvider.class)
    public void invalidFirstAndLastNamesTest(String firstName, String lastName) {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.clickSaveBtn();

        Assert.assertTrue(registrationPage.areFirstAndLastNamesInvalid());
    }

    @Test(description = "Tech ID: 1. Temporary users are not being deleted now", enabled = false)
    public void validUserEmailTest() {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterEmail(registrationPage.generateUserEmail());
        registrationPage.clickSaveBtn();

        String currentUrl = registrationPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, mainPageUrl);
        mainPage.clickSignOutBtn();
    }

    @Test(dataProvider = "validPasswordsProvider", dataProviderClass = RegistrationDataProvider.class)
    public void validPasswordsTest(String password) {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterPassword(password);

        Assert.assertTrue(registrationPage.isPasswordValid());
    }

    @Test(dataProvider = "invalidPasswordsProvider", dataProviderClass = RegistrationDataProvider.class)
    public void invalidPasswordsTest(String password) {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterPassword(password);

        Assert.assertFalse(registrationPage.isPasswordValid());
    }

    @Test(description = "Tech ID: 1. Temporary users are not being deleted now", enabled = false, dataProvider = "validBirthDatesProvider", dataProviderClass = RegistrationDataProvider.class)
    public void validBirthDatesTest(String birthdate) {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterBirthdate(birthdate);
        registrationPage.clickSaveBtn();

        String currentUrl = registrationPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, mainPageUrl);
        mainPage.clickSignOutBtn();
    }

    @Test(dataProvider = "invalidBirthDatesProvider", dataProviderClass = RegistrationDataProvider.class)
    public void invalidBirthDatesTest(String birthdate) {
        registrationPage.fillDefaultRegistrationData();
        registrationPage.enterBirthdate(birthdate);
        registrationPage.clickSaveBtn();

        Assert.assertTrue(registrationPage.isBirthdateInvalid());
    }

    @Test
    public void isPolicyCheckboxDisplayedTest() {
        registrationPage.clickPolicyCheckbox();
        Assert.assertTrue(registrationPage.isPolicyCheckboxSelected());
    }

    @Test
    public void isOffersCheckboxDisplayedTest() {
        registrationPage.clickOffersCheckbox();
        Assert.assertTrue(registrationPage.isOffersCheckboxSelected());
    }

    @Test
    public void isNewsletterCheckboxDisplayedTest() {
        registrationPage.clickNewsletterCheckbox();
        Assert.assertTrue(registrationPage.isNewsletterCheckboxSelected());
    }
}
