package tests.pages.home;

import core.Hooks;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.home.HomePage;

public class HomePageTest extends Hooks {
    @Test
    public void headerClothesLinkTest() {
        HomePage homePage = new HomePage();
        homePage.clickClothesMenuLink();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes");
    }

    @Test
    public void headerAccessoriesLinkTest() {
        HomePage homePage = new HomePage();
        homePage.clickAccessoriesMenuLink();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/6-accessories");
    }

    @Test
    public void headerArtLinkTest() {
        HomePage homePage = new HomePage();
        homePage.clickArtMenuLink();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/9-art");
    }

    @Test
    public void storeLogoLinkTest() {
        HomePage homePage = new HomePage();
        homePage.clickArtMenuLink();
        homePage.clickStoreLogoLink();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/");
    }

    @Test
    public void searchInputFullWordTest() {
        HomePage homePage = new HomePage();
        homePage.searchInputSendKeys("Sweater");

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/search?controller=search&s=Sweater");
        if (homePage.getProductsList().isEmpty()) {
            Assert.fail("There should be one product for this search value, but there is none");
        }
    }

    @Test(description = "Should be fixed on FE side", enabled = false)
    public void searchInputOneCharTest() {
        HomePage homePage = new HomePage();
        homePage.searchInputSendKeys("S");

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/search?controller=search&s=S");
        if (homePage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void searchInputIncorrectValueTest() {
        HomePage homePage = new HomePage();
        homePage.searchInputSendKeys("123");

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/search?controller=search&s=123");
        if (!homePage.pageNotFoundSectionIsDisplayed()) {
            Assert.fail("There should be no products there, but one at least is presented");
        }
    }

    @Test
    public void searchInputEmptyValueTest() {
        HomePage homePage = new HomePage();
        homePage.searchInputSendKeys("");

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/search?controller=search&s=");
        Assert.assertTrue(homePage.pageNotFoundSectionIsDisplayed(), "There should be no products there, but one at least is presented");
    }

    @Test
    public void carouselIsDisplayedTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.carouselSectionIsDisplayed());
    }

    @Test
    public void bannersTest() {
        HomePage homePage = new HomePage();
        /* Check first banner */
        homePage.clickOnActiveBanner();
        String currentUrl = homePage.getCurrentUrl();

        Assert.assertTrue(currentUrl.startsWith("https://prestashop.com"), "The first banner doesn't lead to the right site");

        /* Check second banner */
        homePage.driverNavigateBack();
        homePage.clickRightCarouselControl();
        homePage.clickOnActiveBanner();
        currentUrl = homePage.getCurrentUrl();

        Assert.assertTrue(currentUrl.startsWith("https://prestashop.com"), "The second banner doesn't lead to the right site");

        /* Check third banner */
        homePage.driverNavigateBack();
        homePage.clickRightCarouselControl();
        homePage.clickOnActiveBanner();
        currentUrl = homePage.getCurrentUrl();

        Assert.assertTrue(currentUrl.startsWith("https://prestashop.com"), "The third banner doesn't lead to the right site");
    }

    @Test
    public void popularProductsSectionIsDisplayedTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.popularProductsSectionIsDisplayed());
    }

    @Test
    public void allProductsButtonTest() {
        HomePage homePage = new HomePage();
        homePage.clickAllProductsButton();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/2-home");
    }

    @Test
    public void saleBannerIsDisplayedTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.saleBannerIsDisplayed());
    }

    @Test(description = "Should be fixed on FE side", enabled = false)
    public void saleBannerTest() {
        HomePage homePage = new HomePage();
        homePage.clickSaleBanner();

        String currentUrl = homePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes");
    }

    @Test
    public void customTextSectionIsDisplayedTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.customTextSectionIsDisplayed());
    }

    @Test
    public void subscriptionButtonIsDisabledTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.isSubscribeButtonDisabled());
    }

    @Test
    public void subscriptionButtonIsEnabledTest() {
        HomePage homePage = new HomePage();
        homePage.clickSubscriptionConsentCheckbox();

        Assert.assertFalse(homePage.isSubscribeButtonDisabled());
    }

    @Test(description = "Must unsubscribe the user or delete an existing email from the DB", enabled = false)
    public void subscribeWithRealEmailTest() {
        HomePage homePage = new HomePage();
        homePage.inputEmailSubscriptionSendKeys("11111@gmail.com");
        homePage.clickSubscriptionConsentCheckbox();
        homePage.clickSubscribeButton();

        Assert.assertTrue(homePage.alertSuccessSubscriptionIsDisplayed());
    }

    @Test
    public void subscribeWithIncorrectEmailTest() {
        HomePage homePage = new HomePage();
        homePage.inputEmailSubscriptionSendKeys("q@q");
        homePage.clickSubscriptionConsentCheckbox();
        homePage.clickSubscribeButton();

        Assert.assertTrue(homePage.alertFailedSubscriptionIsDisplayed());
    }

    @Test
    public void subscribeWithEmptyEmailTest() {
        HomePage homePage = new HomePage();
        homePage.inputEmailSubscriptionSendKeys("");
        homePage.clickSubscriptionConsentCheckbox();
        homePage.clickSubscribeButton();

        Assert.assertTrue(homePage.alertFailedSubscriptionIsDisplayed());
    }

    @Test
    public void subscribeWithRegisteredEmailTest() {
        HomePage homePage = new HomePage();
        homePage.inputEmailSubscriptionSendKeys("11111@gmail.com");
        homePage.clickSubscriptionConsentCheckbox();
        homePage.clickSubscribeButton();

        Assert.assertTrue(homePage.alertEmailExistsSubscriptionIsDisplayed());
    }

    @Test
    public void footerIsDisplayedTest() {
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.footerIsDisplayed());
    }
}
