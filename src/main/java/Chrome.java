import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomatiomExtensions", false);
        options.addArguments("--no-sandbox");

        return new ChromeDriver(options);
    }
}
