package day27;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class CrossBrowser {
    WebDriver driver;

    @Parameters({"browser","url","username","password"})
    @Test
    public void login(String browser, String url, String username, String password) throws Exception {
        // Connect to Selenium Grid Hub
        URL hubURL = new URL("http://localhost:4444/wd/hub");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);

        // Launch browser on Grid Node
        driver = new RemoteWebDriver(hubURL, caps);

        // Use parameters
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.quit();
    }
}
