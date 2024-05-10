package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.product.AccessoriesPage;
import pages.product.ArtPage;
import pages.product.ClothesPage;
import pages.product.ProductListPage;
import tests.pages.BasePageTest;
import utils.SortByType;

/**
 * <p>The {@link ProductListPageTest} class is a common unifying class for Product page tests such as {@link ClothesPageTest ClothesPageTest},
 * {@link AccessoriesPageTest AccessoriesPageTest}, and {@link ArtPageTest ArtPageTest}.
 * Since the product pages have many similarities, the tests aim to test the overall functionality in one place and reuse the methods.
 */
public class ProductListPageTest extends BasePageTest {
    @DataProvider(name = "productListPages")
    public Object[] productListPages() {
        return new Object[] {
                new ClothesPage(),
                new AccessoriesPage(),
                new ArtPage()
        };
    }

    @DataProvider(name = "productListClothesAccessoriesPages")
    public Object[] productListClothesAccessoriesPages() {
        return new Object[] {
                new ClothesPage(),
                new AccessoriesPage()
        };
    }

    @DataProvider(name = "productListAccessoriesArtPages")
    public Object[] productListAccessoriesArtPages() {
        return new Object[] {
                new AccessoriesPage(),
                new ArtPage()
        };
    }

    @Test(dataProvider = "productListPages")
    public void leftMenuCategoriesTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuCategoriesIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void leftMenuSuppliersTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuSuppliersIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void leftMenuBrandsTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuBrandsIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void leftMenuFilterByTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuFilterByIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void leftMenuSearchFiltersAreDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuSearchFiltersAreDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void filterByAvailabilityIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByAvailabilityIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void filterBySelectionsIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterBySelectionsIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void filterByPriceIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByPriceIsDisplayed());
    }

    @Test(dataProvider = "productListClothesAccessoriesPages")
    public void filterByCategoriesIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByCategoriesIsDisplayed());
    }

    @Test(dataProvider = "productListClothesAccessoriesPages")
    public void filterByColorIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByColorIsDisplayed());
    }

    @Test(dataProvider = "productListClothesAccessoriesPages")
    public void filterByPropertyIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByPropertyIsDisplayed());
    }

    @Test(dataProvider = "productListAccessoriesArtPages")
    public void filterByCompositionIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByCompositionIsDisplayed());
    }

    @Test(dataProvider = "productListAccessoriesArtPages")
    public void filterByBrandIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByBrandIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void cardBlockIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.cardBlockIsDisplayed());
    }

    @Test(dataProvider = "productListPages")
    public void sortByDropdownMenuPriceAscTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByPriceLowToHighBtn();

        waitUntilUrlContains("product.price.asc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.PRICE_ASC));
    }

    @Test(dataProvider = "productListPages")
    public void sortByDropdownMenuPriceDescTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByPriceHighToLowBtn();

        waitUntilUrlContains("product.price.desc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.PRICE_DESC));
    }

    @Test(dataProvider = "productListPages")
    public void sortByDropdownMenuNameAscTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByNameAToZBtn();

        waitUntilUrlContains("product.name.asc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.NAME_ASC));
    }

    @Test(dataProvider = "productListPages")
    public void sortByDropdownMenuNameDescTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByNameZToABtn();

        waitUntilUrlContains("product.name.desc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.NAME_DESC));
    }
}
