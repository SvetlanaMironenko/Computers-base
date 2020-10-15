package CompanyComputer;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;

public class PageHome extends ParentPage {

    public PageHome(WebDriver driver) {
        super(driver);
    }

public void clickOnTheAddComputerButton() {
        element("//*[@class='btn success']").click();
}





















}
