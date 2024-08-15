import jdk.jshell.execution.Util;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;
    @BeforeAll
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30  ));
    }
    @Test
    public void submitForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        Thread.sleep(2000);
        driver.findElement(By.id("edit-name")).sendKeys("John");
        Thread.sleep(1000);
        driver.findElement(By.id("edit-number")).sendKeys("01234567895");
        Thread.sleep(1000);

        driver.findElement(By.id("edit-date")).sendKeys("2024-08-15");
        Thread.sleep(1000);

        //Utils.scroll(driver);

        driver.findElement(By.id("edit-email")).sendKeys("john@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("I am a tester");
        Thread.sleep(1000);
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys("C:\\Users\\Rimjhim\\OneDrive\\Desktop\\cv-template-0021.jpg");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("edit-submit")).click();
        Thread.sleep(2000);

        WebElement messageActual = driver.findElement((By.tagName("h1")));
        String messageExpected = "Thank you for your submission!";
        Assertions.assertTrue(messageActual.getText().contains(messageExpected));

//        driver.findElement(By.cssSelector("a[href='/practice-webform-learners']")).click();
//        Thread.sleep(2000);
    }

@AfterAll
    public void closure() {

        driver.quit();
    }
}
