package ComparePricesOnSites;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class PageCarToyotaFortuner2005 extends ParentPage {

    public PageCarToyotaFortuner2005(WebDriver driver) {
        super(driver);
    }

    public void clickOnProduct() {
        element("//*[@href='https://planet4x4.com.ua/ruchka-akpp-i-razdatki-toyota-fortuner.html']").click();
    }


    public void priceComparison() {
        waitForPageLoaded();
        String locatorProduct = element("//*[text()='Ручка АКПП и раздатки для Toyota Fortuner (2005 - ...)']").getText();
        String locatorPrise = element("//*[text()='2171 грн']").getText().replace("грн", "").trim();
        System.out.println(locatorProduct + " " + locatorPrise);
    }




}
