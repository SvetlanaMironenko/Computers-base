package MyTests;

import CompanyComputer.PageHome;
import CompanyComputer.PageNewComputer;
import CompanyComputer.PageSearchResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class CompanyComputerTests {

    private WebDriver driver;
    private PageHome pageHome;
    private PageNewComputer pageNewComputer;
    private PageSearchResult pageSearchResult;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers\\chromedriver85.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        pageHome = new PageHome(driver);
        pageNewComputer = new PageNewComputer(driver);
        pageSearchResult = new PageSearchResult(driver);

    }

    @Test
    public void checkAddComputerData() {
        driver.get("http://computer-database.gatling.io/computers");
        pageHome.clickOnTheAddComputerButton();
        LocalDate currentDate = LocalDate.now();
        LocalDate introducedDate = currentDate.minusYears(10);
        pageNewComputer.fillComputerData("SvetaAsus", introducedDate, currentDate, "Tandy Corporation");
        pageNewComputer.checkComputerData("SvetaAsus", introducedDate, currentDate, "Tandy Corporation");
        pageNewComputer.pushTheButtonCreateTheComputer();
        pageHome.checkThePhraseAboutAddingAComputer();
        pageHome.searchTheComputerData("SvetaAsus");
        pageSearchResult.checkThePhraseNothingToDisplay();
        pageSearchResult.checkComputerData("SvetaAsus", introducedDate, currentDate, "Tandy Corporation");
    }

    @Test
    public void checkingTheExistingComputer() {
        driver.get("http://computer-database.gatling.io/computers");
        pageHome.searchTheComputerData("ASCI White");
        LocalDate currentDate = LocalDate.now();
        LocalDate introducedDate = currentDate.minusYears(10);
        pageSearchResult.checkComputerData("ASCI White", introducedDate, currentDate, "IBM");
    }




}
