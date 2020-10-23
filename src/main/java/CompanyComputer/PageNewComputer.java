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

    public void fillComputerData(String nameComputer, LocalDate introducedDate, LocalDate currentDate, String company) {
        element("//*[@id='name']").sendKeys(nameComputer);
        element("//*[@id='introduced']").sendKeys(String.valueOf(introducedDate));
        element("//*[@id='discontinued']").sendKeys(String.valueOf(currentDate));
        Select dropdown = new Select(element("//select[@id='company']"));
        dropdown.selectByVisibleText(company);
    }

    public void checkComputerData(String nameComputer, LocalDate introducedDate, LocalDate currentDate, String company) {
        check("Check computer name",
                element("//*[@id='name']").getAttribute("value"),
                nameComputer);

        check("Checking introduced",
                element("//*[@id='introduced']").getAttribute("value"),
                String.valueOf(introducedDate));

        check("Checking discontinued",
                element("//*[@id='discontinued']").getAttribute("value"),
                String.valueOf(currentDate));

        Select select = new Select(element("//*[@id='company']"));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        check("Checking company", defaultItem, company);
    }

    public void pushTheButtonCreateTheComputer() {
        element("//*[@class='btn primary']").click();
    }










}
