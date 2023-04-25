import Pages.HomePage;
import Pages.ShopPage;
import Pages.SignInPage;
import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");

        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        ShopPage shopPage = new ShopPage();

        homePage.clickSignIn();
        signInPage.logIn("testjohndaw@gmail.com", "test132");

        if (homePage.getUsername().equals("Hello, John"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
        homePage.clickShopButton();
        shopPage.addElementToCart();

        DriverSingleton.closeObjectInstance();

    }
}