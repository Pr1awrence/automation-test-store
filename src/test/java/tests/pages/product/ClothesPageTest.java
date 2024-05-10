package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.product.ClothesPage;
import pages.main.MainPage;

import utils.SortByType;

public class ClothesPageTest extends ProductListPageTest {
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

    @Test
    public void leftMenuMenCategoryLinkTest() {
        clothesPage.clickLeftMenuClothesMenCategory();

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, menClothesPageUrl);
    }

    @Test
    public void leftMenuWomenCategoryLinkTest() {
        clothesPage.clickLeftMenuClothesWomenCategory();

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, womenClothesPageUrl);
    }

    // TODO: Need to refactor code
/*    @Test
    public void leftMenuFilterByMenCategoryCheckboxTest() {
        clothesPage.clickLeftMenuFilterByMenCategoryCheckbox();

        waitUntilUrlContains("Categories-Men");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Categories-Men");
    }

    @Test
    public void leftMenuFilterByWomenCategoryCheckboxTest() {
        clothesPage.clickLeftMenuFilterByWomenCategoryCheckbox();

        waitUntilUrlContains("Categories-Women");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Categories-Women");
    }

    @Test
    public void leftMenuFilterBySizeSCheckboxTest() {
        clothesPage.clickLeftMenuFilterBySizeSCheckbox();

        waitUntilUrlContains("Size-S");

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Size-S");
    }

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
