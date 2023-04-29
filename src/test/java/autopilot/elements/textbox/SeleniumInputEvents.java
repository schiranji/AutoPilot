package autopilot.elements.textbox;

import autopilot.BaseSelenium;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
public class SeleniumInputEvents extends BaseSelenium {
    private void sendKeys(WebElement element, String value, int currentCount) {
        try {
            element.sendKeys(value);
        } catch(ElementNotInteractableException e) {
            if(currentCount <= RETRY_COUNT) {
                sleepFor(RETRY_WAIT_SECONDS);
                sendKeys(element, value, ++currentCount);
                return;
            }
            throw e;
        }
    }
    private void sendKeys(WebElement element, String value) {
        sendKeys(element, value, 1);
    }
    public WebElement inputById(String id) {
        return elementByXpath("//input[@id='"+ id +"']");
    }
    public WebElement inputByName(String name) {
        return elementByXpath("//input[@name='"+ name +"']");
    }
    public WebElement inputByClass(String classs) {
        return elementByXpath("//input[@class='"+ classs +"']");
    }
    public void setTextBoxValueByLabel(String label, String value) {
        findByLabel(label).clear();
        sendKeys(findByLabel(label), value);
    }
    public void setTextBoxValueByLabel(String label, String value, String div) {
        findByLabel(label, div).clear();
        sendKeys(findByLabel(label, div), value);
    }
    public void setTextBoxValueByPlaceholder(String placeholder, String value, String div) {
        sendKeys(findByPlaceholder(placeholder, div), value);
    }
    public void setTextBoxValueByPlaceholder(String placeholder, String value) {
        sendKeys(findByPlaceholder(placeholder), value);
    }
    public void setTextBoxValueById(String id, String value) {
        sendKeys(inputById(id), value);
    }

    public void setTextBoxValue(WebElement element, String value) {
        sendKeys(element, value);
    }
    public void setTextBoxValueByName(String name, String value) {
        WebElement element = inputByName(name);
        element.clear();
        element.sendKeys(value);
    }

    public void searchForTypeaheadValue(String id, String value) {
        setTextBoxValue(waitForPresent(By.id(id)), value);
        sleepFor(TYPE_AHEAD_WAIT);
        inputById(id).clear();
        inputById(id).sendKeys(Keys.RETURN);
    }

    public void validatePlaceHolderText(String id, String text) {
        for(int i=0; i < RETRY_COUNT && !inputById(id).getAttribute("placeholder").equals(text);i++) {
            sleepForMillis(RETRY_WAIT_SECONDS);
        }
        Assert.assertEquals(text, inputById(id).getAttribute("placeholder"));
    }
    public void validateTextInInput(String label, String text) {
        Assert.assertEquals(text, findByLabel(label).getAttribute("value"));
    }
    public void validateTextInInput(String label, String text, String div) {
        Assert.assertEquals(text, findByLabel(label, div).getAttribute("value"));
    }
    public void validateTextInInputId(String id, String text) {
        Assert.assertEquals(waitForPresent(By.id(id)).getAttribute("value"), text);
    }
    public void validateTextInInputContains(String label, String text) {
        Assert.assertTrue(findByLabel(label).getAttribute("value").contains(text));
    }
}
