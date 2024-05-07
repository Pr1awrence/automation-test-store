package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.main.MainPage;
import pages.product.ArtPage;
import tests.pages.BasePageTest;

public class ArtPageTest extends BasePageTest {
    private ArtPage artPage;

    @BeforeMethod
    public void artPageSetup() {
        MainPage mainPage = new MainPage();
        mainPage.clickArtMenuLink();
        artPage = new ArtPage();
    }

    @Test
    public void leftMenuCategoriesTest() {
        Assert.assertTrue(artPage.leftMenuCategoriesIsDisplayed());
    }

    @Test
    public void leftMenuSuppliersTest() {
        Assert.assertTrue(artPage.leftMenuSuppliersIsDisplayed());
    }

    @Test
    public void leftMenuBrandsTest() {
        Assert.assertTrue(artPage.leftMenuBrandsIsDisplayed());
    }

    @Test
    public void leftMenuFilterByTest() {
        Assert.assertTrue(artPage.leftMenuFilterByIsDisplayed());
    }

    @Test
    public void leftMenuSearchFiltersAreDisplayedTest() {
        Assert.assertTrue(artPage.leftMenuSearchFiltersAreDisplayed());
    }

    @Test
    public void filterByAvailabilityIsDisplayedTest() {
        Assert.assertTrue(artPage.filterByAvailabilityIsDisplayed());
    }

    @Test
    public void filterBySelectionsIsDisplayedTest() {
        Assert.assertTrue(artPage.filterBySelectionsIsDisplayed());
    }

    @Test
    public void filterByPriceIsDisplayedTest() {
        Assert.assertTrue(artPage.filterByPriceIsDisplayed());
    }

    @Test
    public void filterByCompositionIsDisplayedTest() {
        Assert.assertTrue(artPage.filterByCompositionIsDisplayed());
    }

    @Test
    public void filterByBrandIsDisplayedTest() {
        Assert.assertTrue(artPage.filterByBrandIsDisplayed());
    }

    @Test
    public void filterByDimensionIsDisplayedTest() {
        Assert.assertTrue(artPage.filterByDimensionIsDisplayed());
    }
}
