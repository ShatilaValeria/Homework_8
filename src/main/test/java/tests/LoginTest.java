package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://app.tca.deltixuat.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginTrue() {
        loginPage.inputLogin("selenium_chrome");
        loginPage.inputPasswd("Axa@Demo");
        loginPage.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean actual = loginPage.userCheck();
        Assert.assertTrue(actual);
    }

    @Test
    public void testLoginFalse() {
        loginPage.inputLogin("123");
        loginPage.inputPasswd("123");
        loginPage.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean actual = loginPage.massage();
        Assert.assertTrue(actual);
    }

    @Test
    public void testNoLogin() {
        loginPage.inputLogin("selenium_chrome");
        boolean actual = loginPage.clickFalseLoginBtn();
        Assert.assertFalse(actual);
    }

    @Test
    public void testNoPassword() {
        loginPage.inputPasswd("Axa@Demo");
        boolean actual = loginPage.clickFalseLoginBtn();
        Assert.assertFalse(actual);
    }

    @Test
    public void testNoPasswordAndNoLogin() {
        boolean actual = loginPage.clickFalseLoginBtn();
        Assert.assertFalse(actual);
    }

    @Test
    public void testButtonActivity() {
        loginPage.inputLogin("selenium_chrome");
        loginPage.inputPasswd("Axa@Demo");
        boolean actual = loginPage.clickFalseLoginBtn();
        Assert.assertTrue(actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}