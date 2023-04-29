package autopilot.elements.div;

import io.cucumber.java.en.Then;

public class CucumberDivEvents extends SeleniumDivEvents {
    @Then("I see div {string} display message {string}")
    public void validateDisplayMessage(String divId, String message) {
        validateDivMessage(divId, message);
    }
    @Then("I see div {string} contains text {string}")
    public void validateDivContainsText(String divId, String message) {
        selValidateDivContainsText(divId, message);
    }
    @Then("I see {string} div id show")
    public void validateDivShow(String divId) {
        divVisible(divId);
    }
}
