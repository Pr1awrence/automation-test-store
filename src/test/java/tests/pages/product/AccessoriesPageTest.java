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
    public void leftMenuCategoriesTest() {
        Assert.assertTrue(accessoriesPage.leftMenuCategoriesIsDisplayed());
    }

    @Test
    public void leftMenuSuppliersTest() {
        Assert.assertTrue(accessoriesPage.leftMenuSuppliersIsDisplayed());
    }

    @Test
    public void leftMenuBrandsTest() {
        Assert.assertTrue(accessoriesPage.leftMenuBrandsIsDisplayed());
    }

    @Test
    public void leftMenuFilterByTest() {
        Assert.assertTrue(accessoriesPage.leftMenuFilterByIsDisplayed());
    }

    @Test
    public void leftMenuSearchFiltersAreDisplayedTest() {
        Assert.assertTrue(accessoriesPage.leftMenuSearchFiltersAreDisplayed());
    }

    @Test
    public void filterByAvailabilityIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterByAvailabilityIsDisplayed());
    }

    @Test
    public void filterBySelectionsIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterBySelectionsIsDisplayed());
    }

    @Test
    public void filterByPriceIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterByPriceIsDisplayed());
    }

    @Test
    public void filterByCategoriesIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterByCategoriesIsDisplayed());
    }

    @Test
    public void filterByColorIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterByColorIsDisplayed());
    }

    @Test
    public void filterByPropertyIsDisplayedTest() {
        Assert.assertTrue(accessoriesPage.filterByPropertyIsDisplayed());
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
