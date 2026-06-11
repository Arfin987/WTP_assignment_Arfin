package Day25;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class flighSearchDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://blazedemo.com/");

        driver.findElement(By.name("fromPort")).sendKeys("Mumbai");
        driver.findElement(By.name("toPort")).sendKeys("London");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))   
                .pollingEvery(Duration.ofSeconds(2))   
                .ignoring(NoSuchElementException.class);

        WebElement result = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement table = driver.findElement(By.cssSelector("table.table"));
                if (table.isDisplayed()) {
                    return table;
                } else {
                    return null;
                }
            }
        });

        System.out.println("Flight results table is now visible!");

        driver.quit();
    }
}
