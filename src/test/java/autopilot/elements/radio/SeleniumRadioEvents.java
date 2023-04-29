package autopilot.elements.radio;

import autopilot.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumRadioEvents extends BaseSelenium {
    public void clickRadioButton(String label) {
        findByLabel(label).click();
    }
    public WebElement radioById(String id) {
        return waitForPresent(By.id(id));
    }
    public void clickRadioButtonById(String id) {
        WebElement inputElem = getDriver().findElement(By.xpath("//input[@id='" + id +"']"));
        inputElem.click();
    }
}
