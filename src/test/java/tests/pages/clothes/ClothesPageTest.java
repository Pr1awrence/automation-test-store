package tests.pages.clothes;

import core.Hooks;
import core.WebDriverInstance;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.clothes.ClothesPage;
import pages.home.HomePage;

import java.time.Duration;

public class ClothesPageTest extends Hooks {
    @BeforeMethod
    public void clothesPageSetup() {
        HomePage homePage = new HomePage();
        homePage.clickClothesMenuLink();
    }

    @Test
    public void leftMenuMenCategoryLinkTest() {
        ClothesPage clothesPage = new ClothesPage();
        clothesPage.clickLeftMenuClothesMenCategory();

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/4-men");
    }

    @Test
    public void leftMenuWomenCategoryLinkTest() {
        ClothesPage clothesPage = new ClothesPage();
        clothesPage.clickLeftMenuClothesWomenCategory();

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/5-women");
    }

    @Test
    public void leftMenuSearchFiltersAreDisplayedTest() {
        ClothesPage clothesPage = new ClothesPage();

        Assert.assertTrue(clothesPage.leftMenuSearchFiltersAreDisplayed());
    }

    @Test
    public void leftMenuFilterByMenCategoryCheckboxTest() {
        ClothesPage clothesPage = new ClothesPage();
        clothesPage.clickLeftMenuFilterByMenCategoryCheckbox();

        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriverInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("Categories-Men"));

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Categories-Men");
    }

    @Test
    public void leftMenuFilterByWomenCategoryCheckboxTest() {
        ClothesPage clothesPage = new ClothesPage();
        clothesPage.clickLeftMenuFilterByWomenCategoryCheckbox();

        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriverInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("Categories-Women"));

        String currentUrl = clothesPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://teststore.automationtesting.co.uk/3-clothes?q=Categories-Women");
    }
}
