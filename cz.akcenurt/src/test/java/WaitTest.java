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


public class WaitTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "waitforit.php");
        driver.manage().window().maximize();
    }

    @Test
    public void waitForInputAttributeTest(){
        driver.findElement(By.id("startWaitForText"))
                .click();
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.attributeToBe((By.id("waitForTextInput")),"value","dary !!!"));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains((By.id("waitForTextInput")),"value","dary !!!"));
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));

    }

    @Test
    public void waitForPropertyTest(){
        driver.findElement(By.id("startWaitForProperty"))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains((By.id("waitForProperty")),"class","error"));
        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());

    }

    @Test
    public void waitForPropertyTest2(){
        driver.findElement(By.id("startWaitForProperty"))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeContains((By.id("startWaitForProperty")),"disabled","true"));
        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
