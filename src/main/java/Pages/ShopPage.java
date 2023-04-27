package Pages;

import drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;

    public ShopPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //@FindBy(css = "#main > ul > li.product.type-product.post-451.status-publish.instock.product_cat-ebook.has-post-thumbnail.downloadable.virtual.purchasable.product-type-simple > a.button.wp-element-button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    @FindBy(css = "#main > ul > li:nth-child(3) >a.button")
    private WebElement addToCardButton;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a")
    private WebElement cartButton;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > span")
    private WebElement numberOfProducts;

    @FindBy(css = "#main > ul > li.product.type-product.post-840.status-publish.instock.product_cat-tech-course.product_tag-chatgpt.product_tag-course.product_tag-mobile-app-development.product_tag-nodejs.product_tag-react-native.has-post-thumbnail.sale.downloadable.virtual.purchasable.product-type-simple > a.button.wp-element-button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    private WebElement addToCartButtonForTestBook0;
    @FindBy(css = "#main > nav > ul > li:nth-child(2) > a")
    private WebElement secondPage;

    @FindBy(css = "#main > nav > ul > li:nth-child(4) > a")
    private WebElement thirdPage;


    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }

    public void goToSecondPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(secondPage));
        secondPage.click();
        System.out.println("The second page opens");
    }

    public void goToThirdPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(thirdPage));
        thirdPage.click();
        System.out.println("The third page opens");
    }

    public void addElementToCart() {
        addToCardButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(numberOfProducts));

        if (numberOfProducts.getText().contains(Constants.CART_QUANTITY))
            System.out.println("Cart has been updated");
        else {
            System.out.println("Cart has not been updated");
        }
    }

    public void addTestBookToCart() throws InterruptedException {

        addToCartButtonForTestBook0.click();
        System.out.println("The book was added to cart");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(numberOfProducts));

        if (numberOfProducts.getText().contains(Constants.CART_QUANTITY))
            System.out.println("Cart has been updated");
        else {
            System.out.println("Cart has not been updated");
        }

    }

    public String getNumberOfProduct() {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        //wait.until(ExpectedConditions.elementToBeClickable(numberOfProducts));
        return numberOfProducts.getText();
    }
}









