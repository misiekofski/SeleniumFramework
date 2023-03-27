package driver;

import org.openqa.selenium.Dimension;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfig {
    Properties properties = new Properties();
    private String browserName;
    private String width;
    private String height;

    public BrowserConfig() {
        String confFile = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
        try {
            properties.load(new FileInputStream(confFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.browserName = properties.getProperty("browser");
        this.height = properties.getProperty("height");
        this.width = properties.getProperty("width");
    }

    public String getBrowserName() {
        if (browserName == null || browserName.isEmpty()) {
            return "chrome";
        } else {
            return browserName.toLowerCase();
        }

    }

    public Dimension getBrowserSize() {
        return new Dimension(Integer.parseInt(width), Integer.parseInt(height));
    }
}
