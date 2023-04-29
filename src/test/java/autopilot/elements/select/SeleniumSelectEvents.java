package autopilot.elements.select;

import autopilot.BaseSelenium;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class SeleniumSelectEvents extends BaseSelenium {
    public Select selectById(String id) {
        return new Select(elementByXpath("//select[@id='"+ id +"' and not(ancestor::div[contains(@style,'display: none')])]"));
    }
    public Select selectByLabel(String label) {
        return new Select(findByLabel(label));
    }
    public Select selectByName(String id) {
        return new Select(elementByXpath("//select[@name='"+ id +"' and not(ancestor::div[contains(@style,'display: none')])]"));
    }
    public Select selectByClass(String id) {
        return new Select(elementByXpath("//select[@class='"+ id +"' and not(ancestor::div[contains(@style,'display: none')])]"));
    }
    public void setSelectValueById(String id, String value) {
        selectById(id).selectByValue(value);
    }
    public void setSelectValueByLabel(String label, String value) {
        selectByLabel(label).selectByValue(value);
    }
    public void setMultiSelectValueByLabel(String label, String value) {
        List<String> values = Arrays.asList(value.split("#"));
        values.forEach(val -> selectByLabel(label).selectByValue(val));
    }
}
