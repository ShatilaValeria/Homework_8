package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement loginField;

    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwdField;

    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//button[@ class='app-blue-btn w-100']")
    private WebElement loginBtn;

    /**
     * определение входа в аккаунт
     */
    @FindBy(xpath = "//span[@class= 'header__user-name hidden-text' and text()='SELENIUM_CHROME']")
    private WebElement user;

    /**
     * определение неккоректных данных
     */
    @FindBy(xpath = "//span[text()='Bad credentials']")
    private WebElement noUserMassage;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public boolean clickFalseLoginBtn() {
        return loginBtn.isEnabled();
    }

    public boolean userCheck() {
        return user.isDisplayed();
    }

    public boolean massage() {
        return noUserMassage.isDisplayed();
    }
}
