package tests.pages.clothes;

import core.WebDriverInstance;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.clothes.ClothesPage;
import pages.main.MainPage;
import tests.pages.BasePageTest;

import java.time.Duration;

public class ClothesPageTest extends BasePageTest {
    private ClothesPage clothesPage;

    @BeforeMethod
    public void clothesPageSetup() {
        MainPage mainPage = new MainPage();
        mainPage.clickClothesMenuLink();
        clothesPage = new ClothesPage();
    }

    @Test
    public void leftMenuMenCategoryLinkTest() {
        clothesPage.clickLeftMenuClothesMenCategory();

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/4-men");
    }

    @Test
    public void leftMenuWomenCategoryLinkTest() {
        clothesPage.clickLeftMenuClothesWomenCategory();

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/5-women");
    }

    @Test
    public void leftMenuSearchFiltersAreDisplayedTest() {
        Assert.assertTrue(clothesPage.leftMenuSearchFiltersAreDisplayed());
    }

    @Test
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
    }

    private void waitUntilUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriverInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains(url));
    }
}
