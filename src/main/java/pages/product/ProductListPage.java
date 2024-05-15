package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import utils.SortByType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>The {@link pages.product.ProductListPage ProductListPage} class is a common unifying class for Product pages such as {@link pages.product.ClothesPage ClothesPage},
 * {@link pages.product.AccessoriesPage AccessoriesPage}, and {@link pages.product.ArtPage ArtPage}.
 * It stores common locators for easy access.
 */
public abstract class ProductListPage extends BasePage {
    public WebDriver driver;

    By leftMenuCategories = By.cssSelector(".block-categories");
    By leftMenuSuppliers = By.id("search_filters_suppliers");
    By leftMenuBrands = By.id("search_filters_brands");
    By filterBy = By.id("search_filters");
    By filterSections = By.cssSelector("section[class='facet clearfix']");
    By filterByClearAllBtn = By.xpath("//button[contains(., 'Clear all')]");
    By filterByAvailability = By.cssSelector("[data-type='availability']");
    By filterBySelections = By.cssSelector("[data-type='extras']");
    By filterByPrice = By.cssSelector("[data-type='price']");
    By filterByCategories = By.cssSelector("[data-type='category']");
    By filterBySize = By.xpath("//section[@data-type='attribute_group']//p[contains(text(), 'Size')]");
    By filterByColor = By.xpath("//section[@data-type='attribute_group']//p[contains(text(), 'Color')]");
    By filterByProperty = By.xpath("//section[@data-type='feature']//p[contains(text(), 'Property')]");
    By filterByComposition = By.xpath("//section[@data-type='feature']//p[contains(text(), 'Composition')]");
    By filterByBrand = By.cssSelector("[data-type='manufacturer']");
    By filterByPaperType = By.xpath("//section[@data-type='attribute_group']//p[contains(text(), 'Paper Type')]");
    By filterByDimension = By.xpath("//section[@data-type='attribute_group']//p[contains(text(), 'Dimension')]");
    By filterByAvailabilityInStockCheckbox = By.xpath("//section//a[contains(text(), 'In stock')]/preceding-sibling::span/input");
    By filterByColorWhiteCheckbox = By.xpath("//section//a[contains(text(), 'White')]");
    By filterByColorBlackCheckbox = By.xpath("//section//a[contains(text(), 'Black')]");
    By filterByPriceRangeMinMax = By.xpath("//section//p[starts-with(@id, 'facet_label')]");
    By filterByPriceRangeSlider = By.xpath("//div[starts-with(@class, 'ui-slider-range')]");
    By filterByPriceSliderLeftHandle = By.xpath("//section//a[@class='ui-slider-handle ui-state-default ui-corner-all'][1]");
    By filterByPriceSliderRightHandle = By.xpath("//section//a[@class='ui-slider-handle ui-state-default ui-corner-all'][2]");

    /* <--- PAGE CONTENT ---> */
    By cardBlock = By.cssSelector(".block-category.card.card-block");
    By activeFiltersPanel = By.cssSelector(".active_filters");
    By activeFiltersBlockAvailabilityInStock = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'In stock')]");
    By activeFiltersBlockCategoriesColorWhite = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'White')]");
    By activeFiltersBlockCategoriesColorBlack = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'Black')]");
    By activeFiltersBlockClearBtn = By.xpath("//i[contains(@class, 'material-icons close')]");

    /* <--- SORT BY ---> */
    By sortByBtn = By.cssSelector(".btn-unstyle.select-title");
    By sortByPriceAscBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Price, low to high')]");
    By sortByPriceDescBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Price, high to low')]");
    By sortByNameAscBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Name, A to Z')]");
    By sortByNameDescBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Name, Z to A')]");
    By sortByProductHeaders = By.cssSelector("article.product-miniature h2.h3.product-title a");
    By sortByProductNewPrices = By.cssSelector("[aria-label='Price']");

    public ProductListPage() {
        this.driver = getDriver();
    }

    public abstract void navigateToPage();

    public boolean leftMenuCategoriesIsDisplayed() {
        return driver.findElement(leftMenuCategories).isDisplayed();
    }

    public boolean leftMenuSuppliersIsDisplayed() {
        return driver.findElement(leftMenuSuppliers).isDisplayed();
    }

    public boolean leftMenuBrandsIsDisplayed() {
        return driver.findElement(leftMenuBrands).isDisplayed();
    }

    public boolean leftMenuFilterByIsDisplayed() {
        return driver.findElement(filterBy).isDisplayed();
    }

    private List<WebElement> getFilterSections() {
        return driver.findElements(filterSections);
    }

    public boolean searchFiltersAreDisplayed() {
        return !getFilterSections().isEmpty();
    }

    public void clickFilterByClearAllBtn() {
        driver.findElement(filterByClearAllBtn).click();
    }

    public WebElement filterByClearAllBtn() {
        return driver.findElement(filterByClearAllBtn);
    }

    public boolean filterByClearAllBtnIsDisplayed() {
        return driver.findElement(filterByClearAllBtn).isDisplayed();
    }

    public boolean filterByAvailabilityIsDisplayed() {
        return driver.findElement(filterByAvailability).isDisplayed();
    }

    public boolean filterBySelectionsIsDisplayed() {
        return driver.findElement(filterBySelections).isDisplayed();
    }

    public boolean filterByPriceIsDisplayed() {
        return driver.findElement(filterByPrice).isDisplayed();
    }

    public boolean filterByCategoriesIsDisplayed() {
        return driver.findElement(filterByCategories).isDisplayed();
    }

    public boolean filterBySizeIsDisplayed() {
        return driver.findElement(filterBySize).isDisplayed();
    }

    public boolean filterByColorIsDisplayed() {
        return driver.findElement(filterByColor).isDisplayed();
    }

    public boolean filterByPropertyIsDisplayed() {
        return driver.findElement(filterByProperty).isDisplayed();
    }

    public boolean filterByCompositionIsDisplayed() {
        return driver.findElement(filterByComposition).isDisplayed();
    }

    public boolean filterByBrandIsDisplayed() {
        return driver.findElement(filterByBrand).isDisplayed();
    }

    public boolean filterByPaperTypeIsDisplayed() {
        return driver.findElement(filterByPaperType).isDisplayed();
    }

    public boolean filterByDimensionIsDisplayed() {
        return driver.findElement(filterByDimension).isDisplayed();
    }

    public boolean isFilterByAvailabilityInStockChecked() {
        return driver.findElement(filterByAvailabilityInStockCheckbox).isSelected();
    }

    public void clickFilterByAvailabilityInStock() {
        driver.findElement(filterByAvailabilityInStockCheckbox).click();
    }

    public void clickFilterByColorCheckbox(String color){
        switch (color) {
            case "White" -> driver.findElement(filterByColorWhiteCheckbox).click();
            case "Black" -> driver.findElement(filterByColorBlackCheckbox).click();
            default -> throw new IllegalStateException("Unexpected color value: " + color);
        }
    }

    public void setSliderValueBySpecifiedPriceRange(String range) {
        WebElement leftHandle = driver.findElement(filterByPriceSliderLeftHandle);

        double originalRangePricePerPixel = calculatePricePerPixel(getTextFilterByPriceRange());
        int[] priceDifferenceInStartAndEndRanges = priceDifferenceInStartAndEndRanges(range);

        int pixelsToMove = (int) Math.round(1 / originalRangePricePerPixel);

        Actions action = new Actions(driver);
        action.clickAndHold(leftHandle).moveByOffset(pixelsToMove * priceDifferenceInStartAndEndRanges[0], 0).release().perform();

        // The page is reloading, so I need to get the right handle here because of the StaleElementReferenceException
        WebElement rightHandle = driver.findElement(filterByPriceSliderRightHandle);
        action.clickAndHold(rightHandle).moveByOffset(-pixelsToMove * priceDifferenceInStartAndEndRanges[1], 0).release().perform();
    }

    private double calculatePricePerPixel(String range) {
        double[] specifiedRangePrices = parsePriceRange(range);
        double minPrice = specifiedRangePrices[0];
        double maxPrice = specifiedRangePrices[1];

        double specifiedPriceRange = maxPrice - minPrice;

        WebElement sliderElement = driver.findElement(filterByPriceRangeSlider);
        String widthString = sliderElement.getCssValue("width");

        double sliderWidth = Double.parseDouble(widthString.replace("px", ""));

        return specifiedPriceRange / sliderWidth;
    }

    public String getTextFilterByPriceRange(){
        return driver.findElement(filterByPriceRangeMinMax).getText();
    }

    private double[] parsePriceRange(String range) {
        String[] rawPrices = range.replaceAll("\\$", "").split(" - ");
        return new double[]{Double.parseDouble(rawPrices[0]), Double.parseDouble(rawPrices[1])};
    }

    private int[] priceDifferenceInStartAndEndRanges(String range) {
        double[] originalPriceRange = parsePriceRange(getTextFilterByPriceRange());
        double[] specifiedPriceRange = parsePriceRange(range);

        int startRangeInDollars = (int) (specifiedPriceRange[0] - originalPriceRange[0]);
        int endRangeInDollars = (int) (originalPriceRange[1] - specifiedPriceRange[1]);

        return new int[]{startRangeInDollars, endRangeInDollars};
    }

    /* <--- PAGE CONTENT ---> */
    public boolean cardBlockIsDisplayed() {
        return driver.findElement(cardBlock).isDisplayed();
    }

    public boolean activeFiltersPanelIsDisplayed() {
        return driver.findElement(activeFiltersPanel).isDisplayed();
    }

    public boolean doesActiveFiltersPanelContainAvailabilityInStock() {
        return driver.findElement(activeFiltersBlockAvailabilityInStock).isDisplayed();
    }

    public boolean doesActiveFiltersBlockContainColor(String color) {
        return switch (color) {
            case "White" -> driver.findElement(activeFiltersBlockCategoriesColorWhite).isDisplayed();
            case "Black" -> driver.findElement(activeFiltersBlockCategoriesColorBlack).isDisplayed();
            default -> false;
        };
    }

    public void clickActiveFiltersBlockClearBtn() {
        driver.findElement(activeFiltersBlockClearBtn).click();
    }

    public WebElement activeFiltersBlockClearBtn() {
        return driver.findElement(activeFiltersBlockClearBtn);
    }

    /* <--- SORT BY ---> */
    public void clickSortByBtn(){
        driver.findElement(sortByBtn).click();
    }

    public void clickSortByPriceLowToHighBtn(){
        driver.findElement(sortByPriceAscBtn).click();
    }

    public void clickSortByPriceHighToLowBtn(){
        driver.findElement(sortByPriceDescBtn).click();
    }

    public void clickSortByNameAToZBtn(){
        driver.findElement(sortByNameAscBtn).click();
    }

    public void clickSortByNameZToABtn(){
        driver.findElement(sortByNameDescBtn).click();
    }

    public boolean areProductsSortedByType(SortByType type) {
        return switch (type) {
            case NAME_ASC, NAME_DESC -> areNamesSorted(sortByProductHeaders, type);
            case PRICE_ASC, PRICE_DESC -> arePricesSorted(sortByProductNewPrices, type);
        };
    }

    private boolean areNamesSorted(By element, SortByType type) {
        List<WebElement> productElements = driver.findElements(element);

        List<String> elementsText = new ArrayList<>();
        for (WebElement e : productElements) {
            elementsText.add(e.getText());
        }

        List<String> sortedList = new ArrayList<>(elementsText);
        Comparator<String> comparator = null;
        if (type == SortByType.NAME_DESC) {
            comparator = Collections.reverseOrder();
        }
        sortedList.sort(comparator);

        return sortedList.equals(elementsText);
    }

    private boolean arePricesSorted(By element, SortByType type) {
        List<WebElement> productElements = driver.findElements(element);

        List<Float> elementsFloat = new ArrayList<>();

        for (WebElement e : productElements) {
            String text = e.getText();
            try {
                float floatValue = Float.parseFloat(text.substring(1)); // remove $ from the start
                elementsFloat.add(floatValue);
            } catch (NumberFormatException ex) {
                System.err.println("Error converting text to a number " + text);
            }
        }

        List<Float> sortedList = new ArrayList<>(elementsFloat);
        Comparator<Float> comparator = null;
        if (type == SortByType.PRICE_DESC) {
            comparator = Collections.reverseOrder();
        }
        sortedList.sort(comparator);

        return sortedList.equals(elementsFloat);
    }
}
