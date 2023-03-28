package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScatterplotPage {
    public WebDriver driver;
    public String NAME_PATTERN = "//input[@class='autocomplete-input ng-pristine ng-valid ng-touched' and @title='%s']";

    public ScatterplotPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid'])[1]")
    private WebElement xAttribute;

    @FindBy(xpath = "(//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid'])[2]")
    private WebElement yAttribute;

    @FindBy(xpath = "(//input[@class='autocomplete-input ng-untouched ng-pristine ng-valid'])[3]")
    private WebElement intervals;

    @FindBy(xpath = "//div[@class='autocomplete-dropdown-menu-wrapper']")
    private WebElement menu;

    @FindBy(xpath = "//a[text()='Size']")
    private WebElement elementXAttribute;

    @FindBy(xpath = "//a[text()='Shortfall']")
    private WebElement elementYAttribute;

    @FindBy(xpath = "//a[text()='25']")
    private WebElement elementInterval;


    public void clickXAttribute() {
        xAttribute.click();
    }

    public void clickYAttribute() {
        yAttribute.click();
    }

    public void clickIntervals() {
        intervals.click();
    }

    public boolean menuIsDisplayed() {
        return menu.isDisplayed();
    }

    public String textXAttribute() {
        return xAttribute.getText();
    }

    public String textYAttribute() {
        return yAttribute.getText();
    }

    public String textIntervals() {
        return intervals.getText();
    }

    public void clickXAttributeElement() {
        elementXAttribute.click();
    }

    public void clickYAttributeElement() {
        elementYAttribute.click();
    }

    public void clickIntervalsElement() {
        intervals.click();
    }
}
