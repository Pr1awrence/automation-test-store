package tests.pages.authentication;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authentication.LoginPage;
import pages.main.MainPage;
import tests.pages.BasePageTest;

public class LoginPageTest extends BasePageTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void loginPageSetup() {
        MainPage mainPage = new MainPage();
        mainPage.clickSignInBtn();
        loginPage = new LoginPage();
    }

    @Test
    public void singInWithValidCredentialsTest() {
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPassword);
        loginPage.clickSingInBtn();

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertFalse(currentUrl.startsWith(loginPageUrl));
    }

    @Test
    public void singInWithInvalidPasswordTest() {
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPassword + "111");
        loginPage.clickSingInBtn();

        Assert.assertTrue(loginPage.authFailedMsgIsShown());
    }

    @Test
    public void singInWithUnregisteredEmailTest() {
        loginPage.enterEmail("unregisteredemail@gmail.com");
        loginPage.enterPassword(userPassword);
        loginPage.clickSingInBtn();

        Assert.assertTrue(loginPage.authFailedMsgIsShown());
    }
}
