package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.main.MainPage;
import pages.product.ArtPage;

public class ArtPageTest extends ProductListPageTest {
    private ArtPage artPage;

    @BeforeMethod
    public void artPageSetup() {
        MainPage mainPage = new MainPage();
        mainPage.clickArtMenuLink();
        artPage = new ArtPage();
    }

    @Test
    public void filterByDimensionIsDisplayedTest() {
        Assert.assertTrue(artPage.filterByDimensionIsDisplayed());
    }
}
