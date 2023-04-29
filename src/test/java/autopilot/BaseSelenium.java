package autopilot;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseSelenium {
    protected static final String HOME_PAGE = "http://localhost:3000";
    //protected static final String MEDIA_TYPE = "image/png";
    protected static final int TYPE_AHEAD_WAIT = 5;
    protected static final int RETRY_WAIT_SECONDS = 1;
    protected static final int RETRY_COUNT = 3;
    public static final int PAGE_LOAD_WAIT_MILLIS = 500;
    protected SeleniumSetup seleniumSetup = new SeleniumSetup();
    public void setWebDriver() {
        seleniumSetup.setWebDriver();
    }
    protected WebDriver getDriver() {
        return seleniumSetup.getDriver();
    }
    protected Wait<WebDriver> getWait() {
        return seleniumSetup.getWait();
    }

    public void closeBrowser(Scenario scenario) {
        seleniumSetup.closeBrowser(scenario);
    }

    public WebElement findElement(By by) {
        if(findElements(by).size() > 1) {
            throw new AssertionError("Multiple elements found for specified criteria.");
        }
        return getDriver().findElement(by);
    }
    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public void validateUrlContains(String url) {
        getWait().until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(getDriver().getCurrentUrl().contains(url));
    }
    public void validateUrlStartWith(String url) {
        getWait().until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(getDriver().getCurrentUrl().startsWith(url));
    }

    public void gotoPage(String url) {
        getDriver().get(url);
        waitUntilPageLoad();
    }

    public void scrollToElementById(String id) {
        WebElement element = findElement(By.id(id));
                ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToElementByName(String name, int index) {
        WebElement element = findElements(By.name(name)).get(index);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToElementByTag(String tag) {
        WebElement element = findElement(By.tagName(tag));
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) getDriver()).executeScript(
                "window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollToTopOfPage() {
        ((JavascriptExecutor) getDriver()).executeScript(
                "window.scrollTo(0,0)");
    }

    public void matchDivText(String message, String divId) {
        //String divText = waitForPresent(By.id(divId)).getText();
        Assert.assertEquals(message, waitForPresent(By.id(divId)).getText());
    }

    public void waitUntilPageLoad() {
        getWait().until(d -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete"));
        getWait().until(d -> (boolean)((JavascriptExecutor) getDriver()).executeScript("return window.jQuery !== undefined && jQuery.active === 0"));
        sleepForMillis(PAGE_LOAD_WAIT_MILLIS);
    }

    //Helper Methods
    public void sleepFor(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
    public void sleepForMillis(int milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException e) {

        }
    }

    public WebElement waitForPresent(final By by) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        //return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private WebElement waitForClickable(final By by) {
        try {
            return getWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException | ElementClickInterceptedException e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getWait().until(ExpectedConditions.elementToBeClickable(by)));
            sleepFor(RETRY_WAIT_SECONDS);
            return getWait().until(ExpectedConditions.elementToBeClickable(by));
        }
    }
    private WebElement waitForClickable(final By by, int index) {
        WebElement element = findElements(by).get(index);
        try {
            return getWait().until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | ElementClickInterceptedException e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    getWait().until(ExpectedConditions.elementToBeClickable(element)));
            sleepFor(RETRY_WAIT_SECONDS);
            return getWait().until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public void clickBy(final By by) {
        try {
            waitForClickable(by).click();
        } catch (Exception e) {
            try {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", findElement(by));
            } catch (Exception e1) {
                Actions actions = new Actions(getDriver());
                actions.moveToElement(findElement(by)).click().build().perform();
            }
        }
    }
    public void clickBy(final By by, int index) {
        try {
            waitForClickable(by, index).click();
        } catch (ElementClickInterceptedException e) {
            String message = e.getMessage() + """
                    Possible causes:
                    1. WebElement to be clicked is disabled.
                    2. WebElement is not yet available (or loaded) on the web page.
                    3. WebElements overlap with each other.
                    4. Failure in locating WebElement using coordinates on the page.""";
            throw new ElementClickInterceptedException(message, e);
        }
    }
    public WebElement elementByXpath(String xpath) {
        return waitForPresent(By.xpath(xpath));
    }
    public List<WebElement> elementsByName(String name) {
         waitForPresent(By.name(name));
         return findElements(By.name(name));
    }


    public WebElement findByLabel(String label) {
        WebElement inputElem = waitForPresent(By.xpath("//label[text()='" + label +"']"));
        return waitForPresent(By.id(inputElem.getAttribute("for")));
    }

    public WebElement findByLabel(String label, String div) {
        WebElement inputElem = waitForPresent(By.xpath("//div[@id='" + div + "']//label[text()='" + label +"']"));
        return waitForPresent(By.id(inputElem.getAttribute("for")));
    }

    public WebElement findByPlaceholder(String label) {
        return waitForPresent(By.xpath("//input[@placeholder='" + label +"']"));
    }

    public WebElement findByPlaceholder(String placeholder, String div) {
        return waitForPresent(By.xpath("//div[@id='" + div + "']//input[@placeholder='" + placeholder +"']"));
    }

    public WebElement findByDisplayedLabel(String label) {
        WebElement inputElem = waitForPresent(By.xpath("//label[text()='" + label +"' and not(ancestor::div[contains(@style,'display: none')])]"));
        return waitForPresent(By.id(inputElem.getAttribute("for")));
    }

    public void switchToModalDialog(String modalId) {
        waitForPresent(By.id(modalId));
        getDriver().switchTo().activeElement();
    }

    public void waitForModalToClose(String modalClass) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.className(modalClass)));
    }

    public void selectTypeAheadOption(int index, String label) {
        sleepFor(2);
        WebElement elem = findByLabel(label);
        for(int i=0; i<index; i++) {
            elem.sendKeys(Keys.DOWN);
        }
        findByLabel(label).sendKeys(Keys.RETURN);
    }

    public void focusOnElementById(String id) {
        //WebElement inputElem = findElement(By.xpath("//input[@id='" + id +"']"));
        ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('"+id+"').focus();");
    }
    public void focusOnElement(String label) {
        WebElement inputElem = findByLabel(label);
        ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('"+inputElem.getAttribute("id")+"').focus();");
    }

    public void tagTextEquals(String tag, String text) {
        WebElement elem = findElement(By.xpath("//" + tag + "[text()=, '" + text + "')]"));
        Assert.assertEquals(text, elem.getAttribute("innerHTML"));
    }
    public void tagTextContains(String tag, String text) {
        WebElement elem = findElement(By.xpath("//" + tag + "[contains(text(), '" + text + "')]"));
        Assert.assertTrue(elem.getAttribute("innerHTML").contains(text));
    }

    public void tagTextContains(String tag, String text, int index) {
        WebElement elem = findElements(By.tagName(tag)).get(index);
        Assert.assertTrue(elem.getAttribute("innerHTML").contains(text));
    }

}
