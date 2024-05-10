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

    @Test
    public void filterBySizeIsDisplayedTest() {
        Assert.assertTrue(clothesPage.filterBySizeIsDisplayed());
    }

    // TODO: maybe it's a point to create additional provider - second param isn't used
    @Test(dataProvider = "categoryProvider", dataProviderClass = ProductDataProvider.class)
    public void leftMenuCategoryLinkTest(String category, String urlPart) {
        clothesPage.clickLeftMenuClothesCategory(category);

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, clothesPage.categoryClothesPageUrl(category));
    }

    @Test(dataProvider = "categoryProvider", dataProviderClass = ProductDataProvider.class)
    public void leftMenuFilterByCategoryCheckboxTest(String category, String urlPart) {
        clothesPage.clickLeftMenuFilterByCategoryCheckbox(category);

        waitUntilUrlContains(urlPart);

        Assert.assertTrue(clothesPage.activeFiltersPanelIsDisplayed());
        Assert.assertTrue(clothesPage.doesActiveFiltersBlockContainCategory(category));
    }

    @Test(dataProvider = "sizeProvider", dataProviderClass = ProductDataProvider.class)
    public void leftMenuFilterBySizeCheckboxTest(String size, String urlPart) {
        clothesPage.clickLeftMenuFilterBySizeCheckbox(size);

        waitUntilUrlContains(urlPart);

        Assert.assertTrue(clothesPage.activeFiltersPanelIsDisplayed());
        Assert.assertTrue(clothesPage.doesActiveFiltersBlockContainSize(size));
    }

    // TODO: Need to refactor code
/*

    @Test
    public void leftMenuFilterBySizeMCheckboxTest() {
        clothesPage.clickLeftMenuFilterBySizeMCheckbox();

        waitUntilUrlContains("Size-M");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Size-M");
    }

    @Test
    public void leftMenuFilterBySizeLCheckboxTest() {
        clothesPage.clickLeftMenuFilterBySizeLCheckbox();

        waitUntilUrlContains("Size-L");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Size-L");
    }

    @Test
    public void leftMenuFilterBySizeXLCheckboxTest() {
        clothesPage.clickLeftMenuFilterBySizeXLCheckbox();

        waitUntilUrlContains("Size-XL");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Size-XL");
    }

    @Test
    public void leftMenuFilterByColorWhiteCheckboxTest() {
        clothesPage.clickLeftMenuFilterByColorWhiteCheckbox();

        waitUntilUrlContains("Color-White");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Color-White");
    }

    @Test
    public void leftMenuFilterByColorBlackCheckboxTest() {
        clothesPage.clickLeftMenuFilterByColorBlackCheckbox();

        waitUntilUrlContains("Color-Black");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Color-Black");
    }

    @Test
    public void leftMenuFilterByPropertyLongSleevesCheckboxTest() {
        clothesPage.clickLeftMenuFilterByPropertyLongSleevesCheckbox();

        waitUntilUrlContains("Property-Long+sleeves");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Property-Long+sleeves");
    }

    @Test
    public void leftMenuFilterByPropertyShortSleevesCheckboxTest() {
        clothesPage.clickLeftMenuFilterByPropertyShortSleevesCheckbox();

        waitUntilUrlContains("Property-Short+sleeves");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Property-Short+sleeves");
    }

    @Test
    public void leftMenuPriceRangeTest() {

    }

    @Test
    public void leftMenuPriceSliderLeftHandleTest() {
        clothesPage.setValueLeftMenuPriceSliderLeftHandle(50);
    }*/
}
