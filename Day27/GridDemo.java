package day27;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class GridDemo {
    WebDriver driver;

    @Parameters("browser")
    @Test
    public void loginSauceDemo(String browser) throws Exception {
        // Connect to Selenium Grid Hub
        URL hubURL = new URL("http://localhost:4444/wd/hub");

        // Set browser capability
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);

        // Create Remote WebDriver
        driver = new RemoteWebDriver(hubURL, caps);

        // Navigate to SauceDemo
        driver.get("https://www.saucedemo.com");

        // Perform login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Validate login success
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Swag Labs"), "Login failed!");

        driver.quit();
    }
}

