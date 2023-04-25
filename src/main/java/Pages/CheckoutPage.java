package Pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;
    @FindBy(id = "select2-billing_country-container")
    private WebElement country;
    @FindBy(id = "billing_address_1")
    private WebElement streetHouse;
    @FindBy(id = "billing_address_2")
    private WebElement apartment;
    @FindBy(css = "#billing_postcode")
    private WebElement postcode;
    @FindBy(css = "#billing_city")
    private WebElement city;
    @FindBy(id = "billing_email")
    private WebElement emailAddress;
    @FindBy(id = "mailpoet_woocommerce_checkout_optin")
    private WebElement offerCheckBox;
    @FindBy(id = "place_order")
    private WebElement placeOrderButton;
    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span > bdi")
    private WebElement totalAmount;
    @FindBy(css = "#post-207 > header > h1")
    private WebElement orderStatus;

    public void provideBillingDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(streetHouse));
        streetHouse.sendKeys("abc");
        postcode.sendKeys("1111");
        city.sendKeys("Downtown");
        System.out.println("The provideBillingDetails was executed successfully");

    }

public String getTotalAmount() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
    wait.until(ExpectedConditions.visibilityOf(totalAmount));
    System.out.println("The getTotalAmount was executed successfully. Total Amount is " + totalAmount.getText());
    return totalAmount.getText();

}

public void placeOrder() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
    wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
    placeOrderButton.click();
    System.out.println("The placeOrder was executed successfully");
}
}