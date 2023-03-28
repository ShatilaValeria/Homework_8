package tests;

import page.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GridPage;
import page.SummaryPage;

import java.util.concurrent.TimeUnit;

public class GridTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static SummaryPage summaryPage;
    public static GridPage gridPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://app.tca.deltixuat.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.inputLogin("selenium_chrome");
        loginPage.inputPasswd("Axa@Demo");
        loginPage.clickLoginBtn();
        summaryPage = new SummaryPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Grid & chart"))).click();
        gridPage = new GridPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPlusLines() {
        gridPage.clickElement();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        gridPage.clickIconLines();
        boolean actual = gridPage.menuIsDisplayed();
        Assert.assertTrue(actual);
    }


    @Test
    public void testOrderAnalyticsParameters() {
        driver.findElement(By.xpath(String.format(gridPage.NAME_ICON_PATTERN, "Order analytics dashboard"))).click();
        boolean actualFirst = driver.findElement(By.xpath(String.format(gridPage.NAME_TABLE_PATTERN, "Id"))).isDisplayed();
        boolean actualSecond = driver.findElement(By.xpath(String.format(gridPage.NAME_TABLE_PATTERN, "Side"))).isDisplayed();
        boolean actualThird = driver.findElement(By.xpath(String.format(gridPage.NAME_TABLE_PATTERN, "Exec size"))).isDisplayed();

        Assert.assertTrue(actualFirst);
        Assert.assertTrue(actualSecond);
        Assert.assertTrue(actualThird);
    }

    @Test
    public void testOrderParameters() {
        driver.findElement(By.xpath(String.format(gridPage.NAME_ICON_PATTERN, "Order parameters"))).click();
        boolean actual = gridPage.massageIsDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testExecutionReports() {
        driver.findElement(By.xpath(String.format(gridPage.NAME_ICON_PATTERN, "Execution reports"))).click();
        boolean actual = driver.findElement(By.xpath("//div[@class='modal-body']")).isDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testPDFReport() {
        driver.findElement(By.xpath(String.format(gridPage.NAME_ICON_PATTERN, "PDF report"))).click();
        boolean actual = driver.findElement(By.xpath("//div[@class='modal-body']")).isDisplayed();
        Assert.assertTrue(actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
