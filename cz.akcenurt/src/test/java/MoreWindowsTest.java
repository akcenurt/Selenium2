import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoreWindowsTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/inception.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get((BASE_URL));
        driver.manage().window().maximize();
    }

    @Test
    public void openSwitchWindowsTest(){

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.id("letsGoDeeper")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        driver.findElement(By.id("message")).sendKeys("ahoj!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();

        driver.switchTo().window(parentWindow);

        driver.findElement(By.id("letsGoDeeper")).click();



    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
