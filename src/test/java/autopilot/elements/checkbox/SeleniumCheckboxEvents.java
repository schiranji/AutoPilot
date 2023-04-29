package autopilot.elements.checkbox;

import autopilot.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumCheckboxEvents extends BaseSelenium {
    public void clickCheckboxById(String id) {
        WebElement inputElem = getDriver().findElement(By.xpath("//input[@id='" + id +"']"));
        inputElem.click();
    }
    public WebElement checkboxById(String id) {
        return waitForPresent(By.id(id));
    }
}
