package CompanyComputer;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;


public class PageNewComputer extends ParentPage {

    public PageNewComputer(WebDriver driver) {
        super(driver);
    }

    public void fillComputerData() {
        element("//*[@id='name']").sendKeys("SvetaAsus");
        LocalDate currentDate = LocalDate.now();
        LocalDate introducedDate = currentDate.minusYears(10);
        element("//*[@id='introduced']").sendKeys(String.valueOf(introducedDate));
        element("//*[@id='discontinued']").sendKeys(String.valueOf(currentDate));
        Select dropdown = new Select(element("//select[@id='company']"));
        dropdown.selectByVisibleText("Tandy Corporation");
    }

    public void checkComputerData(String nameComputer) {
        check("Check computer name",
                element("//*[@id='name']").getAttribute("value"),
                "SvetaAsus");

        LocalDate currentDate = LocalDate.now();
        LocalDate introducedDate = currentDate.minusYears(10);
        check("Checking introduced",
                element("//*[@id='introduced']").getAttribute("value"),
                String.valueOf(introducedDate));

        check("Checking discontinued",
                element("//*[@id='discontinued']").getAttribute("value"),
                String.valueOf(currentDate));

        Select select = new Select(element("//*[@id='company']"));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        check("Checking company", defaultItem, "Tandy Corporation");
    }

    public void pushTheButtonCreateTheComputer() {
        element("//*[@class='btn primary']").click();
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

    public void checkThePhraseNothingToDisplay() {
        check("Check nothing to display not present",
                element("//*[@class='well']//em").isDisplayed(),
                false);
    }

    public void checkComputerDate(String nameComputer) {
        check("Check computer name",
                element("//a[text()='ASCI White']").getText(),
        "ASCI White");

        check("Checking introduced",
                element("//a[text()='ASCI White']/../..//td[2]").getText(),
                "01 Jan 2001");

        check("Checking discontinued",
                element("//a[text()='ASCI White']/../..//td[3]").getText(),
                "01 Jan 2006");

        check("Checking company",
                element("//a[text()='ASCI White']/../..//td[4]").getText(),
                "IBM");
    }










}
