package Pages;

import drivers.DriverSingleton;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#menu-item-747 > a")
    private WebElement signInButton;

    @FindBy(css = "#menu-item-752 > a")
    private WebElement shopButton;

    @FindBy(css = "#menu-item-750 > a")
    private WebElement username;

    @FindBy(css = "body > p > a.woocommerce-store-notice__dismiss-link")
    private WebElement commerceStoreNoticeDismiss;

    public void clickSignIn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(signInButton));
            commerceStoreNoticeDismiss.click();
            signInButton.click();
            System.out.println("Commerce note is dismissed");
        } catch (NoSuchElementException e) {
            System.out.println("There is No commerce note");

        }
    }

    public void clickShopButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(shopButton));
        shopButton.click();
    }

    public String getUsername() {
        return username.getText();
    }

}


