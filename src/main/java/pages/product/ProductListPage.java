package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By leftMenuFilterBy = By.id("search_filters");
    By leftMenuFilterSections = By.cssSelector("section[class='facet clearfix']");
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
    By cardBlock = By.cssSelector(".block-category.card.card-block");

    /* <--- SORT BY ---> */
    By sortByBtn = By.cssSelector(".btn-unstyle.select-title");
    By sortByPriceAscBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Price, low to high')]");
    By sortByPriceDescBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Price, high to low')]");
    By sortByNameAscBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Name, A to Z')]");
    By sortByNameDescBtn = By.xpath("//div[@class='dropdown-menu']//a[contains(text(), 'Name, Z to A')]");
    By sortByProductHeaders = By.cssSelector("article.product-miniature h2.h3.product-title a");
    By sortByProductNewPrices = By.cssSelector("[aria-label='Price']");

    /* <--- FILTERS ---> */
    By leftMenuFilterByMenCategoryCheckbox = By.xpath("//section[@class='facet clearfix'][1]//a[contains(text(), 'Men')]");
    By leftMenuFilterByWomenCategoryCheckbox = By.xpath("//section[@class='facet clearfix'][1]//a[contains(text(), 'Women')]");
    By leftMenuFilterBySizeSCheckbox = By.xpath("//section[@class='facet clearfix'][2]//a[contains(text(), 'S')]");
    By leftMenuFilterBySizeMCheckbox = By.xpath("//section[@class='facet clearfix'][2]//a[contains(text(), 'M')]");
    By leftMenuFilterBySizeLCheckbox = By.xpath("//section[@class='facet clearfix'][2]//a[contains(text(), 'L')]");
    By leftMenuFilterBySizeXLCheckbox = By.xpath("//section[@class='facet clearfix'][2]//a[contains(text(), 'XL')]");
    By leftMenuFilterByColorWhiteCheckbox = By.xpath("//section[@class='facet clearfix'][3]//a[contains(text(), 'White')]");
    By leftMenuFilterByColorBlackCheckbox = By.xpath("//section[@class='facet clearfix'][3]//a[contains(text(), 'Black')]");
    By leftMenuFilterByPropertyLongSleevesCheckbox = By.xpath("//section[@class='facet clearfix'][4]//a[contains(text(), 'Long sleeves')]");
    By leftMenuFilterByPropertyShortSleevesCheckbox = By.xpath("//section[@class='facet clearfix'][4]//a[contains(text(), 'Short sleeves')]");
    By leftMenuPriceRange = By.xpath("//section[@class='facet clearfix'][5]//p[contains(text(), 'facet_label')]");
    By leftMenuPriceSliderLeftHandle = By.xpath("//section[@class='facet clearfix'][5]//a[@class='ui-slider-handle ui-state-default ui-corner-all'][1]");
    By leftMenuPriceSliderRightHandle = By.xpath("//section[@class='facet clearfix'][5]//a[@class='ui-slider-handle ui-state-default ui-corner-all'][2]");

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
        return driver.findElement(leftMenuFilterBy).isDisplayed();
    }

    private List<WebElement> getLeftMenuFilterSections() {
        return driver.findElements(leftMenuFilterSections);
    }

    public boolean leftMenuSearchFiltersAreDisplayed() {
        return !getLeftMenuFilterSections().isEmpty();
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

    public boolean cardBlockIsDisplayed() {
        return driver.findElement(cardBlock).isDisplayed();
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
                float floatValue = Float.parseFloat(text);
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

    /* <--- FILTERS ---> */
    public void clickLeftMenuFilterByMenCategoryCheckbox(){
        driver.findElement(leftMenuFilterByMenCategoryCheckbox).click();
    }

    public void clickLeftMenuFilterByWomenCategoryCheckbox(){
        driver.findElement(leftMenuFilterByWomenCategoryCheckbox).click();
    }

    public void clickLeftMenuFilterBySizeSCheckbox(){
        driver.findElement(leftMenuFilterBySizeSCheckbox).click();
    }

    public void clickLeftMenuFilterBySizeMCheckbox(){
        driver.findElement(leftMenuFilterBySizeMCheckbox).click();
    }

    public void clickLeftMenuFilterBySizeLCheckbox(){
        driver.findElement(leftMenuFilterBySizeLCheckbox).click();
    }

    public void clickLeftMenuFilterBySizeXLCheckbox(){
        driver.findElement(leftMenuFilterBySizeXLCheckbox).click();
    }

    public void clickLeftMenuFilterByColorWhiteCheckbox(){
        driver.findElement(leftMenuFilterByColorWhiteCheckbox).click();
    }

    public void clickLeftMenuFilterByColorBlackCheckbox(){
        driver.findElement(leftMenuFilterByColorBlackCheckbox).click();
    }

    public void clickLeftMenuFilterByPropertyLongSleevesCheckbox(){
        driver.findElement(leftMenuFilterByPropertyLongSleevesCheckbox).click();
    }

    public void clickLeftMenuFilterByPropertyShortSleevesCheckbox(){
        driver.findElement(leftMenuFilterByPropertyShortSleevesCheckbox).click();
    }

    public String getTextLeftMenuPriceRange(){
        return driver.findElement(leftMenuPriceRange).getText();
    }

    /* TODO: need to refactor - remove js executor to the base page */
    public void setValueLeftMenuPriceSliderLeftHandle(int value){
        WebElement leftHandle = driver.findElement(leftMenuPriceSliderLeftHandle);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.left = arguments[1];", leftHandle, value);


        System.out.println(leftHandle.getCssValue("left"));
    }
}
