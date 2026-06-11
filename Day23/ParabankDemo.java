package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParabankDemo {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");	
		
	}
	
	@Test(priority=1)
	public void registrationDemo() {
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("customer.firstName")).sendKeys("Aditya");
        driver.findElement(By.id("customer.lastName")).sendKeys("Raj");
        driver.findElement(By.id("customer.address.street")).sendKeys("Street-123");
        driver.findElement(By.id("customer.address.city")).sendKeys("Patna");
        driver.findElement(By.id("customer.address.state")).sendKeys("Bihar");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("111-22-3333");
        
        driver.findElement(By.id("customer.username")).sendKeys("Adity");
        driver.findElement(By.id("customer.password")).sendKeys("Password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password123");
        
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        
        //driver.findElement(By.linkText("Log Out")).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(), 'Your account was created successfully')]")
        ));
        
        Assert.assertTrue(successMessage.isDisplayed(), "Registration success message not displayed.");
        
             
	}
	
	
	@Test(priority = 2)
    public void validLoginTest() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
       
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Aditya");

   
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password123");

      
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

       
        String welcomeText = driver.findElement(By.cssSelector("h1.title")).getText();
        Assert.assertTrue(welcomeText.contains("Accounts Overview"), "Login failed!");
    }
	
	
	  @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }

}
