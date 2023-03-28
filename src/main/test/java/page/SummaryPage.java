package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
    public WebDriver driver;

    public SummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String NAME_TABLE_PATTERN = "//div[@class='app-title flex-1 widget__header' and text()='%s']";
    public String NAME_BUTTON_PATTERN = "//div[@class='app-title' and text()='%s']";
    public String INFORNATION_PATTERN = "//div[contains(text(),'%s')]";

}
