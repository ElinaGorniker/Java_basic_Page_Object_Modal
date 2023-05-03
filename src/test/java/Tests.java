
import automation.Pages.*;
import automation.drivers.DriverSingleton;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import automation.utils.Constants;
import automation.utils.FrameworkProperties;
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

   /* @Test
    public void testingAddingThingsToCart() throws InterruptedException {
        driver.get(Constants.URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME),
                homePage.getUsername());
        homePage.dismissCommerceStoreNotice();
        homePage.clickShopButton();
        shopPage.goToSecondPage();
        shopPage.addTestBookToCart();
        shopPage.goToThirdPage();
        assertEquals(Constants.CART_QUANTITY, shopPage.getNumberOfProduct());

    }

    @Test
    public void testingTheFullBuyingProcess()  {
        driver.get(Constants.URL);
        homePage.clickShopButton();

        homePage.dismissCommerceStoreNotice();

        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME),
                homePage.getUsername());
        homePage.dismissCommerceStoreNotice();
        shopPage.addElementToCart();
        shopPage.goToSecondPage();
        shopPage.goToCart();
        cartPage.addCoupon();
        cartPage.proceedCheckout();
        checkoutPage.provideBillingDetails();
        checkoutPage.placeOrder();
        assertEquals("Order received", checkoutPage.getOrderStatus());


    }
*/
    @AfterAll
    public static void closeObjects() {
        driver.close();
    }


}
