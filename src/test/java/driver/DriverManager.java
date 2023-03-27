package driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (drivers.get() != null) {
            try{
                drivers.get().quit();
                drivers.remove();
            } catch (Exception e) {
                // log error
            }
        }
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return drivers.get();
    }
}
