package day23;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankDemo {

    private WebDriver driver;
    private WebDriverWait wait;
    
    // Dynamic credentials shared between registration and login tests
    private String uniqueUsername;
    private final String password = "Password123!";

    @BeforeClass
    public void setUp() {
        // WebDriverManager is native to Selenium 4+, no need for System.setProperty
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Generate a unique username based on current time millis
        uniqueUsername = "User_" + System.currentTimeMillis();
    }

    @Test(priority = 1)
    public void testUserRegistration() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        // Fill out personal details
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Doe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Austin");
        driver.findElement(By.id("customer.address.state")).sendKeys("Texas");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("78701");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("5125551234");
        driver.findElement(By.id("customer.ssn")).sendKeys("999-99-9999");

        // Fill out sign-up account credentials
        driver.findElement(By.id("customer.username")).sendKeys(uniqueUsername);
        driver.findElement(By.id("customer.password")).sendKeys(password);
        driver.findElement(By.id("repeatedPassword")).sendKeys(password);

        // Click Register button
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        // Verify successful registration message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(), 'Your account was created successfully')]")
        ));
        
        Assert.assertTrue(successMessage.isDisplayed(), "Registration success message not displayed.");
        
        // Log out to prepare for the login test
        driver.findElement(By.linkText("Log Out")).click();
    }

    @Test(priority = 2, dependsOnMethods = {"testUserRegistration"})
    public void testUserLogin() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Input credentials into the login module
        driver.findElement(By.name("username")).sendKeys(uniqueUsername);
        driver.findElement(By.name("password")).sendKeys(password);
        
        // Click Log In button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // Verify landing on the Account Overview dashboard
        WebElement accountOverviewHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("title")
        ));

        Assert.assertEquals(accountOverviewHeader.getText(), "Accounts Overview", "Login verification failed.");
        
        // Additional validation: Ensure the welcome banner displays the text matching the registered user
        WebElement welcomeText = driver.findElement(By.className("smallText"));
        Assert.assertTrue(welcomeText.getText().contains("Welcome John Doe"), "Welcome message name match failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}