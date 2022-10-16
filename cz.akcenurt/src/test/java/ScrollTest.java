import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;

public class ScrollTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testScrollTo(){

        WebElement lastRow = driver.findElement(By.xpath("//table//tbody//tr[last()]"));
                // např. druhý řádek xpath: //table//tbody//tr[2]]
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true)", lastRow); // to true se vztahuje k align to top parametru, tedy naskroluje tak, aby byl řádek nahoře

    }

    @Test
    public void scrollByXPixelsTest(){

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,200)");
        }

    }

    @Test
    public void scrollToTheUnknownEnd(){

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
//        System.out.println(scrollHeight);
        js.executeScript("window.scrollBy(0," + bodyHeight + ")");

    }
    @Test
    public void scrollByOnePixel(){

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        for (int i = 0; i < bodyHeight; i++) {
            js.executeScript("window.scrollBy(0,1)");
        }

    }


    @After
    public void tearDown(){
//        driver.close();
//        driver.quit();

    }

}
