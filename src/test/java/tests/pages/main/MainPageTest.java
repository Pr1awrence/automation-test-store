package tests.pages.main;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.main.MainPage;
import tests.pages.BasePageTest;

public class MainPageTest extends BasePageTest {
    @Test
    public void headerClothesLinkTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickClothesMenuLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, clothesPageUrl);
    }

    @Test
    public void headerAccessoriesLinkTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAccessoriesMenuLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, accessoriesPageUrl);
    }

    @Test
    public void headerArtLinkTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickArtMenuLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, artPageUrl);
    }

    @Test
    public void storeLogoLinkTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickArtMenuLink();
        mainPage.clickStoreLogoLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl);
    }

    @Test
    public void searchInputFullWordTest() {
        MainPage mainPage = new MainPage();
        mainPage.searchInputSendKeys("Sweater");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=Sweater");
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be one product for this search value, but there is none");
        }
    }

    @Test(description = "Bug ID: 1. Should be fixed on FE side", enabled = false)
    public void searchInputOneCharTest() {
        MainPage mainPage = new MainPage();
        mainPage.searchInputSendKeys("S");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=S");
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void searchInputIncorrectValueTest() {
        MainPage mainPage = new MainPage();
        mainPage.searchInputSendKeys("0");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=0");
        Assert.assertTrue(mainPage.pageNotFoundSectionIsDisplayed(), "There should be no products there, but one at least is presented");
    }

    @Test
    public void searchInputEmptyValueTest() {
        MainPage mainPage = new MainPage();
        mainPage.searchInputSendKeys("");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=");
        Assert.assertTrue(mainPage.pageNotFoundSectionIsDisplayed(), "There should be no products there, but one at least is presented");
    }

    @Test
    public void carouselIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.carouselSectionIsDisplayed());
    }

    @Test
    public void bannersTest() {
        MainPage mainPage = new MainPage();
        /* Check first banner */
        mainPage.clickOnActiveBanner();
        String currentUrl = mainPage.getCurrentUrl();

        Assert.assertTrue(currentUrl.startsWith("https://www.prestashop-project.org/"), "The first banner doesn't lead to the right site");

        /* Check second banner */
        mainPage.driverNavigateBack();
        mainPage.clickRightCarouselControl();
        mainPage.clickOnActiveBanner();
        currentUrl = mainPage.getCurrentUrl();

        Assert.assertTrue(currentUrl.startsWith("https://www.prestashop-project.org/"), "The second banner doesn't lead to the right site");

        /* Check third banner */
        mainPage.driverNavigateBack();
        mainPage.clickRightCarouselControl();
        mainPage.clickOnActiveBanner();
        currentUrl = mainPage.getCurrentUrl();

        Assert.assertTrue(currentUrl.startsWith("https://www.prestashop-project.org/"), "The third banner doesn't lead to the right site");
    }

    @Test
    public void saleBannerIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.saleBannerIsDisplayed());
    }

    @Test(description = "Bug ID: 2. Should be fixed on FE side", enabled = false)
    public void saleBannerTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickSaleBanner();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, clothesPageUrl);
    }

    @Test
    public void customTextSectionIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.customTextSectionIsDisplayed());
    }

    @Test
    public void popularProductsSectionIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.popularProductsSectionIsDisplayed());
    }

    @Test
    public void allProductsButtonTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAllProductsButton();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, homePageUrl);
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void onSaleProductsSectionIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.onSaleProductsSectionIsDisplayed());
    }

    @Test
    public void onSaleProductsButtonTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnSaleProductsButton();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, pricesDropPageUrl);
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void allNewProductsSectionIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.allNewProductsSectionIsDisplayed());
    }

    @Test(description = "Bug ID: 3. Should be fixed on FE side", enabled = false)
    public void allNewProductsButtonTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAllNewProductsButton();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, newProductsPageUrl);
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void footerIsDisplayedTest() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.footerIsDisplayed());
    }
}
