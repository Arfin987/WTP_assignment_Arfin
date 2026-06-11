package Day25;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.NoSuchElementException;

public class flightSearchDemoFluentwait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate directly to a sample flight search results page
        driver.get("https://phptravels.net/flights/del/lon/oneway/economy/24-05-2026/1/0/0");

        // Close demo warning popup if present
        driver.findElement(By.id("acknowledgeDemoWarning")).click();

        // Fluent Wait setup
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))   // max wait time
                .pollingEvery(Duration.ofSeconds(2))   // check every 2 seconds
                .ignoring(NoSuchElementException.class);

        // Wait until the flight list table (inside <main>) is visible
        WebElement flightList = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//main"))
        );

        System.out.println("✅ Flight Search Results Loaded Successfully");
        System.out.println("✅ Flight List Displayed: " + flightList.isDisplayed());

        driver.quit();
    }
}
