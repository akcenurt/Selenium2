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

public class JavascriptExecutorTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHighlightJSE(){

        driver.get(BASE_URL + "tabulka.php");

        List <WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr")); //!!findElementSSS!!

        for (WebElement row : rows) {
            if (row.getText().contains("Alfonz")) {
                highlight(row);
            }

            System.out.println(row.getText());
        }


    }

    @Test
    public void blurTestJSE(){

        driver.get(BASE_URL + "waitforit.php");
        driver.findElement(By.id("waitForBlur")).sendKeys("bla bla bla");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].blur()", driver.findElement(By.id("waitForBlur")));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeToBe
                        (driver.findElement(By.id("waitForBlur")),"value", "blured!"));
        Assert.assertTrue(driver.findElement(By.id("waitForBlur")).getAttribute("value").contains("blured!"));

    }

    @Test
    public void clickResponseTestJSE(){

        driver.get(BASE_URL + "waitforit.php");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()", driver.findElement(By.id("startWaitForText")));
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p//span")));
//        System.out.println(driver.findElement(By.xpath("//div//p//span"))
//                .getAttribute("innerText"));
        int response = Integer.parseInt(driver.findElement(By.xpath("//div//p//span"))
                .getAttribute("innerText"));
//        System.out.println(response);
        Assert.assertTrue(response < 3000);

    }


    @After
    public void tearDown(){
//        driver.close();
//        driver.quit();

    }

    private void highlight(WebElement row) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", row);
    }

}
