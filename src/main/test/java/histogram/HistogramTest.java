package histogram;

import grid.GridPage;
import login.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import summary.SummaryPage;

import java.util.concurrent.TimeUnit;

public class HistogramTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static SummaryPage summaryPage;
    public static HistogramPage histogramPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://app.tca.deltixuat.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.inputLogin("selenium_chrome");
        loginPage.inputPasswd("Axa@Demo");
        loginPage.clickLoginBtn();
        summaryPage = new SummaryPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Histogram"))).click();
        histogramPage = new HistogramPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMenuAttribute() {
        histogramPage.clickAttribute();
        boolean actual = histogramPage.menuIsDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testMenuInterval() {
        histogramPage.clickInterval();
        boolean actual = histogramPage.menuIsDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testAttribute() {
        histogramPage.clickAttribute();
        histogramPage.clickElementAttribute();
        String actual = histogramPage.textAttribute();
        Assert.assertEquals("Size", actual);
    }

    @Test
    public void testInterval() {
        histogramPage.clickInterval();
        histogramPage.clickElementInterval();
        String actual = histogramPage.textInterval();
        Assert.assertEquals("25", actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
