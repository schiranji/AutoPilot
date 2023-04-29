package autopilot.elements.span;

import io.cucumber.java.en.Then;

public class CucumberSpanEvents extends SeleniumSpanEvents {
    @Then("I click {string} span containing text")
    public void clickOnSpanContainingText(String text) {
        clickSpanByContainingText(text);
    }
}
