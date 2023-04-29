package autopilot.elements.ahref;

import autopilot.BaseSelenium;
import org.openqa.selenium.By;

public class SeleniumAhrefEvents extends BaseSelenium {
    public void clickLinkById(String id) {
        clickBy(By.id(id));
    }

    public void clickLinkByText(String text) {
        clickBy(By.xpath("//a[text()='" + text +"']"));
    }
    public void clickLinkByTextContaining(String text) {
        clickBy(By.partialLinkText(text));
    }
}
