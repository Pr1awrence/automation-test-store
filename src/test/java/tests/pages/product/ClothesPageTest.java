package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.product.ClothesPage;
import pages.main.MainPage;
import tests.pages.BasePageTest;
import utils.ProductDataProvider;

public class ClothesPageTest extends BasePageTest {
    private ClothesPage clothesPage;

    @BeforeMethod
    public void clothesPageSetup() {
        MainPage mainPage = new MainPage();
        mainPage.clickClothesMenuLink();
        clothesPage = new ClothesPage();
    }

    // TODO: maybe it's a point to create additional provider - second param isn't used
    @Test(dataProvider = "categoryProvider", dataProviderClass = ProductDataProvider.class)
    public void leftMenuCategoryLinkTest(String category, String urlPart) {
        clothesPage.clickLeftMenuClothesCategory(category);

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, clothesPage.categoryClothesPageUrl(category));
    }

    @Test(dataProvider = "categoryProvider", dataProviderClass = ProductDataProvider.class)
    public void filterByCategoryCheckboxTest(String category, String urlPart) {
        clothesPage.clickFilterByCategoryCheckbox(category);

        waitUntilUrlContains(urlPart);

        Assert.assertTrue(clothesPage.activeFiltersPanelIsDisplayed());
        Assert.assertTrue(clothesPage.doesActiveFiltersBlockContainCategory(category));
    }

    @Test
    public void filterBySizeIsDisplayedTest() {
        Assert.assertTrue(clothesPage.filterBySizeIsDisplayed());
    }

    @Test(dataProvider = "sizeProvider", dataProviderClass = ProductDataProvider.class)
    public void filterBySizeCheckboxTest(String size, String urlPart) {
        clothesPage.clickFilterBySizeCheckbox(size);

        waitUntilUrlContains(urlPart);

        Assert.assertTrue(clothesPage.activeFiltersPanelIsDisplayed());
        Assert.assertTrue(clothesPage.doesActiveFiltersBlockContainSize(size));
    }
}
