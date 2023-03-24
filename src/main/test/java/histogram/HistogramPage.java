package histogram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistogramPage {
    public WebDriver driver;

    public HistogramPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//div[@class='autocomplete-container'])[1]")
    private WebElement attribute;

    @FindBy(xpath = "//(//div[@class='autocomplete-container'])[2]")
    private WebElement interval;

    @FindBy(xpath = "//div[@class='autocomplete-dropdown-menu-wrapper']")
    private WebElement menu;

    @FindBy(xpath = "//a[text()='Size']")
    private WebElement elementAttribute;

    @FindBy(xpath = "//a[text()='25']")
    private WebElement elementInterval;

    public void clickAttribute() {
        attribute.click();
    }

    public void clickInterval() {
        interval.click();
    }

    public boolean menuIsDisplayed() {
        return menu.isDisplayed();
    }

    public void clickElementAttribute() {
        elementAttribute.click();
    }

    public String textAttribute() {
        return attribute.getText();
    }

    public void clickElementInterval() {
        elementInterval.click();
    }

    public String textInterval() {
        return interval.getText();
    }
}
