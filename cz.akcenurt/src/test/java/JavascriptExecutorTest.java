import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavascriptExecutorTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/";

    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL + "tabulka.php");
        driver.manage().window().maximize();
    }

    @Test
    public void testHighlight(){

        List <WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr")); //!!findElementSSS!!

        for (WebElement row : rows) {
            if (row.getText().contains("Alfonz")) {
                highlight(row);
            }

            System.out.println(row.getText());
        }


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
