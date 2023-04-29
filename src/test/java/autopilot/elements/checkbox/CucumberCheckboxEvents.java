package autopilot.elements.checkbox;

import io.cucumber.java.en.Then;

public class CucumberCheckboxEvents extends SeleniumCheckboxEvents {
    @Then("I click {string} checkbox id")
    public void clickCheckbox(String id) {
        clickCheckboxById(id);
    }
}
