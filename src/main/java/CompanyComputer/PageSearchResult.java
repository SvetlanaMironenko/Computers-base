package CompanyComputer;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class PageSearchResult extends ParentPage {

    public PageSearchResult(WebDriver driver) {
        super(driver);
    }

    public void checkThePhraseNothingToDisplay() {
        check("Check nothing to display not present",
                element("//*[@class='well']//em").isDisplayed(),
                false);
    }

    public void checkComputerData(String nameComputer, LocalDate introducedDate, LocalDate currentDate, String company) {
        check("Check computer name",
                element("//a[text()='" + nameComputer + "']").getText(),
                nameComputer);

        check("Checking introduced",
                element("//a[text()='" + nameComputer + "']/../..//td[2]").getText(),
                String.valueOf(introducedDate));

        check("Checking discontinued",
                element("//a[text()='" + nameComputer + "']/../..//td[3]").getText(),
                String.valueOf(currentDate));

        check("Checking company",
                element("//a[text()='" + nameComputer + "']/../..//td[4]").getText(),
                company);
    }





}
