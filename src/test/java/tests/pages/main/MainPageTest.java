package tests.pages.main;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.main.MainPage;
import tests.pages.BasePageTest;

public class MainPageTest extends BasePageTest {
    private MainPage mainPage;

    @BeforeMethod
    public void mainPageSetup() {
        mainPage = new MainPage();
    }

    @Test
    public void headerClothesLinkTest() {
        mainPage.clickClothesMenuLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, clothesPageUrl);
    }

    @Test
    public void headerAccessoriesLinkTest() {
        mainPage.clickAccessoriesMenuLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, accessoriesPageUrl);
    }

    @Test
    public void headerArtLinkTest() {
        mainPage.clickArtMenuLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, artPageUrl);
    }

    @Test
    public void storeLogoLinkTest() {
        mainPage.clickArtMenuLink();
        mainPage.clickStoreLogoLink();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl);
    }

    @Test
    public void searchInputFullWordTest() {
        mainPage.searchInputSendKeys("Sweater");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=Sweater");
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be one product for this search value, but there is none");
        }
    }

    @Test(description = "Bug ID: 1. Should be fixed on FE side", enabled = false)
    public void searchInputOneCharTest() {
        mainPage.searchInputSendKeys("S");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=S");
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void searchInputIncorrectValueTest() {
        mainPage.searchInputSendKeys("0");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=0");
        Assert.assertTrue(mainPage.pageNotFoundSectionIsDisplayed(), "There should be no products there, but one at least is presented");
    }

    @Test
    public void searchInputEmptyValueTest() {
        mainPage.searchInputSendKeys("");

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl + "?controller=search&s=");
        Assert.assertTrue(mainPage.pageNotFoundSectionIsDisplayed(), "There should be no products there, but one at least is presented");
    }

    @Test
    public void carouselIsDisplayedTest() {
        Assert.assertTrue(mainPage.carouselSectionIsDisplayed());
    }

    @Test
    public void bannersTest() {
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
        Assert.assertTrue(mainPage.saleBannerIsDisplayed());
    }

    @Test(description = "Bug ID: 2. Should be fixed on FE side", enabled = false)
    public void saleBannerTest() {
        mainPage.clickSaleBanner();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, clothesPageUrl);
    }

    @Test
    public void customTextSectionIsDisplayedTest() {
        Assert.assertTrue(mainPage.customTextSectionIsDisplayed());
    }

    @Test
    public void popularProductsSectionIsDisplayedTest() {
        Assert.assertTrue(mainPage.popularProductsSectionIsDisplayed());
    }

    @Test
    public void allProductsButtonTest() {
        mainPage.clickAllProductsButton();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, homePageUrl);
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void onSaleProductsSectionIsDisplayedTest() {
        Assert.assertTrue(mainPage.onSaleProductsSectionIsDisplayed());
    }

    @Test
    public void onSaleProductsButtonTest() {
        mainPage.clickOnSaleProductsButton();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, pricesDropPageUrl);
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void allNewProductsSectionIsDisplayedTest() {
        Assert.assertTrue(mainPage.allNewProductsSectionIsDisplayed());
    }

    @Test(description = "Bug ID: 3. Should be fixed on FE side", enabled = false)
    public void allNewProductsButtonTest() {
        mainPage.clickAllNewProductsButton();

        String currentUrl = mainPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, newProductsPageUrl);
        if (mainPage.getProductsList().isEmpty()) {
            Assert.fail("There should be at least one product for this search value, but there is none");
        }
    }

    @Test
    public void footerIsDisplayedTest() {
        Assert.assertTrue(mainPage.footerIsDisplayed());
    }
}
