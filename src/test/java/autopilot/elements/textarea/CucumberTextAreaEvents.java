package autopilot.elements.textarea;

import io.cucumber.java.en.Then;

public class CucumberTextAreaEvents extends SeleniumTextAreaEvents {
    @Then("I enter {string} in textarea {string}")
    public void iEnterInTextarea(String value, String label) {
        setTextAreaValue(label, value);
    }
}
