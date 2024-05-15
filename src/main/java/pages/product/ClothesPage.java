package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.main.MainPage;

public class ClothesPage extends ProductListPage {
    public WebDriver driver;

    By leftMenuMenCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Men']");
    By leftMenuWomenCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Women']");
    By filterByMenCategoryCheckbox = By.xpath("//section[@class='facet clearfix'][4]//a[contains(text(), 'Men')]");
    By filterByWomenCategoryCheckbox = By.xpath("//section[@class='facet clearfix'][4]//a[contains(text(), 'Women')]");
    By filterBySizeSCheckbox = By.xpath("//section[@class='facet clearfix'][5]//a[contains(text(), 'S')]");
    By filterBySizeMCheckbox = By.xpath("//section[@class='facet clearfix'][5]//a[contains(text(), 'M')]");
    By filterBySizeLCheckbox = By.xpath("//section[@class='facet clearfix'][5]//a[contains(text(), 'L')]");
    By filterBySizeXLCheckbox = By.xpath("//section[@class='facet clearfix'][5]//a[contains(text(), 'XL')]");
    By activeFiltersBlockCategoriesMen = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'Men')]");
    By activeFiltersBlockCategoriesWomen = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'Women')]");
    By activeFiltersBlockCategoriesSizeS = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'S')]");
    By activeFiltersBlockCategoriesSizeM = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'M')]");
    By activeFiltersBlockCategoriesSizeL = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'L')]");
    By activeFiltersBlockCategoriesSizeXL = By.xpath("//li[contains(@class, 'filter-block') and contains(text(), 'XL')]");

    public ClothesPage() {
        this.driver = getDriver();
    }

    @Override
    public void navigateToPage() {
        MainPage mainPage = new MainPage();
        mainPage.clickClothesMenuLink();
    }

    public void clickLeftMenuClothesCategory(String category) {
        switch (category) {
            case "Men" -> driver.findElement(leftMenuMenCategory).click();
            case "Women" -> driver.findElement(leftMenuWomenCategory).click();
            default -> throw new IllegalStateException("Unexpected category value: " + category);
        }
    }

    public String categoryClothesPageUrl(String category) {
        return switch (category) {
            case "Men" -> reader.getMenClothesPageUrl();
            case "Women" -> reader.getWomenClothesPageUrl();
            default -> throw new IllegalStateException("Unexpected category value: " + category);
        };
    }

    public void clickFilterByCategoryCheckbox(String category) {
        switch (category) {
            case "Men" -> driver.findElement(filterByMenCategoryCheckbox).click();
            case "Women" -> driver.findElement(filterByWomenCategoryCheckbox).click();
            default -> throw new IllegalStateException("Unexpected category value: " + category);
        }
    }

    public void clickFilterBySizeCheckbox(String size) {
        switch (size) {
            case "S" -> driver.findElement(filterBySizeSCheckbox).click();
            case "M" -> driver.findElement(filterBySizeMCheckbox).click();
            case "L" -> driver.findElement(filterBySizeLCheckbox).click();
            case "XL" -> driver.findElement(filterBySizeXLCheckbox).click();
            default -> throw new IllegalStateException("Unexpected size value: " + size);
        }
    }

    public boolean doesActiveFiltersBlockContainCategory(String category) {
        return switch (category) {
            case "Men" -> driver.findElement(activeFiltersBlockCategoriesMen).isDisplayed();
            case "Women" -> driver.findElement(activeFiltersBlockCategoriesWomen).isDisplayed();
            default -> false;
        };
    }

    public boolean doesActiveFiltersBlockContainSize(String size) {
        return switch (size) {
            case "S" -> driver.findElement(activeFiltersBlockCategoriesSizeS).isDisplayed();
            case "M" -> driver.findElement(activeFiltersBlockCategoriesSizeM).isDisplayed();
            case "L" -> driver.findElement(activeFiltersBlockCategoriesSizeL).isDisplayed();
            case "XL" -> driver.findElement(activeFiltersBlockCategoriesSizeXL).isDisplayed();
            default -> false;
        };
    }
}
