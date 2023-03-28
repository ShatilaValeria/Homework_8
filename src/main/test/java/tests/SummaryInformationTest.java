package tests;

import page.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SummaryPage;

import java.util.concurrent.TimeUnit;

public class SummaryInformationTest {
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
    public void testDataInterval() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.INFORNATION_PATTERN, "Data interval"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testTotalOrders() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.INFORNATION_PATTERN, "Total orders"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testTotalWinningOrders() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.INFORNATION_PATTERN, "Total winning orders"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @Test
    public void testTotalLosingOrders() {
        boolean actualIsDisplay = driver.findElement(By.xpath(String.format(summaryPage.INFORNATION_PATTERN, "Total losing orders"))).isDisplayed();
        Assert.assertTrue(actualIsDisplay);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
