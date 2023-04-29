package autopilot.elements.textbox;

import io.cucumber.java.en.Then;

public class CucumberTypeAheadEvents extends SeleniumInputEvents {
    @Then("I select option {int} in type ahead into {string}")
    public void iSelectOptionInTypeAheadInto(int index, String label) {
        selectTypeAheadOption(index, label);
    }
}
