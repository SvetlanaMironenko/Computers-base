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

    public void checkThePhraseAboutAddingAComputer() {
        check("Done ! Computer SvetaAsus has been created",
                element("//*[@class='alert-message warning']").getText(),
                "Done ! Computer SvetaAsus has been created");
    }

    public void searchTheComputerData(String nameComputer) {
        element("//*[@id='searchbox']").clear();
        element("//*[@id='searchbox']").sendKeys(nameComputer);
        element("//*[@id='searchsubmit']").click();
    }





















}
