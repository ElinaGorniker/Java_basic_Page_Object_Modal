import Pages.*;
import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.FrameworkProperties;

import static org.junit.Assert.assertEquals;

public class Tests {


    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;
    static ShopPage shopPage;
    static CartPage cartPage;


    @BeforeClass
    public static void initializeObjects() {
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
        shopPage = new ShopPage();
        cartPage = new CartPage();
    }


    @Test
    public void testingAuthentication() {
        driver.get(Constants.URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME),
                homePage.getUsername());
    }

    @Test
    public void testingAddingThingsToCart() throws InterruptedException {
        driver.get(Constants.URL);
        homePage.dismissCommerceStoreNotice();
        homePage.clickShopButton();
        shopPage.goToSecondPage();
        shopPage.addTestBookToCart();
        shopPage.goToThirdPage();
        assertEquals(Constants.CART_QUANTITY, shopPage.getNumberOfProduct());

    }

    @Test
    public void testingTheFullBuyingProcess() throws InterruptedException {
        driver.get(Constants.URL);
        homePage.clickShopButton();
        shopPage.addElementToCart();
        shopPage.goToSecondPage();
        shopPage.addTestBookToCart();
        shopPage.goToCart();
        cartPage.addCoupon();
        cartPage.proceedCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.placeOrder();
        assertEquals("Order received", checkoutPage.getOrderStatus());


    }

    @AfterClass
    public static void closeObjects() {
        driver.close();
    }


}


/*
    DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
    WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();
    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

        homePage.dismissCommerceStoreNotice();
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty("email"),frameworkProperties.getProperty("password"));

        if(homePage.getUsername().

    equals(frameworkProperties.getProperty(Constants.USERNAME)))
            System.out.println("Test signIn passed");
        else
                System.out.println("Test signIn failed");
       /* homePage.clickShopButton();
        shopPage.goToSecondPage();
        shopPage.addTestBookToCart();
        shopPage.goToCart();
        cartPage.proceedCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.getTotalAmount();
        checkoutPage.placeOrder();
        checkoutPage.getOrderStatus();*/
/*
        DriverSingleton.closeObjectInstance();
}
*/