package autopilot.elements.span;

import autopilot.BaseSelenium;
import org.openqa.selenium.By;

public class SeleniumSpanEvents extends BaseSelenium {
    public void clickSpanByContainingText(String text) {
        clickBy(By.xpath("//span[contains(text(), '" + text +"')]"));
        //waitForPresent(By.xpath("//span[contains(text(), '" + text +"')]")).click();
    }
}
