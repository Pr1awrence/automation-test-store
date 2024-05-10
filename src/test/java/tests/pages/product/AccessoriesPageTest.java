package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.main.MainPage;
import pages.product.AccessoriesPage;
import tests.pages.BasePageTest;

public class AccessoriesPageTest extends BasePageTest {
    private AccessoriesPage accessoriesPage;

    @BeforeMethod
    public void accessoriesPageSetup() {
        MainPage mainPage = new MainPage();
        mainPage.clickAccessoriesMenuLink();
        accessoriesPage = new AccessoriesPage();
    }

    @Test
    public void filterByPaperTypeIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterByPaperTypeIsDisplayed());
    }

    @Test
    public void leftMenuStationeryCategoryLinkTest() {
        accessoriesPage.clickLeftMenuStationeryCategory();

        String currentUrl = accessoriesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, stationeryPageUrl);
    }

    @Test
    public void leftMenuHomeAccessoriesCategoryLinkTest() {
        accessoriesPage.clickLeftMenuHomeAccessoriesCategory();

        String currentUrl = accessoriesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, homeAccessoriesPageUrl);
    }
}
