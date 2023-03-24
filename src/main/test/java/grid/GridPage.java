package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GridPage {
    public WebDriver driver;
    public String NAME_TABLE_PATTERN = "//b[@title='%s']";
    public String NAME_ICON_PATTERN = "//div[@class='text-center action-icon mr-2' and @title='%s']";

    public GridPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='+ Lines']")
    private WebElement iconLines;

    @FindBy(xpath = "//div[@class='lines-panel d-flex flex-column']")
    private WebElement menu;

    @FindBy(xpath = "//span[text()='BUY']")
    private WebElement element;


    @FindBy(xpath = "//div[contains(text(),'Order does not have any parameters.')]")
    private WebElement massage;

    public void clickElement() {
        element.click();
    }

    public void clickIconLines() {
        iconLines.click();
    }

    public boolean massageIsDisplayed() {
        return massage.isDisplayed();
    }

    public boolean menuIsDisplayed() {
        return menu.isDisplayed();
    }
}
