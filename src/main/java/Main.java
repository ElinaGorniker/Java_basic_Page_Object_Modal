import Pages.*;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) throws Exception {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
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
        signInPage.logIn(frameworkProperties.getProperty("email"),  frameworkProperties.getProperty("password"));

        if (homePage.getUsername().equals("Hello, John"))
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

        DriverSingleton.closeObjectInstance();

    }
}