package pages.clothes;

import org.openqa.selenium.JavascriptExecutor;
import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/* Page link: http://teststore.automationtesting.co.uk/3-clothes */
public class ClothesPage extends BasePage {
    public WebDriver driver;

    By leftMenuClothesMenCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Men']");
    By leftMenuClothesWomenCategory = By.xpath("//ul[@class='category-sub-menu']//a[text()='Women']");
    By leftMenuFilterSections = By.cssSelector("section[class='facet clearfix']");
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


    public ClothesPage() {
        this.driver = getDriver();
    }

    public void clickLeftMenuClothesMenCategory() {
        driver.findElement(leftMenuClothesMenCategory).click();
    }

    public void clickLeftMenuClothesWomenCategory() {
        driver.findElement(leftMenuClothesWomenCategory).click();
    }

    private List<WebElement> getLeftMenuFilterSections() {
        return driver.findElements(leftMenuFilterSections);
    }

    public boolean leftMenuSearchFiltersAreDisplayed() {
        return !getLeftMenuFilterSections().isEmpty();
    }

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
