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

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#post-206 > content > div > div > div.cart-collaterals > div > div > a")
    private WebElement proceedCheckoutButton;

    @FindBy(css = "#post-206 > content > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-remove > a")
    private WebElement deleteButton;

    @FindBy(css = "#coupon_code")
    private WebElement couponCodeField;

    @FindBy(css = "#post-206 > content > div > div > div.cart-collaterals > div > table > tbody > tr.cart-discount.coupon-udemy-challenge > td > span")
    private WebElement discountMSG;

    @FindBy(css = "#post-206 > content > div > div > div.cart-collaterals > div > table > tbody > tr.cart-discount.coupon-udemy-challenge > td > a")
    private WebElement removeDiscount;

    @FindBy(css = "#post-206 > content > div > div > div.cart-collaterals > div > table > tbody > tr.order-total > td > strong > span > bdi")
    private WebElement totalSum;

    @FindBy(css = "#post-206 > content > div > div > div > p")
    private WebElement cartEmptyMSG;

    @FindBy(css = "#post-206 > content > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-remove > a")
    private WebElement deleteItemFromCartButton;
    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > span")
    private WebElement cartQuantity;

    @FindBy(id = "quantity_64479cd1dde5f")
    private WebElement itemQuantity;

    @FindBy(css = "#post-206 > content > div > div > form > table > tbody > tr:nth-child(3) > td > div > button")

    private WebElement applyCouponButton;


    public void addCoupon() {
        couponCodeField.sendKeys(Constants.COUPON);
        applyCouponButton.click();
        String totalSumText = totalSum.getText();
        System.out.println("Total sum after Coupon is " + totalSumText);
        if (totalSum.getText().equals("0,00 €")) System.out.println("Coupon applied");
        else System.out.println("Coupon was NOT applied");
    }

    public void proceedCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutButton));
        proceedCheckoutButton.click();

    }


}
