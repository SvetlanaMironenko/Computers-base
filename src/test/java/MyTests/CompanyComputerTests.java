package MyTests;

import CompanyComputer.PageHome;
import CompanyComputer.PageNewComputer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CompanyComputerTests {

    private WebDriver driver;
    private PageHome pageHome;
    private PageNewComputer pageNewComputer;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers\\chromedriver85.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        pageHome = new PageHome(driver);
        pageNewComputer = new PageNewComputer(driver);

    }

    @Test
    public void checkAddComputerData() {
        driver.get("http://computer-database.gatling.io/computers");
        pageHome.clickOnTheAddComputerButton();
        pageNewComputer.fillComputerData();
        pageNewComputer.checkComputerData("SvetaAsus");
        pageNewComputer.pushTheButtonCreateTheComputer();
        pageNewComputer.checkThePhraseAboutAddingAComputer();
        pageNewComputer.searchTheComputerData("SvetaAsus");
        pageNewComputer.checkThePhraseNothingToDisplay();
    }

    @Test
    public void checkingTheExistingComputer() {
        driver.get("http://computer-database.gatling.io/computers");
        pageNewComputer.searchTheComputerData("ASCI White");
        pageNewComputer.checkComputerDate("ASCI White");
    }




}
