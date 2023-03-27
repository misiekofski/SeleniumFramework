package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverSetup {
    public static final String DEFAULT_BROWSER = "Chrome";

    public static WebDriver getDriver() {
        Properties properties = getProperties();

        if (properties.getProperty("browser").equals("Firefox")) {
            return new FirefoxDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(options);
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        String confFile = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
        try {
            properties.load(new FileInputStream(confFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}
