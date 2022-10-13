import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitTest2 {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void waitForNumberOfElements(){
        driver.get(BASE_URL + "minions.php");
        int numberOfElements = 10;
        driver.findElement(By.xpath("//input[@type='number']"))
                .sendKeys(String.valueOf(numberOfElements));
        driver.findElement(By.xpath("//button[contains(@class, btn-warning)]"))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .withMessage("Waiting for number of elements to be " + numberOfElements)
                .until(ExpectedConditions.numberOfElementsToBe
                        (By.xpath("//div[@class='minions']//img"), numberOfElements));
//        System.out.println(driver.findElements(By.xpath("//div[@class='minions']//img")).size());
        Assert.assertEquals
                (numberOfElements, driver.findElements(By.xpath("//div[@class='minions']//img")).size());
    }

    @Test
    public void waitForINvisibility(){
        driver.get(BASE_URL + "prestige.php");
        driver.findElement(By.xpath("//img[@src='assets/img/hat.png']"))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath("//img[@src='assets/img/hat.png']")));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//img[@src='assets/img/hat.png']")));


    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
