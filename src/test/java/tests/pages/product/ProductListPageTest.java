package tests.pages.product;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.product.ProductListPage;
import tests.pages.BasePageTest;
import utils.ProductDataProvider;
import utils.SortByType;

/**
 * <p>The {@link ProductListPageTest} is a class for testing common functions in product page classes such as {@link ClothesPageTest ClothesPageTest},
 * {@link AccessoriesPageTest AccessoriesPageTest}, and {@link ArtPageTest ArtPageTest}.
 */
public class ProductListPageTest extends BasePageTest {
    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void leftMenuCategoriesTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuCategoriesIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void leftMenuSuppliersTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuSuppliersIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void leftMenuBrandsTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuBrandsIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void leftMenuFilterByTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.leftMenuFilterByIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void leftMenuSearchFiltersAreDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.searchFiltersAreDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void filterByClearAllBtnTest(ProductListPage page) {
        page.navigateToPage();
        page.clickFilterByAvailabilityInStock();

        waitUntilUrlContains("Availability");

        Assert.assertTrue(page.isFilterByAvailabilityInStockChecked());
        Assert.assertTrue(page.filterByClearAllBtnIsDisplayed());

        page.clickFilterByClearAllBtn();

        waitUntilInvisibilityOfAnElement(page.filterByClearAllBtn());

        Assert.assertFalse(page.isFilterByAvailabilityInStockChecked());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void filterByAvailabilityIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByAvailabilityIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void filterBySelectionsIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterBySelectionsIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void filterByPriceIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByPriceIsDisplayed());
    }

    @Test(dataProvider = "productListClothesAccessoriesPages", dataProviderClass = ProductDataProvider.class)
    public void filterByCategoriesIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByCategoriesIsDisplayed());
    }

    @Test(dataProvider = "productListClothesAccessoriesPages", dataProviderClass = ProductDataProvider.class)
    public void filterByColorIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByColorIsDisplayed());
    }

    @Test(dataProvider = "productListClothesAccessoriesPages", dataProviderClass = ProductDataProvider.class)
    public void filterByPropertyIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByPropertyIsDisplayed());
    }

    @Test(dataProvider = "productListAccessoriesArtPages", dataProviderClass = ProductDataProvider.class)
    public void filterByCompositionIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByCompositionIsDisplayed());
    }

    @Test(dataProvider = "productListAccessoriesArtPages", dataProviderClass = ProductDataProvider.class)
    public void filterByBrandIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.filterByBrandIsDisplayed());
    }

    @Test(dataProvider = "priceSliderRangesProductPagesProvider", dataProviderClass = ProductDataProvider.class)
    public void filterByPriceRangeTest(ProductListPage page, String range) {
        page.navigateToPage();

        page.setSliderValueBySpecifiedPriceRange(range);

        waitUntilUrlContains("Price");
        Assert.assertEquals(page.getTextFilterByPriceRange(), range);
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void cardBlockIsDisplayedTest(ProductListPage page) {
        page.navigateToPage();
        Assert.assertTrue(page.cardBlockIsDisplayed());
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void activePanelFilterByAvailabilityInStockTest(ProductListPage page) {
        page.navigateToPage();
        page.clickFilterByAvailabilityInStock();

        waitUntilUrlContains("Availability");

        Assert.assertTrue(page.isFilterByAvailabilityInStockChecked());
        Assert.assertTrue(page.doesActiveFiltersPanelContainAvailabilityInStock());

        page.clickActiveFiltersBlockClearBtn();

        waitUntilInvisibilityOfAnElement(page.activeFiltersBlockClearBtn());

        Assert.assertFalse(page.isFilterByAvailabilityInStockChecked());
    }

    @Test(dataProvider = "colorClothesAccessoriesPagesProvider", dataProviderClass = ProductDataProvider.class)
    public void activePanelFilterByColorCheckboxTest(ProductListPage page, String color, String urlPart) {
        page.navigateToPage();
        page.clickFilterByColorCheckbox(color);

        waitUntilUrlContains(urlPart);

        Assert.assertTrue(page.activeFiltersPanelIsDisplayed());
        Assert.assertTrue(page.doesActiveFiltersBlockContainColor(color));
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void sortByDropdownMenuPriceAscTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByPriceLowToHighBtn();

        waitUntilUrlContains("product.price.asc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.PRICE_ASC));
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void sortByDropdownMenuPriceDescTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByPriceHighToLowBtn();

        waitUntilUrlContains("product.price.desc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.PRICE_DESC));
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void sortByDropdownMenuNameAscTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByNameAToZBtn();

        waitUntilUrlContains("product.name.asc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.NAME_ASC));
    }

    @Test(dataProvider = "productListPages", dataProviderClass = ProductDataProvider.class)
    public void sortByDropdownMenuNameDescTest(ProductListPage page) {
        page.navigateToPage();

        page.clickSortByBtn();
        page.clickSortByNameZToABtn();

        waitUntilUrlContains("product.name.desc");

        Assert.assertTrue(page.areProductsSortedByType(SortByType.NAME_DESC));
    }
}
