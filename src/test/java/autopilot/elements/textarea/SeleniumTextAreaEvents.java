package autopilot.elements.textarea;

import autopilot.BaseSelenium;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

public class SeleniumTextAreaEvents extends BaseSelenium {
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
    protected void setTextAreaValue(String label, String value) {
        sendKeys(findByLabel(label), value);
    }

}
