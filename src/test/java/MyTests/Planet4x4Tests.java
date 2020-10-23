package MyTests;

import Planet4x4.PageCategory;
import Planet4x4.PageNavigation;
import Planet4x4.PageProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Planet4x4Tests {

    private WebDriver driver;
    private PageCategory pageCategory;
    private PageNavigation pageNavigation;
    private PageProduct pageProduct;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers\\chromedriver85.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        pageCategory = new PageCategory(driver);
        pageNavigation = new PageNavigation(driver);
        pageProduct = new PageProduct(driver);

    }

    @Test
    public void testClickToyota() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.clickMenuAuto("Toyota");
    }

    @Test
    public void parseAutos() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.parseAutoMenu();
    }

    @Test
    public void carToyota() {
        driver.get("https://planet4x4.com.ua/catalog/toyota/");
        pageNavigation.toyotaMenu();
        pageProduct.clickOnTheProduct("Эмблема неон в решетку радиатора или бампера Toyota Auris (2007 - 2012)");

    }

    @Test
    public void chooseStubsAudiQ7() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.goToAudiQ7();
        pageProduct.clickOnTheProduct("Заглушки в диски Audi Q7 (2015 - ...)");
        pageCategory.toReturn();
//        pageCategory.testProtected();
    }

    @Test
    public void clickMenuAutosSubaru() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.clickMenuAuto("Subaru");
        pageNavigation.clickOnAllSubaruAutos();
    }

    @Test
    public void clickMenuAutosSubaruAndPorsche() {
        driver.get("https://planet4x4.com.ua/");
        String subaru = "Subaru";
        pageNavigation.clickMenuAuto(subaru);
        pageNavigation.clickOnAllSubaruAutos();
        pageNavigation.clickMenuAuto("Porsche");
        pageNavigation.clickOnAllPorscheAutos();
    }

    @Test
    public void clickMenuDacia() {
        driver.get("https://planet4x4.com.ua/");
        String dacia = "Dacia";
        pageNavigation.clickMenuAuto(dacia);
        pageNavigation.clickMenuDaciaBrand();
    }

    @Test
    public void clickMenuInfiniti() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Infiniti");
        pageNavigation.clickMenuInfinitiBrand();
    }

    @Test
    public void clickInfinitiExceptOne() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.clickMenuAuto("Infiniti");
        pageNavigation.clickExceptInfinitiM();
    }

    @Test
    public void displayingTheNumberOfRenaultCars() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Renault");
        pageNavigation.displayModelsOfBrand("Renault");
    }

    @Test
    public void clickInformationMenu() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.InTheBasementClickOnInformation();
    }

    @Test
    public void multiplication(){
        int temp = numberMultiplication(2);
        System.out.println(temp);
    }
    private int numberMultiplication (int a) {
        int result = a * a;
        return result;
    }

    @Test
    public void countTheNumberOfBrands() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Toyota");
        pageNavigation.displayModelsOfBrand("Toyota");
    }

    @Test
    public void countTheNumberOfToyotaModels() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Toyota");
        pageNavigation.clickOnEachToyotaCar();
    }

    @Test
    public void displayProductsOnTheScreen() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Acura");
        pageNavigation.clickMenuAuto("MDX (2001 - ...)");
        int num = pageProduct.findOutHowManyProductsAreInTheCar();
        System.out.println(num);
    }

    @Test
    public void findOutTheNumberOfProducts() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Acura");
        pageNavigation.clickMenuAuto("MDX (2001 - ...)");
        pageProduct.displayingTheNumberOfProductsPerPage();
    }

    @Test
    public void makingAnArray() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Acura");
        pageNavigation.clickMenuAuto("MDX (2001 - ...)");
        List<String> names = pageProduct.getProductNamesFromPage();
        for (String currentProduct : names) {
            System.out.println(currentProduct);
        }
    }

    @Test
    public void displayingLongProductNames() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Acura");
        pageNavigation.clickMenuAuto("MDX (2001 - ...)");

        List<String> allProductsFromPage = pageProduct.getProductNamesFromPage();
        int num = allProductsFromPage.size();
        System.out.println("Total per page: " + num + " goods");
        for (String currentProduct : allProductsFromPage) {
            System.out.println(currentProduct);
        }
        System.out.println();

        pageProduct.checkTheNumberOfLettersInTheProduct(allProductsFromPage);
    }

    @Test
    public void checkPricesAtTheCar() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Acura");
        pageNavigation.clickMenuAuto("MDX (2001 - ...)");

        List<Double> allPricesOnThePage = pageProduct.checkPrices();
        for (Double currentPrice : allPricesOnThePage) {
            System.out.println(currentPrice);
        }
    }

    @Test
    public void displayProductsWithAPrice() {
        driver.get("https://planet4x4.com.ua/");
        pageNavigation.expandMenuOfAuto("Acura");
        pageNavigation.clickMenuAuto("MDX (2001 - ...)");

        HashMap<String, String> allProductsOnThePage = pageProduct.getProductsWithAPrice();
        for (HashMap.Entry<String, String> curProduct : allProductsOnThePage.entrySet()) {
            System.out.println(curProduct.getKey() + curProduct.getValue());
        }
    }


}

