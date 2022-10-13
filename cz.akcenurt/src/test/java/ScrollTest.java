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

public class ScrollTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testScrollTo(){

        driver.get(BASE_URL + "tabulka.php");
        WebElement lastRow = driver.findElement(By.xpath("//table//tbody//tr[last()]"));
                // např. druhý řádek xpath: //table//tbody//tr[2]]
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true)", lastRow); // to true se vztahuje k align to top parametru, tedy naskroluje tak, aby byl řádek nahoře





    }



    @After
    public void tearDown(){
//        driver.close();
//        driver.quit();

    }

}
