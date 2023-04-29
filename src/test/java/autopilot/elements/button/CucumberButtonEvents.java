package autopilot.elements.button;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CucumberButtonEvents extends SeleniumButtonEvents {
    @Then("I click {string} button id")
    public void clickButtonId(String id) {
        clickButtonById(id);
    }
    @Then("I click {string} button name")
    public void clickButtonName(String name) {
        clickButtonByName(name);
    }
    @Then("I click {string} {int} button name")
    public void clickButtonName(String name, int index) {
        clickButtonByName(name, index);
    }
    @Then("I click {string} button")
    public void clickButton(String text) {
        clickButtonByText(text);
    }
    @Then("I click {string} button in {string} div")
    public void clickButtonInDiv(String text, String div) {
        clickButtonByTextInDiv(text, div);
    }
    @Then("I see {string} button text {string}")
    public void validateButtonText(String id, String text) {
        Assert.assertEquals(buttonById(id).getText(), text);
    }
}
