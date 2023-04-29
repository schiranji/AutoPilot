package autopilot.elements.button;

import autopilot.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumButtonEvents extends BaseSelenium {
    public void clickButtonById(String id) {
        clickBy(By.id(id));
    }
    public void clickButtonByName(String name) {
        clickBy(By.name(name));
    }
    public void clickButtonByName(String name, int index) {
        clickBy(By.name(name), index);
    }
    public void clickButtonByText(String text) {
        clickBy(By.xpath("//button[text()='" + text +"' and not(ancestor::div[contains(@style,'display: none')])]"));
    }
    public void clickButtonByTextInDiv(String text, String div) {
        clickBy(By.xpath("//div[@id='" + div + "']//button[text()='" + text +"' and not(ancestor::div[contains(@style,'display: none')])]"));
    }

    public WebElement buttonById(String id) {
        return waitForPresent(By.id(id));
    }
}
