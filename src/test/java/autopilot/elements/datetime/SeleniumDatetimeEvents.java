package autopilot.elements.datetime;

import autopilot.BaseSelenium;
import org.openqa.selenium.By;

public class SeleniumDatetimeEvents extends BaseSelenium {
    public void clickButtonByClass(String buttonClass) {
        clickBy(By.className(buttonClass));
    }

    public void selectTime(String list, String text) {
        clickBy(By.xpath("//ul[@aria-controls='"+list+"']//li[text()='"+text+"']"));
    }
}
