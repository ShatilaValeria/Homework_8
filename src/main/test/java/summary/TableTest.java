package summary;

import login.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TableTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static SummaryPage summaryPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://app.tca.deltixuat.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.inputLogin("selenium_chrome");
        loginPage.inputPasswd("Axa@Demo");
        loginPage.clickLoginBtn();
        summaryPage = new SummaryPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAlgoPerformance() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Algo Performance"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testOrdersByInstrument() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Orders by instrument / algo (top 10)"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testPriceImprovementByInstrument() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Price improvement by instrument / algo (top 10)"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testPriceImprovementByCurrency() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Price improvement by currency"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testOrdersByAlgo() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Orders by algo"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testOrdersByInstrument10() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Orders by instrument (top 10)"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testAlgoPerformanceTimeline() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Algo performance timeline (by 6 hours)"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testOrdersByAlgoTimeline() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_TABLE_PATTERN, "Orders by algo timeline (by 6 hours)"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
