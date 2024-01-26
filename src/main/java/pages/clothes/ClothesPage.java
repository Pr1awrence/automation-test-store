package pages.clothes;

import core.BasePage;
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
    By leftMenuFilterByMenCategoryCheckbox = By.xpath("//section[@class='facet clearfix']//a[contains(text(), 'Men')]");
    By leftMenuFilterByWomenCategoryCheckbox = By.xpath("//section[@class='facet clearfix']//a[contains(text(), 'Women')]");

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

    private WebElement getLeftMenuFilterSection(int index) {
        return getLeftMenuFilterSections().get(index);
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
}
