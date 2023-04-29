package autopilot.elements.ahref;

import io.cucumber.java.en.Then;

public class CucumberAhrefEvents extends SeleniumAhrefEvents {
    @Then("I click {string} link")
    public void clickOnLinkWithText(String text) {
        clickLinkByText(text);
    }
    @Then("I click link containing {string}")
    public void clickOnLinkWithTextContaining(String text) {
        clickLinkByTextContaining(text);
    }
    @Then("I click {string} link id")
    public void clickOnLinkWithId(String id) {
        clickLinkById(id);
    }
}
