package Planet4x4Pages;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageProduct extends ParentPage {

    public PageProduct(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheProduct(String nameProduct) {
        String locator = "//*[contains(@title,'#product#')]";
        locator = locator.replace("#product#", nameProduct);
        element(locator).click();
    }

    public int findOutHowManyProductsAreInTheCar() {
        waitForPageLoaded();
        String locator = "//*[@class='goods_block']";
        int numberOfElements = findElements(locator).size();
        return numberOfElements;
    }

    public void displayingTheNumberOfProductsPerPage() {
        waitForPageLoaded();
        int numberOfProducts = findOutHowManyProductsAreInTheCar();
        String locator = "(//*[@class='header3'])[#index#]";
        for (int i = 1; i <= numberOfProducts; i++) {
            String currentLocator = locator.replace("#index#", String.valueOf(i));
            String currentName = element(currentLocator).getText();
            System.out.println("Product = " + currentName);
        }
    }

    public List<String> getProductNamesFromPage() {
        waitForPageLoaded();
        int numberOfProducts = findOutHowManyProductsAreInTheCar();
        String locator = "(//*[@class='header3'])[#index#]";
        List<String> productNames = new ArrayList<String>();
        for (int i = 1; i <= numberOfProducts; i++) {
            String currentLocator = locator.replace("#index#", String.valueOf(i));
            String currentName = element(currentLocator).getText();
            productNames.add(currentName);
        }
        return productNames;
    }

    public void checkTheNumberOfLettersInTheProduct(List<String> productNames) {
        int suitableProduct = 0;
        List<String> arrayOfNames = new ArrayList<String>();
        for (String currentName : productNames) {
            if (currentName.length() > 20) {
                suitableProduct++;
                arrayOfNames.add(currentName);
            }
        }

        System.out.println("Long names: " + suitableProduct);
        for (String currentProduct : arrayOfNames) {
            System.out.println(currentProduct);
        }
    }

    public List<Double> checkPrices() {
        waitForPageLoaded();
        int numberOfProducts = findOutHowManyProductsAreInTheCar();
        String locator = "(//*[@class='price'])[#index#]";
        List<Double> prices = new ArrayList<Double>();
        for (int i = 1; i <= numberOfProducts ; i++) {
            String currentLocator = locator.replace("#index#", String.valueOf(i));
            String currentPrice = element(currentLocator).getText().replace("грн", "").trim();
            prices.add(Double.parseDouble(currentPrice));
        }
        return prices;
    }

    public HashMap<String, String> getProductsWithAPrice() {
        waitForPageLoaded();
        int numberOfProducts = findOutHowManyProductsAreInTheCar();
        String locatorName = "(//*[@class='header3'])[#index#]";
        String locatorPrice = "(//*[@class='price'])[#index#]";
        HashMap<String, String> mepProducts = new HashMap<String, String>();
        for (int i = 1; i <= numberOfProducts ; i++) {
            String currentLocatorName = locatorName.replace("#index#", String.valueOf(i));
            String currentLocatorPrice = locatorPrice.replace("#index#", String.valueOf(i));
            String currentName = element(currentLocatorName).getText();
            String currentPrise = element(currentLocatorPrice).getText().replace("грн", "").trim();
            mepProducts.put(currentName, currentPrise);
        }
        return mepProducts;

    }





}
