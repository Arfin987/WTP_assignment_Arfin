package day24;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class sel {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Text field
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Md Copilot");
        System.out.println("✅ Text field filled successfully.");

        // 2. Buttons
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        System.out.println("✅ Button clicked successfully.");

        // 3. Radio buttons
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.id("yesRadio")).click();
        System.out.println("✅ Radio button selected successfully.");

        // 4. List box (multi-select)
        driver.get("https://demoqa.com/select-menu");
        Select listBox = new Select(driver.findElement(By.id("cars")));
        listBox.selectByVisibleText("Volvo");
        listBox.selectByVisibleText("Audi");
        System.out.println("✅ List box options selected successfully.");

        // 5. Dropdown
        Select dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
        dropdown.selectByIndex(3);
        System.out.println("✅ Dropdown option selected successfully.");

        // 6. Image handling
        driver.get("https://demoqa.com");
        WebElement img = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        System.out.println("✅ Image displayed? " + img.isDisplayed());

        // 7. Check boxes
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        System.out.println("✅ Checkbox clicked successfully.");

        // 8. Scroll page
        driver.get("https://demoqa.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("✅ Page scrolled successfully.");

        // 9. Screenshot (using Java NIO)
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), new File("page.png").toPath());
        System.out.println("✅ Screenshot captured successfully.");

        // 10. Actions class
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        System.out.println("✅ Double click performed successfully.");

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        System.out.println("✅ Right click performed successfully.");

        WebElement hoverElement = driver.findElement(By.id("submit"));
        actions.moveToElement(hoverElement).perform();
        System.out.println("✅ Mouse hover performed successfully.");

        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();
        System.out.println("✅ Drag and drop performed successfully.");

        // 11. Alerts
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("✅ Simple alert handled successfully.");

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        System.out.println("✅ Confirmation alert handled successfully.");

        driver.findElement(By.id("promtButton")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Copilot");
        prompt.accept();
        System.out.println("✅ Prompt alert handled successfully.");

        driver.quit();
        System.out.println("🎉 All Selenium tasks completed successfully!");
    }
}
