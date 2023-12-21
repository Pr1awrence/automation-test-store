package tests.functional;

import core.Hooks;
import core.WebDriverInstance;
import listeners.TestFailureScreenshotListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.shop.ShopContentModal;
import pages.home.HomePage;
import pages.shop.ShopProductPage;
import pages.shop.ShoppingCart;

import java.time.Duration;

@Listeners(TestFailureScreenshotListener.class)

public class RemoveItemBasketTest extends Hooks {
    @Test
    /* напиши тест кейс */
    public void removeItemTest() {
        // Choose first product from the popular products section
        HomePage shopHome = new HomePage();
        shopHome.clickFirstProduct();

        // Change size, quantity and add product to the cart
        ShopProductPage shopProductPage = new ShopProductPage();
        shopProductPage.chooseMediumSize();
        shopProductPage.clickQuantityIncrease();
        shopProductPage.clickAddToCartBtn();

        // Modal pops up, where click on the checkout button
        ShopContentModal contentModal = new ShopContentModal();
        contentModal.clickContinueShoppingBtn();

        // Go to home page and select the second product
        shopProductPage.clickHomepageLink();
        shopHome.clickSecondProduct();
        shopProductPage.clickAddToCartBtn();
        contentModal.clickCheckoutBtn();

        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        WebDriverWait wait = new WebDriverWait(WebDriverInstance.getDriverInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

        Assert.assertEquals(cart.getTotalAmount().getText(), "$45.23");
        //Assert.assertEquals(cart.getTotalAmount().getText(), "$45.24"); // correct result
    }
}
