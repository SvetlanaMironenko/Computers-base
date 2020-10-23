package MyTests;

import ComparePricesOnSites.PageCarToyotaFortuner2005;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestComparingPricesBetweenSites {

    private WebDriver driver;
    private PageCarToyotaFortuner2005 pageCarToyotaFortuner2005;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers\\chromedriver85.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        pageCarToyotaFortuner2005 = new PageCarToyotaFortuner2005(driver);


    }

    @Test
    public void comparisonOfPricesOnSites() {
        driver.get("https://planet4x4.com.ua/catalog/toyota/fortuner/");
        pageCarToyotaFortuner2005.clickOnProduct();
        pageCarToyotaFortuner2005.priceComparison();
    }






}
