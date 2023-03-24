package scatterplot;

import histogram.HistogramPage;
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

public class ScatterplotTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static SummaryPage summaryPage;
    public static ScatterplotPage scatterplotPage;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(String.format(summaryPage.NAME_BUTTON_PATTERN, "Scatter-plot"))).click();
        scatterplotPage = new ScatterplotPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMenuXAttribute() {
        scatterplotPage.clickXAttribute();
        boolean actual = scatterplotPage.menuIsDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testMenuYAttribute() {
        scatterplotPage.clickYAttribute();
        boolean actual = scatterplotPage.menuIsDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testMenuIntervals() {
        scatterplotPage.clickIntervals();
        boolean actual = scatterplotPage.menuIsDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testXAttribute() {
        scatterplotPage.clickXAttribute();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        scatterplotPage.clickXAttributeElement();
        boolean actual = driver.findElement(By.xpath("//input[@class='autocomplete-input ng-pristine ng-valid ng-touched' and @title='Size']")).isDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testYAttribute() {
        scatterplotPage.clickYAttribute();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        scatterplotPage.clickYAttributeElement();
        boolean actual = driver.findElement(By.xpath("//input[@class='autocomplete-input ng-pristine ng-valid ng-touched' and @title='Shortfall']")).isDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void testIntervals() {
        scatterplotPage.clickIntervals();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        scatterplotPage.clickIntervalsElement();
        boolean actual = driver.findElement(By.xpath("//input[@class='autocomplete-input ng-pristine ng-valid ng-touched' and @title='25']")).isDisplayed();
        Assert.assertTrue(actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
