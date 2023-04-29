package autopilot.elements.radio;

import io.cucumber.java.en.Then;

public class CucumberRadioEvents extends SeleniumRadioEvents {
    @Then("I click {string} radio")
    public void clickRadio(String label) {
        clickRadioButton(label);
    }
    @Then("I click {string} radio id")
    public void clickRadioById(String id) {
        clickRadioButtonById(id);
    }
}
