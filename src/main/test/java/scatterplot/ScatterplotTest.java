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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        scatterplotPage.clickXAttributeElement();
        String actual = scatterplotPage.textXAttribute();
        Assert.assertEquals("Size", actual);
    }

    @Test
    public void testYAttribute() {
        scatterplotPage.clickYAttribute();
        scatterplotPage.clickYAttributeElement();
        String actual = scatterplotPage.textYAttribute();
        Assert.assertEquals("Shortfall", actual);
    }

    @Test
    public void testIntervals() {
        scatterplotPage.clickIntervals();
        scatterplotPage.clickIntervalsElement();
        String actual = scatterplotPage.textIntervals();
        Assert.assertEquals("25", actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
