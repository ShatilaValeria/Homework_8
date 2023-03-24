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

public class ButtonTest {
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
    public void testGridAndChat() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Grid & chart"))).isDisplayed();
        boolean actualIsEnabled = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Grid & chart"))).isEnabled();
        Assert.assertTrue(actualIsDisplay);
        Assert.assertTrue(actualIsEnabled);
    }

    @Test
    public void testHistogram() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Histogram"))).isDisplayed();
        boolean actualIsEnabled = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Histogram"))).isEnabled();
        Assert.assertTrue(actualIsDisplay);
        Assert.assertTrue(actualIsEnabled);
    }

    @Test
    public void testScatterPlot() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Scatter-plot"))).isDisplayed();
        boolean actualIsEnabled = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Scatter-plot"))).isEnabled();
        Assert.assertTrue(actualIsDisplay);
        Assert.assertTrue(actualIsEnabled);
    }

    @Test
    public void testReports() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Reports"))).isDisplayed();
        boolean actualIsEnabled = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Reports"))).isEnabled();
        Assert.assertTrue(actualIsDisplay);
        Assert.assertTrue(actualIsEnabled);
    }

    @Test
    public void testSummary() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Summary"))).isDisplayed();
        boolean actualIsEnabled = driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Summary"))).isEnabled();
        Assert.assertTrue(actualIsDisplay);
        Assert.assertTrue(actualIsEnabled);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
