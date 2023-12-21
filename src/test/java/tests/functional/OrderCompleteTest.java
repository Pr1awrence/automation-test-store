package tests.functional;

import core.Hooks;
import listeners.TestFailureScreenshotListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.order.OrderFormDelivery;
import pages.order.OrderFormPayment;
import pages.order.OrderFormPersonalInfo;
import pages.order.OrderFormShippingMethod;
import pages.shop.ShopContentModal;
import pages.home.HomePage;
import pages.shop.ShopProductPage;
import pages.shop.ShoppingCart;

@Listeners(TestFailureScreenshotListener.class)

public class OrderCompleteTest extends Hooks {
    @Test
    /* напиши тест кейс */
    public void orderCompleteTest() {
        // Choose first product from the popular products section
        HomePage homePage = new HomePage();
        homePage.clickFirstProduct();

        // Change size, quantity and add product to the cart
        ShopProductPage shopProductPage = new ShopProductPage();
        shopProductPage.chooseMediumSize();
        shopProductPage.clickQuantityIncrease();
        shopProductPage.clickAddToCartBtn();

        // Modal pops up, where click on the checkout button
        ShopContentModal contentModal = new ShopContentModal();
        contentModal.clickCheckoutBtn();

        // Applying a promo code and proceed to checkout
        ShoppingCart cart = new ShoppingCart();
        cart.applyPromoCode();

        cart.clickProceedCheckoutBtn();

        // Filling in the user data and accept Terms and Conditions
        OrderFormPersonalInfo personalInfo = new OrderFormPersonalInfo();
        personalInfo.chooseGenderMr();
        personalInfo.enterFirstName();
        personalInfo.enterLastName();
        personalInfo.enterEmail();
        personalInfo.agreeTermsAndConditions();
        personalInfo.clickContinueBtn();

        // Filling in the user delivery data
        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.enterAddress();
        orderDelivery.enterCity();
        orderDelivery.chooseStateTexas();
        orderDelivery.enterPostalCode();
        orderDelivery.clickContinueBtn();

        // Filling in the shipping method
        OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
        shipMethod.enterDeliveryMessage();
        shipMethod.clickContinueBtn();

        // Filling in the payment information
        OrderFormPayment orderPayment = new OrderFormPayment();
        orderPayment.clickPayByCheck();
        orderPayment.acceptTermsAndConditions();
        orderPayment.clickOrder();
    }
}
