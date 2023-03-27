package tests;

import driver.DriverSetup;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {
    @Test
    void shouldLogInSuccessfully() {
        // preconditions
        var url = "https://www.saucedemo.com/";
        var username = "standard_user";
        var password = "secret_sauce";


        // Steps

        // initialize browser (Chrome here)
        WebDriver driver = DriverSetup.getDriver();
        // Login to site
        driver.get(url);
        // find elements and enter user/pass into login form
        WebElement usernameElement = driver.findElement(By.id("user-name"));
        usernameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // validate that user is successfully logged in
        WebElement shoppingCartLink = driver.findElement(By.id("shopping_cart_container"));
        assertThat(shoppingCartLink.isDisplayed()).isTrue();

        // close the driver
        driver.quit();
    }
}

