package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @Parameters({"browser","url","username","password"})
    @Test
    public void login(String browser, String url, String username, String password) {
        // Launch browser based on parameter
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        // Use parameters
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        driver.quit();
    }
}
