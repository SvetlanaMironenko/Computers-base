package RootPage;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParentPage {
    private WebDriver driver;

    public ParentPage(WebDriver driver){
        this.driver = driver;
    }

    protected void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
//            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    private void highLightElementBorder(WebElement curElement) {
        String originalStyle = curElement.getAttribute("style");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", curElement, "style", originalStyle + "border: 2px solid darkorange;padding: 1px;");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Reset style
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", curElement, "style", originalStyle);
    }

    protected void scrollToElement(WebElement curElement) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, curElement);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebElement waitAndGetElement(int waitTimeInSec, final String locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(waitTimeInSec, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement curElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(locator));
            }
        });
        return curElement;
    }

    protected WebElement element(final String locator) {
        waitForPageLoaded();
        WebElement curElement = waitAndGetElement(30, locator);
        scrollToElement(curElement);
        highLightElementBorder(curElement);
        return curElement;
    }

    protected List<WebElement> findElements(String locator) {
        waitForPageLoaded();
        return driver.findElements(By.xpath(locator));
    }

    protected void check(String description, String actualValue, String expectedValue) {
        System.out.println(description);
        System.out.println("Actual value: '" + actualValue + "', expected value: '" + expectedValue + "'");
        if (actualValue.equals(expectedValue)) {
            System.out.println("Passed: Actual equals expected value");
        } else {
            System.out.println("Warning: Actual not equals");
        }
        System.out.println();
    }

    protected void check(String description, boolean actualValue, boolean expectedValue) {
        System.out.println(description);
        System.out.println("Actual value: '" + actualValue + "', expected value: '" + expectedValue + "'");
        if (actualValue == expectedValue) {
            System.out.println("Passed: Actual equals expected value");
        } else {
            System.out.println("Warning: Actual not equals");
        }
        System.out.println();
    }



}
