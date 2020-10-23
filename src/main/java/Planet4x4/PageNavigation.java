package Planet4x4;

import RootPage.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class PageNavigation extends ParentPage {
    public PageNavigation(WebDriver driver) {
        super(driver);
    }

    public void clickMenuAuto(String nameAuto) {
        element("//*[text()='" + nameAuto +"']").click();
    }

    public void expandMenuOfAuto(String nameOfBrand) {
        element("//*[text()='" + nameOfBrand +"']//..//following-sibling::img").click();
    }

    public void toyotaMenu() {
        element("//*[@title='Тюнинг Toyota Auris (2007 - 2012)']").click();
    }

    public void parseAutoMenu() {
        waitForPageLoaded();
        List<WebElement> autos = findElements("//*[contains(@class,'pressit')]");
        HashMap<String,String> mapAutos = new HashMap<String, String>();
        for (WebElement currentAuto : autos) {
            String currentID = currentAuto.getAttribute("id");
            String currentName = currentAuto.getText();
            System.out.println("Auto = " + currentName + ", Id = " + currentID);
        }

    }

    public void goToAudiQ7() {
        expandMenuOfAuto("Audi");
        clickMenuAuto("Q7 (2015 - ...)");
    }


    private List<WebElement> getWebElementsOfCurrentBrand(String nameAuto) {
        String locator = "//*[text()='#model#']//ancestor::*[contains(@class,'button pressit')]//following-sibling::div[contains(@class,'spoiler')][1]//a";
//        locator = locator.replace("#model#", nameAuto);
//        return findElements(locator);
        locator = locator.replace("#model#", nameAuto);
        return findElements(locator.replace("#model#", nameAuto));

    }

    public void displayModelsOfBrand(String nameAuto) {
        waitForPageLoaded();
        List<WebElement> autos = getWebElementsOfCurrentBrand(nameAuto);
        System.out.println(autos.size());
        for (WebElement currentElement : autos) {
            String curName = currentElement.getText();
            System.out.println(curName);
//            System.out.println(currentElement.getText());
        }
    }

    public void InTheBasementClickOnInformation() {
        String informationCategories[] = {"Как заказать?", "Оплата", "Доставка", "Контакты"};
        String locator = "//*[text()='#categories#']";
        for (String currentCategories : informationCategories) {
            System.out.println(currentCategories);
            String tempLocator = locator.replace("#categories#", currentCategories);
            element(tempLocator).click();
        }
    }

    public void clickOnEachToyotaCar() {
        waitForPageLoaded();
        String[] modelAutoToyota = {"Auris (2007 - 2012)", "Auris (2012 - ...)", "Avalon (2005 - 2012)", "Avensis (1997 - 2002)", "Avensis (2003 - 2008)", "Avensis (2009 - ...)", "C-HR (2016 - ...)", "Camry 10 (1992 - 1996)", "Camry 20 (1997 - 2001)", "Camry 30 (2002 - 2006)", "Camry 40 (2006 - 2011)", "Camry 50 (2012 - ...)", "Camry 70 (2018 - ...)", "Carina E (1994 - 1998)", "Corolla (1992 - 1997)", "Corolla (1997 - 2002)", "Corolla (2002 - 2007)", "Corolla (2007 - 2012)", "Corolla (2013 - ...)", "FJ Cruiser (2006 - ...)", "Fortuner (2005 - ...)", "Hiace (1999 - 2009)", "Highlander (2007 - 2014)", "Highlander (2014 - ...)", "Hilux (2006 - 2015)", "Hilux (2015 - ...)", "Land Cruiser 100 (98 - 2006)", "Land Cruiser 200 (2007 - 2015)", "Land Cruiser 200 (2015 - ...)", "Land Cruiser 80 (90 - 97)", "Prado 120 (2003 - 2008)", "Prado 150 (2009 - 2017)", "Prado 150 (2018 - ... )", "Prado 90 (1996 - 2002)", "Previa (2001 - 2006)", "RAV4 (1994 - 2000)", "RAV4 (2001 - 2005)", "RAV4 (2006 - 2012)", "RAV4 (2013 - ...)", "Sequoia (2008 - ...)", "Solara (2002 - 2009)", "Yaris (2006 - 2012)", "Yaris (2012 - ...)"};
        String locator = "//*[text()='#model#']//ancestor::*[contains(@class,'button pressit')]//following-sibling::div[contains(@class,'spoiler')][1]//a";
        System.out.println(modelAutoToyota.length);
        for (String currentModelToyota : modelAutoToyota) {
            System.out.println(currentModelToyota);
            locator = locator.replace("model", currentModelToyota);
            element(locator).click();
        }
    }

    public void clickOnAllSubaruAutos() {
        String menuSubaruModel[] = {"Forester (2002 - 2007)", "Forester (2008 - 2012)", "Forester (2013 - ...)", "Outback (2003 - 2009)", "Outback (2009 - 2014)", "Outback (2014 - ...)", "XV (2012 - ...)"};
        for (int i = 0; i < menuSubaruModel.length; i++) {
            System.out.println(menuSubaruModel[i]);
            element("//*[text()='" + menuSubaruModel[i] + "']").click();
        }
    }

    public void clickOnAllPorscheAutos() {
        String menuPorscheModel[] = {"Boxster (1996 - ...)", "Cayenne (2002 - 2010)", "Cayenne II (2010 - ...)", "Cayman (2005 - ...)", "Panamera (2009 - ...)"};
        for (String currentPorscheModel : menuPorscheModel) {
            System.out.println(currentPorscheModel);
            element("//*[text()='" + currentPorscheModel + "']").click();
        }
    }

    public void clickMenuDaciaBrand() {
        String menuDaciaModel[] = {"Logan MCV (2005 - ...)", "Logan sedan (2005 - ...)"};
        String locator = "//*[text()='#model#']";
        for (String currentDaciaModel : menuDaciaModel) {
            System.out.println(currentDaciaModel);
            String tempLocator = locator.replace("#model#", currentDaciaModel);
            element(tempLocator).click();
//            element(locator.replace("#model#", currentDaciaModel)).click();
        }
    }

    public void clickMenuInfinitiBrand() {
        String menuInfinitiModel[] = {"EX (2007 - ...)", "FX-35, 45 (2003-2007)", "G (2000 - ...)", "JX (2012 - ...)", "M (2010 - ...)", "QX (2004 - ...)"};
        String locator = "//*[text()='#model#']";
        for (String currentInfinitiModel : menuInfinitiModel) {
            System.out.println(currentInfinitiModel);
            String tempLocator = locator.replace("#model#", currentInfinitiModel);
            element(tempLocator).click();
//            element(locator.replace("#model#", currentDaciaModel)).click();
        }
    }

    public void clickExceptInfinitiM() {
        String menuInfinitiModel[] = {"EX (2007 - ...)", "FX-35, 45 (2003-2007)", "G (2000 - ...)", "JX (2012 - ...)", "QX (2004 - ...)"};
        String locator = "//*[text()='#model#']";
        for (String currentInfinitiModel : menuInfinitiModel) {
            System.out.println(currentInfinitiModel);
            String tempLocator = locator.replace("#model#", currentInfinitiModel);
            if (currentInfinitiModel.equals("M (2010 - ...)")) {
                continue;
            }
            element(tempLocator).click();
        }
    }







}

