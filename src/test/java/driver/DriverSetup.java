package driver;

import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    private static BrowserConfig config = new BrowserConfig();

    public static WebDriver getDriver() {
        switch (config.getBrowserName()) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriver driver = new ChromeDriver(options);
                driver.manage().window().setSize(config.getBrowserSize());
                return driver;
            }
            case "firefox" -> {
                return new FirefoxDriver();
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriver driver = new ChromeDriver(options);
                driver.manage().window().setSize(config.getBrowserSize());
                return driver;
            }
        }
    }
}
