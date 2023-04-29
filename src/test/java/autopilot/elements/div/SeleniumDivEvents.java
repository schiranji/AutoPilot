package autopilot.elements.div;

import autopilot.BaseSelenium;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SeleniumDivEvents extends BaseSelenium {
    public void validateDivMessage(String divId, String message) {
        Assert.assertEquals(waitForPresent(By.id(divId)).getText(), message);
    }
    public void selValidateDivContainsText(String divId, String message) {
        Assert.assertTrue(waitForPresent(By.id(divId)).getText().contains(message));
    }
    public void divVisible(String divId) {
        Assert.assertTrue(waitForPresent(By.id(divId)).isDisplayed());
    }
}
